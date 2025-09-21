package tests;

import components.MenuComponent;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.MainPage;

public class CatalogTests extends TestBase{
    MainPage mainPage;
    MenuComponent menuComponent;

    @BeforeAll
    static void setPreconditions() {
        new MainPage()
            .openPage();
    }

    @BeforeEach
    void setupData() {
        mainPage = new MainPage();
        menuComponent = new MenuComponent();
    }

    @Test
    void sideMenuTest() {
        mainPage
            .openSideMenu();

        menuComponent
            .chooseOption("Канцтовары")
            .chooseSecondOption("Анатомические модели");
    }
}
