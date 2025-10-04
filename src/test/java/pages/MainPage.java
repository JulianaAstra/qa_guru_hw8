package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.components.CatalogPageComponent;
import pages.components.MenuComponent;
import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class MainPage {
    SelenideElement menuBtn = $(".nav-element__burger");
    SelenideElement menuMain =  $(".menu-burger__main");
    SelenideElement navigationPanel = $("#basketContent");
    ElementsCollection navigationItems = $("#basketContent").$$(".navbar-pc__item ");
    SelenideElement header = $("#header");
    SelenideElement currency = $(".header__container .header__currency");
    SelenideElement currencyDropdown = $(".country__item");
    ElementsCollection currencies = $$(".country__item label");
    SelenideElement waitMessage = $("#wait_msg");
    ElementsCollection productCards = $$(".product-card");

    MenuComponent menuComponent = new MenuComponent();

    public MainPage openPage() {
        open("");
        waitMessage.shouldNotBe(visible, Duration.ofSeconds(8));
        productCards.shouldBe(sizeGreaterThan(0));
        return this;
    }

    public MainPage openSideMenu() {
        menuBtn
                .shouldBe(interactable)
                .shouldBe(visible)
                .hover()
                .shouldBe(clickable)
                .click();

        menuMain.shouldBe(visible);
        return this;
    }

    public MainPage checkNavigationPanel(String option) {
        navigationPanel
                .shouldBe(visible);
        navigationItems
                .find(text(option))
                .shouldBe(clickable);

        return this;
    }

    public MainPage chooseCurency(String option) {
        header.shouldBe(visible);
        currency
                .shouldBe(visible, interactable)
                .hover();

        currencies
                .find(text(option))
                .click();

        currencyDropdown.shouldNotBe(visible);
        return this;
    }

    public MainPage checkCurrencyDisplay(String option) {
        header.shouldBe(visible);
        currency.shouldHave(exactText(option));

        return this;
    }

    public CatalogPageComponent openPageFromCatalog(String section, String subsection) {
        menuComponent
                .chooseOption(section)
                .chooseSecondOption(subsection);

        return new CatalogPageComponent();
    }
}
