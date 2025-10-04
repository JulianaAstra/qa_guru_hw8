package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.MainPage;

public class TestBase {
    MainPage mainPage = new MainPage();

    @BeforeAll
    static void setupConfig() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://www.wildberries.ru/";
        Configuration.timeout = 6000;
    }

    @BeforeEach
    void openMainPage() {
        mainPage.openPage();
    }
}
