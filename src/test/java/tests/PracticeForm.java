package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static utils.RandomUtils.*;


public class PracticeForm extends TestBase {

    @Test
    void textFields() {
        open(baseUrl);
        String firstName = getRandomString(10),
                lastName = getRandomString(8),
                email = getRandomEmail(),
                gender = getRandomGender(1, 1),
                mobile = getRandomPhone(),
                dayOfBirth = getRandomInt(10, 28) + "",
                monthOfBirth = getRandomMonth(1, 1),
                yearOfBirth = getRandomInt(1950, 2000) + "",
                subject1 = getRandomSubjects(1, 1),
                subject2 = getRandomSubjects(1, 1),
                hobby1 = "Sports",
                hobby2 = "Reading",
                hobby3 = "Music",
                state = "NCR",
                city = "Gurgaon",
                currentAddress = getRandomString(50);

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $(byText(gender)).click();
        $("#userNumber").setValue(mobile);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__day--0" + dayOfBirth).click();
        $("#subjectsInput").setValue(subject1).pressEnter().setValue(subject2).pressEnter();
        $(byText(hobby1)).click();
        $(byText(hobby2)).click();
        $(byText(hobby3)).click();
        $("#uploadPicture").uploadFromClasspath("img/che.png");
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue("N").pressEnter();
        $("#react-select-4-input").setValue("N").pressEnter();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $x("//td[text()='Student Name']").parent().shouldHave(text(firstName + " " + lastName));
        $x("//td[text()='Student Email']").parent().shouldHave(text(email));
        $x("//td[text()='Gender']").parent().shouldHave(text(gender));
        $x("//td[text()='Mobile']").parent().shouldHave(text(mobile));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
        $x("//td[text()='Subjects']").parent().shouldHave(text(subject1 + ", " + subject2));
        $x("//td[text()='Hobbies']").parent().shouldHave(text(hobby1 + ", " + hobby2 + ", " + hobby3));
        $x("//td[text()='Picture']").parent().shouldHave(text("che.png"));
        $x("//td[text()='Address']").parent().shouldHave(text(currentAddress));
        $x("//td[text()='State and City']").parent().shouldHave(text(state + " " + city));

    }


}
