package pageObject.demo.qa;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PictureAndAddress {
    private SelenideElement picture = $("#uploadPicture");
    private SelenideElement address = $("#currentAddress");

    public PictureAndAddress addPictureAndAddress() {
        picture.uploadFromClasspath("obezgan.jpg");
        address.setValue("WWW LENINGRAD SBP TOCHKA RU");
        return this;
    }
}
