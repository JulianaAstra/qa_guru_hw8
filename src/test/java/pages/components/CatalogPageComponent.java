package pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CatalogPageComponent {

    SelenideElement filtersBlock = $(".filters-block__desktop");
    SelenideElement filterByPriceBtn = $(".dropdown-filter:not(.measurementContainer--GRwov > .dropdown-filter) .dropdown-filter__btn--priceU");
    SelenideElement filterDropdown = $(".dropdown-filter:not(.measurementContainer--GRwov > .dropdown-filter) .dropdown-filter__content");
    ElementsCollection priceInputs = $$(".dropdown-filter:not(.measurementContainer--GRwov > .dropdown-filter) .j-range");
    SelenideElement submitPriceBtn = $(".dropdown-filter:not(.measurementContainer--GRwov > .dropdown-filter) .filter .filter-btn");

    public CatalogPageComponent setFromPriceToInput(int price) {
        filterDropdown.shouldBe(visible);
        priceInputs
                .get(0)
                .doubleClick()
                .sendKeys(Keys.BACK_SPACE);
        priceInputs
                .get(0)
                .setValue(String.valueOf(price));

        return this;
    }

    public CatalogPageComponent submitPriceFilter() {
        filterDropdown.shouldBe(visible);
        submitPriceBtn.click();

        return this;
    }

    public CatalogPageComponent openPriceDropdown() {
        filtersBlock.shouldBe(visible);
        filterByPriceBtn.hover();

        return this;
    }

    public CatalogPageComponent checkFromPrice (int price) {
        String formattedPrice = String.format("%,d", price).replace(",", " ");
        filtersBlock.shouldBe(visible);
        filterByPriceBtn
                .shouldHave(text("от " + formattedPrice));

        return this;
    }
}
