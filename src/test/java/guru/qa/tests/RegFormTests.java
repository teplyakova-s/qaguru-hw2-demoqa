package guru.qa.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.conditions.Text;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;

    }
    @Test
    void submitForm() {
        open("https://demoqa.com/automation-practice-form");
        $("#close-fixedban").click(); // close advertisement
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ivan.ivanov@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8123456789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--005:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("images/1.png");
        $("#currentAddress").setValue("Street, 1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();

        $("#submit").click();

        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $x("//td[text()='Student Name']").parent().shouldHave(text("Ivan Ivanov"));
        $x("//td[text()='Student Email']").parent().shouldHave(text("ivan.ivanov@gmail.com"));
        $x("//td[text()='Gender']").parent().shouldHave(text("Male"));
        $x("//td[text()='Mobile']").parent().shouldHave(text("8123456789"));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text("05 June,2000"));
        $x("//td[text()='Subjects']").parent().shouldHave(text("Computer Science"));
        $x("//td[text()='Hobbies']").parent().shouldHave(text("Sports"));
        $x("//td[text()='Picture']").parent().shouldHave(text("1.png"));
        $x("//td[text()='Address']").parent().shouldHave(text("Street, 1"));
        $x("//td[text()='State and City']").parent().shouldHave(text("Haryana Karnal"));
    }
}
