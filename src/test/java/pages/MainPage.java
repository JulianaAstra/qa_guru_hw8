package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import pages.components.MenuComponent;

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
    SelenideElement currencyDropdown = $(".country__item");

    SelenideElement filtersBlock = $(".filters-block__desktop");
    ElementsCollection filterByPriceBtns = $$(".dropdown-filter__btn--priceU");
    ElementsCollection filterDropdowns = $$(".dropdown-filter__content");

    MenuComponent menuComponent = new MenuComponent();

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
                .$$("label")
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

    public MainPage setPriceStartsFrom(int price) {
        filtersBlock.shouldBe(visible);
        filterByPriceBtns.get(1).hover();

        SelenideElement priceInput = filterDropdowns
                .get(1)
                .shouldBe(visible)
                .$(".filter__price")
                .$$(".j-range")
                .get(0);

        SelenideElement submitBtn = filterDropdowns
                .get(1)
                .$(".filter")
                .$(".filter-btn");

        priceInput.doubleClick();
        priceInput.sendKeys(Keys.BACK_SPACE);
        priceInput.setValue(String.valueOf(price));

        submitBtn.click();

        return this;
    }

    public MainPage checkStartPrice (int price) {
        String formattedPrice = String.format("%,d", price).replace(",", " ");
        filtersBlock
                .shouldBe(visible);
        filterByPriceBtns.get(1)
                .$(".dropdown-filter__btn-name")
                .shouldHave(text("от " + formattedPrice));

        return this;
    }

    public MainPage openPageFromCatalog(String section, String subsection) {
        menuComponent
                .chooseOption(section)
                .chooseSecondOption(subsection);
        return this;
    }
}
