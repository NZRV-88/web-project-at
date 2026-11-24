package pages;

import org.openqa.selenium.By;

import java.util.Map;

/**
 * Страница заказа пиццы.
 * Реализует интерфейс Page для взаимодействия с элементами формы заказа.
 */
public class PizzaOrderPage extends BasePage implements Page {

    /** Локаторы полей ввода */
    private final Map<String, By> fields = Map.of(
            "Name", By.xpath("//input[@id=\":rd:\"]"),
            "Size", By.xpath("//div[@id=\":rf:\"]"),
            "Qty", By.xpath("//input[@id=\":rj:\"]"),
            "City", By.id(":r3:"),
            "Street", By.id(":r7:"),
            "PostCode", By.id(":r5:"),
            "House", By.id(":r9:"),
            "Apartment", By.id(":rb:")
    );

    /** Локаторы кнопок */
    private final Map<String, By> buttons = Map.of(
            "CreateOrder", By.xpath("//button[text()=\"Create Order\"]")
    );

    @Override
    public void fillField(String fieldName, String value) {
        By locator = fields.get(fieldName);
        fillField(locator, value);
    }

    @Override
    public void clickButton(String buttonName) {
        By locator = buttons.get(buttonName);
        click(locator);
    }

    @Override
    public void checkText(String fieldName, String value) {
        By locator = fields.get(fieldName);
        shouldHaveText(locator, value);
    }

    @Override
    public void checkTextByAttributeValue(String fieldName, String value) {
        By locator = fields.get(fieldName);
        shouldHaveTextByAttributeValue(locator, value);
    }

    @Override
    public void selectDropdown(String fieldName, String value) {
        By locator = fields.get(fieldName);
        select(locator, value);
    }
}
