package tests;

import data.Currency;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MainPage;

public class CatalogTests extends TestBase{
    MainPage mainPage = new MainPage();

    @CsvSource(value = {
            "Анатомические модели, 1000",
            "Карты и глобусы, 2000",
            "Офисные принадлежности, 500",
            "Письменные принадлежности, 300",
            "Счетный материал, 1500",
            "Торговые принадлежности, 5300",
            "Чертежные принадлежности, 10000"
    })
    @ParameterizedTest
    @DisplayName("Фильтр по цене от {price} отображается на странице каталога {optionName}")
    void filterByPriceFromDisplaysOnPage(String optionName, int price) {
        mainPage
                .openSideMenu()
                .openPageFromCatalog("Канцтовары", optionName)
                .setPriceStartsFrom(price)
                .checkStartPrice(price);
    }

    @ValueSource(strings = {
            "Адреса",
            "Войти",
            "Корзина"
    })
    @ParameterizedTest
    @DisplayName("Элемент навигационной панели [{arguments}] отображается на главной без авторизации")
    void navMenuElementDisplayUnauthoredTest(String option) {
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
