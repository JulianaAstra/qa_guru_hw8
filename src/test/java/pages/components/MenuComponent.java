package pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.MainPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MenuComponent {
    SelenideElement menu = $(".menu-burger__main");
    SelenideElement dropList = $(".menu-burger__first");
    ElementsCollection menuOptions = $$(".menu-burger__main-list li");
    ElementsCollection dropListOptions = $$(".menu-burger__set li");
    SelenideElement menuBtn = $(".nav-element__burger");

    public MenuComponent openMenu() {
        menuBtn
                .shouldBe(interactable)
                .shouldBe(visible)
                .hover()
                .shouldBe(clickable)
                .click();

        menu.shouldBe(visible);
        return this;
    }

    public MenuComponent openSubMenu(String option) {
        menu
            .shouldBe(visible, interactable);
        menuOptions
            .find(text(option))
            .hover();
        dropList.shouldBe(visible, interactable);

        return this;
    }

    public void chooseOptionInSubmenu(String option) {
        dropList.shouldBe(visible, interactable);
        dropListOptions
            .find(text(option))
            .click();
        menu.shouldNotBe(visible);
    }
}
