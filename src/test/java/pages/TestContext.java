package pages;

/**
 * Хранит текущую страницу в рамках выполнения сценария.
 * Позволяет передавать контекст между шагами Cucumber.
 */
public class TestContext {

    /** Текущая активная страница */
    private static Page currentPage;

    /**
     * Устанавливает текущую страницу.
     * @param page объект страницы (PizzaOrderPage, CartPage и т.д.)
     */
    public static void setCurrentPage(Page page) {
        currentPage = page;
    }

    /**
     * Возвращает текущую страницу.
     * @return текущий Page Object
     */
    public static Page getCurrentPage() {
        return currentPage;
    }
}