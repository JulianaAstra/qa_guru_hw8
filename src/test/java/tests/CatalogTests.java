package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.MainPage;

public class CatalogTests extends TestBase{
    MainPage mainPage;

    @BeforeEach
    void setupData() {
        mainPage = new MainPage();
    }

    @Test
    void sideMenuTest() {
        mainPage.openPage();
    }
}
