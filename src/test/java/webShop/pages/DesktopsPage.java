package webShop.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class DesktopsPage {

    private final ElementsCollection chooseDesk =  $$("div.product-grid div");

    public ProductPage chooseDesktop() {
        chooseDesk.get(0).click();
        return new ProductPage();
    }
}
