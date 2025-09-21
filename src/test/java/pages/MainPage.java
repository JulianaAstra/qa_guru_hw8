package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    String baseUrl = Configuration.baseUrl;
    SelenideElement menuBtn = $(".nav-element__burger");
    SelenideElement menuMain =  $(".menu-burger__main");
    SelenideElement mainPage = $("#app");

    public MainPage openPage() {
        open(baseUrl);
        mainPage.shouldBe(visible);
        return this;
    }

    public MainPage openSideMenu() {
        menuBtn
            .shouldBe(clickable)
            .click();

        menuMain.shouldBe(visible);
        return this;
    }
}
