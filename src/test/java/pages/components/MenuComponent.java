package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class MenuComponent {
    SelenideElement menu = $(".menu-burger__main");
    SelenideElement dropList = $(".menu-burger__drop-list");
    SelenideElement catalogTitle = $(".catalog-title");

    public MenuComponent chooseOption(String option) {
        menu
            .shouldBe(visible, interactable)
            .$$(".menu-burger__main-list li")
            .find(text(option))
            .hover();
        dropList.shouldBe(visible, interactable);
        return this;
    }

    public void chooseSecondOption(String option) {
        dropList.shouldBe(visible, interactable)
            .$$(".menu-burger__set li")
            .find(text(option))
            .click();
        menu.shouldNotBe(visible);
        catalogTitle.shouldHave(text(option));
    }
}
