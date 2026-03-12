package pageObject.demo.qa;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Subjects {
    private SelenideElement subject = $("#subjectsInput");
    private ElementsCollection subjectCollection = $$("[role=listbox] div");

    public Subjects addSubjects () {
        subject.setValue("A");
        subjectCollection.get(2).click();
        subject.setValue("Com");
        subjectCollection.get(0).click();
        return this;
    }
}
