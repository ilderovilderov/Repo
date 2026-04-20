package webShop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    private final ElementsCollection computersButton = $$("ul.top-menu li a");
    private final SelenideElement desktopsButton = $(byText("Desktops"));

    @Step("Выбор категории товара из списка")
    public MainPage hoverComputersMenu() {
        computersButton.get(1).hover();
        return this;
    }

    @Step("Переход на страницу Desktops")
    public DesktopsPage selectDesktops() {
        desktopsButton.click();
        return new DesktopsPage();
    }
}
