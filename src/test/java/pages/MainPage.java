package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    String baseUrl = Configuration.baseUrl;
    SelenideElement menuBtn = $(".nav-element__burger");
    SelenideElement menuMain =  $(".menu-burger__main");
    SelenideElement mainPage = $("#app");
    SelenideElement navigationPanel = $("#basketContent");
    SelenideElement header = $(".header__container");
    SelenideElement currency = $(".header__container .header__currency");
    SelenideElement currencyMenuHeader = $(".popup__header");
    SelenideElement currencyDropdown = $(".country__wrap");

    public MainPage openPage() {
        open(baseUrl);
        closePopUp();
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

    public MainPage checkNavigationPanel(String option) {
        navigationPanel
                .shouldBe(visible)
                .$$(".navbar-pc__item ")
                .find(text(option))
                .shouldBe(clickable);

        return this;
    }

    public MainPage chooseCurency(String option) {
        header.shouldBe(visible);
        currency
            .shouldBe(visible, interactable)
            .hover();

        currencyDropdown
            .$$(".radio-with-text__name")
            .find(text(option))
            .click();

        currencyDropdown.shouldNotBe(visible);
        return this;
    }

    public MainPage checkCurrencyDisplay(String option) {
        header.shouldBe(visible);
        currency.$(".simple-menu__currency").shouldHave(exactText(option));

        return this;
    }

    public void closePopUp() {
        sleep(4000);
        System.out.println($(".popup").isDisplayed());

        if ($(".popup").is(visible)) {
            $(".j-close popup__close close").click();
        }
        $(".popup").shouldNotBe(visible);
    }
}
