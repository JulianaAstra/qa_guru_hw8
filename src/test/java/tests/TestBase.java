package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    MainPage mainPage = new MainPage();

    @BeforeAll
    static void setupConfig() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://www.wildberries.ru/";
    }

    @BeforeEach
    void openMainPage() {
        mainPage.openPage();
    }

    @AfterEach
    void closeDriver() {
        closeWebDriver();
    }
}
