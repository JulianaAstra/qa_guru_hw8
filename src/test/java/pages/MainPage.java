package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.components.MenuComponent;
import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class MainPage {
    SelenideElement navigationPanel = $("#basketContent");
    ElementsCollection navigationItems = $("#basketContent").$$(".navbar-pc__item ");
    SelenideElement header = $("#header");
    SelenideElement currency = $(".header__container .header__currency");
    SelenideElement currencyDropdown = $(".country__item");
    ElementsCollection currencies = $$(".country__item label");
    SelenideElement waitMessage = $("#wait_msg");
    ElementsCollection productCards = $$(".product-card");
    SelenideElement loader = $(".general-preloader");

    MenuComponent menuComponent = new MenuComponent();

    public MainPage openPage() {
        open("");
        waitMessage.shouldNotBe(visible, Duration.ofSeconds(10));
        loader.shouldNotBe(visible, Duration.ofSeconds(8));
        productCards.shouldBe(sizeGreaterThan(0));
        return this;
    }

    public void checkNavigationPanel(String option) {
        navigationPanel
                .shouldBe(visible);
        navigationItems
                .find(text(option))
                .shouldBe(clickable);
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

    public void checkCurrencyDisplay(String option) {
        header.shouldBe(visible);
        currency.shouldHave(exactText(option));
    }

    public void openSideMenu() {
        menuComponent
                .openMenu();
    }

    public void openPageFromCatalog(String section, String subsection) {
        menuComponent
                .openSubMenu(section)
                .chooseOptionInSubmenu(subsection);
    }
}
