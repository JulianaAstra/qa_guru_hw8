package components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MenuComponent {
    SelenideElement menu = $(".menu-burger__main");
    SelenideElement dropList = $(".menu-burger__drop-list");
    SelenideElement catalogTitle = $(".catalog-title");

    public MenuComponent chooseOption(String option) {
        menu
            .shouldBe(visible)
            .$$(".menu-burger__main-list li")
            .find(text(option))
            .hover();
        return this;
    }

    public void chooseSecondOption(String option) {
        dropList.shouldBe(visible)
            .$$(".menu-burger__set li")
            .find(text(option))
            .click();
        menu.shouldNotBe(visible);
        catalogTitle.shouldHave(text(option));
    }
}
