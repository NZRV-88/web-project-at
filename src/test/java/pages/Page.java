package pages;

/**
 * Контракт для всех Page Object классов.
 * Обеспечивает единообразный доступ к методам страниц через TestContext.
 */
public interface Page {

    /** Заполняет поле ввода значением */
    void fillField(String fieldName, String value);

    /** Нажимает кнопку */
    void clickButton(String buttonName);

    /** Проверяет текст элемента */
    void checkText(String fieldName, String value);

    /** Проверяет значение атрибута value у поля ввода */
    void checkTextByAttributeValue(String fieldName, String value);

    /** Выбирает значение из выпадающего списка */
    void selectDropdown(String fieldName, String value);
}
