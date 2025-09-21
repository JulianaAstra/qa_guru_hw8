package pages;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    String baseUrl = Configuration.baseUrl;

    public MainPage openPage() {
        open(baseUrl);
        return this;
    }
}
