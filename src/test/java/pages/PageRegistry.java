package pages;

import java.util.Map;
import java.util.function.Supplier;

import static com.codeborne.selenide.Selenide.open;

/**
 * Реестр страниц.
 * Хранит соответствие между именем страницы, её URL и конструктором.
 * Позволяет динамически загружать страницы по имени.
 */
public class PageRegistry {

    /** Маршруты (URL) страниц */
    private static final Map<String, String> routes = Map.of(
            "PizzaOrderPage", "http://localhost:5173/"
    );

    /** Фабрики страниц (поставщики экземпляров) */
    private static final Map<String, Supplier<Page>> pages = Map.of(
            "PizzaOrderPage", PizzaOrderPage::new
    );

    /**
     * Загружает страницу по имени.
     * Открывает браузер по соответствующему URL и возвращает объект страницы.
     *
     * @param pageName имя страницы (ключ в routes и pages)
     * @return объект запрошенной страницы
     */
    public static Page load(String pageName) {
        System.out.println("🟢 Открываю страницу: " + routes.get(pageName));
        open(routes.get(pageName));

        return pages.get(pageName).get();
    }
}