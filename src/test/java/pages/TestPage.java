package pages;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TestPage {
    // ID
    SelenideElement password = $(By.id("passwordId"));

    // Attribute
    SelenideElement submit = $(byAttribute("data-testid", "submit"));

    // CSS
    SelenideElement username = $("#username");

    // Text
    SelenideElement main = $(byText("Главная"));

    // XPath
    SelenideElement xPath = $x("//*[@id='username']");


}
