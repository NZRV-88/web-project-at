package hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.*;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;

/**
 * Класс хуков для настройки и управления жизненным циклом тестов Cucumber.
 * Хуки автоматически выполняются до и после всех сценариев тестирования.
 * Обеспечивает настройку браузера, инициализацию Allure-отчетности
 * и корректное освобождение ресурсов после завершения тестов.
 * <p>
 * Класс автоматически подхватывается Cucumber через конфигурацию glue
 *
 * @see Hooks#setup() Настройка браузера и Allure перед тестами
 * @see Hooks#afterAll() Закрытие веб-драйвера после всех тестов
 */
public class Hooks {

    /**
     * Логгер для вывода информационных сообщений о работе хуков.
     */
    private static final Logger log = LoggerFactory.getLogger(Hooks.class);

    /**
     * Выполняется перед ВСЕМИ сценариями Cucumber.
     */
    @BeforeAll
    public static void setup() {
        Hooks.log.info("🔵 Установка конфигурации браузера");
        Configuration.browser = "chrome";
        Configuration.browserSize = "2560x1440";
        Configuration.timeout = 10_000;
        Configuration.headless = false;

        // Логирование всех действий Selenide в отчет Allure
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)      // Делать скриншоты при ошибках
                .savePageSource(false)    // Не сохранять HTML страницы (экономит место)
                .includeSelenideSteps(true)           // Логировать каждый шаг Selenide
        );
    }

    /**
     * Выполняется после каждого сценария Cucumber.
     * Прикрепляет скриншот к отчету Allure при падении теста.
     */
    @After
    public void addScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            if (WebDriverRunner.hasWebDriverStarted()) {
                try {
                    byte[] screenshot = ((TakesScreenshot) WebDriverRunner.getWebDriver())
                            .getScreenshotAs(OutputType.BYTES);

                    Allure.getLifecycle().addAttachment(
                            "Screenshot on failure",
                            "image/png",
                            "png",
                            new ByteArrayInputStream(screenshot)
                    );
                } catch (Exception e) {
                    log.error("Failed to take screenshot", e);
                }
            }
        }
    }

    /**
     * Выполняется один раз после завершения ВСЕХ сценариев Cucumber.
     */
    @AfterAll
    public static void afterAll() {
        log.info("🟡 Закрытие веб-драйвера");
        SelenideLogger.removeListener("AllureSelenide");
        Selenide.closeWebDriver();
    }
}