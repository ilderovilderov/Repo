package webShop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    private final ElementsCollection computersButton = $$("ul.top-menu li a");
    private final SelenideElement desktopsButton =  $(byText("Desktops"));

    public DesktopsPage clickComputerButton() {
        computersButton.get(1).hover();
        desktopsButton.click();
        return new DesktopsPage();
    }
}
