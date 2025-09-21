package tests;

import components.MenuComponent;
import data.Currency;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MainPage;

public class CatalogTests extends TestBase{
    MainPage mainPage;
    MenuComponent menuComponent;

    @BeforeEach
    void setupData() {
        mainPage = new MainPage();
        menuComponent = new MenuComponent();

        mainPage.openPage();
    }

    @ValueSource(strings = {
            "Анатомические модели",
            "Карты и глобусы"
    })

    @ParameterizedTest
    @DisplayName("Тест меню каталога")
    void sideMenuTest(String option) {
        mainPage
            .openSideMenu();

        menuComponent
            .chooseOption("Канцтовары")
            .chooseSecondOption(option);
    }

    @ValueSource(strings = {
            "Адреса",
            "Войти",
            "Корзина"
    })

    @ParameterizedTest
    @DisplayName("Элемент навигационной панели [{arguments}] отображается на главной без авторизации")
    void navMenuElementsUnauthoredTest(String option) {
        mainPage
            .checkNavigationPanel(option);
    }


    @EnumSource(Currency.class)
    @ParameterizedTest
    @DisplayName("Выбранная валюта [{arguments}] отображается в хедере на главной")
    void currencyDisplayInHeaderTest(Currency currency) {
        mainPage
            .chooseCurency(currency.description)
            .checkCurrencyDisplay(currency.name());
    }
}
