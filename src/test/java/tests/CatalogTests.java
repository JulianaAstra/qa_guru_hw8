package tests;

import data.Currency;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MainPage;
import pages.components.CatalogPageComponent;

public class CatalogTests extends TestBase{
    MainPage mainPage = new MainPage();
    CatalogPageComponent catalogPage = new CatalogPageComponent();

    @CsvSource(value = {
            "Анатомические модели, 1000",
            "Карты и глобусы, 2000",
            "Офисные принадлежности, 500",
            "Письменные принадлежности, 300",
            "Счетный материал, 1500",
            "Торговые принадлежности, 5300",
            "Чертежные принадлежности, 10000"
    })
    @ParameterizedTest(name = "Фильтр по цене от {1} отображается на странице каталога {0}")
    @DisplayName("Фильтр по цене 'от' отображается на странице каталога")
    void filterByPriceFromDisplaysOnPage(String optionName, int price) {
        mainPage
                .openSideMenu()
                .openPageFromCatalog("Канцтовары", optionName);
        catalogPage
                .openPriceDropdown()
                .setFromPriceToInput(price)
                .submitPriceFilter()
                .checkFromPrice(price);
    }

    @ValueSource(strings = {
            "Адреса",
            "Войти",
            "Корзина"
    })
    @ParameterizedTest(name = "Элемент навигационной панели {0} отображается на главной без авторизации")
    @DisplayName("Элемент навигационной панели отображается на главной без авторизации")
    void navMenuElementDisplayUnauthoredTest(String option) {
        mainPage
                .checkNavigationPanel(option);
    }

    @EnumSource(Currency.class)
    @ParameterizedTest(name = "Выбранная валюта {0} отображается в хедере на главной")
    @DisplayName("Выбранная валюта отображается в хедере на главной")
    void currencyDisplayInHeaderTest(Currency currency) {
        mainPage
                .chooseCurency(currency.description)
                .checkCurrencyDisplay(currency.name());
    }
}
