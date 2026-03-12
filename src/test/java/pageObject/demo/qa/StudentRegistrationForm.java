package pageObject.demo.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.page;

public class StudentRegistrationForm {
    @Test
    void homeWorkDemoQa() {

        Configuration.browserSize = "1920x1080";

        PersonalData personalData = page(PersonalData.class);
        Birth birth = page(Birth.class);
        Subjects subjects = page(Subjects.class);
        Hobbies hobbies = page(Hobbies.class);
        PictureAndAddress pictureAddress = page(PictureAndAddress.class);
        StateAndCity stateCity = page(StateAndCity.class);
        Verify verify = page(Verify.class);

        personalData.open().personalinfo();
        birth.dateOfBirth();
        subjects.addSubjects();
        hobbies.chooseHobbies();
        pictureAddress.addPictureAndAddress();
        stateCity.chooseStateAndCity();
        verify.checkText();


    }
}