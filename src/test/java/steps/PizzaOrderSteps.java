package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import pages.Page;
import pages.PageRegistry;
import pages.TestContext;

/**
 * Шаги Cucumber для тестирования заказа пиццы.
 * Использует TestContext для хранения текущей страницы.
 */
public class PizzaOrderSteps {

    @Дано("загружаем страницу {string}")
    public void openPage(String pageName) {
        Page page = PageRegistry.load(pageName);
        TestContext.setCurrentPage(page);
    }

    @Когда("введем в поле {string} значение {string}")
    public void enterValueIntoField(String fieldName, String value) {
        TestContext.getCurrentPage().fillField(fieldName, value);
    }

    @Когда("выберем из выпадающего списка {string} значение {string}")
    public void selectValueFromDropdown(String fieldName, String value) {
        TestContext.getCurrentPage().selectDropdown(fieldName, value);
    }

    @Когда("нажмем на кнопку {string}")
    public void clickButton(String fieldName) {
        TestContext.getCurrentPage().clickButton(fieldName);
    }

    @Тогда("проверим, что в поле {string} содержится значение {string}")
    public void checkValueInField(String fieldName, String value) {
        TestContext.getCurrentPage().checkTextByAttributeValue(fieldName, value);
    }
}
