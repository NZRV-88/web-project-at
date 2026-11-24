package runner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;
/**
 * Точка входа для выполнения Cucumber‑тестов через JUnit5 Platform Engine.
 * <p>
 * Класс помечен аннотациями из пакета {@code org.junit.platform.suite.api},
 * которые позволяют сконфигурировать запуск тестов без написания обычного
 * <code>@Test</code>-метода. При запуске этого класса JUnit‑Engine
 * обнаруживает все файлы <code>.feature</code> в указанном каталоге
 * {@code "features"} и исполняет их с помощью Cucumber‑движка.
 * </p>
 *
 * <h2>Краткое описание используемых аннотаций</h2>
 * <ul>
 *   <li>{@link Suite} – объявляет класс «suite‑классом» JUnit‑Platform.
 *       Это аналог старого {@code @RunWith(Suite.class)} из JUnit4, но
 *       предназначен для JUnit5.</li>
 *
 *   <li>{@link IncludeEngines};#value = "cucumber"} – подключает
 *       Cucumber‑engine к текущему запуску. Без этой аннотации JUnit не будет знать,
 *       как обрабатывать файлы Cucumber.</li>
 *
 *   <li>{@link SelectClasspathResource};#value = "features"} – указывает
 *       директорию в class‑path, где находятся файлы <code>.feature</code>.
 *       По умолчанию берётся корень <code>src/test/resources</code>
 *
 *   <li>{@link ConfigurationParameter} (GLUE_PROPERTY_NAME) – задаёт параметр
 *       {@code cucumber.glue}.  Значение {@code "steps, hooks"} сообщает Cucumber,
 *       в каких пакетах искать step‑definition‑классы и хуки.  Пакеты должны
 *       совпадать с реальными расположениями классов (например,
 *       {@code steps.*} и {@code base.*}).</li>
 *
 *   <li>{@link ConfigurationParameter} (PLUGIN_PROPERTY_NAME) – задаёт
 *       параметр {@code cucumber.plugin}.  Плагин {@code pretty} выводит
 *       каждый шаг в консоль в человеко читаемом виде, а
 *       {@code io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm}
 *       регистрирует Allure‑адаптер, превращающий Cucumber‑шаги в Allure‑шаги
 *       и собирающий информацию для отчёта.</li>
 * </ul>
 */
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")

@ConfigurationParameter(
        key = GLUE_PROPERTY_NAME,
        value = "steps, hooks"
)
@ConfigurationParameter(
        key = PLUGIN_PROPERTY_NAME,
        value = "pretty, io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
)

public class TestRunner {
    // Тело класса остаётся пустым – все действие происходит
    // через JUnit‑Platform аннотации выше.
}
