package data;

public enum Currency {
    BYN("Белорусский рубль"),
    RUB("Российский рубль"),
    KZT("Казахстанский тенге"),
    AMD("Армянский драм"),
    KGS("Кыргызский сом"),
    UZS("Узбекский сум"),
    TJS("Таджикский сомони");

    public final String description;

    Currency(String description) {
        this.description = description;
    }
}
