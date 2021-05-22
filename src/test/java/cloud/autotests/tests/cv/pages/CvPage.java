package cloud.autotests.tests.cv.pages;

import com.codeborne.selenide.Condition;

import static cloud.autotests.tests.TestBase.BASEURL;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CvPage {
    static String respondButtonSelector = "Откликнуться";
    static String firstName = "Максим",
            firstNameSelector = "first_name";
    static String lastName = "Бессуднов",
            lastNameSelector = "last_name";
    static String email = "beslite@gmail.com",
            emailSelector = "email";
    static String phoneNumber = "+79263069330",
            phoneNumberSelector = "contact";
    static String about = "Здравствуйте! Опыт работы в качестве QA engineer 3 года. Ссылки на портфолио в моем CV.",
            aboutSelector = "cover_letter";
    static String checkboxSelector = "#js-agree";
    static String secondFilename = "CV_Bessudnov.pdf",
            secondFilenameSelector = "second_file";
    static String submitButtonSelector = "#js-apply";

    public static void openCvPage(){
        //open("https://job.playrix.com/");
        open(BASEURL);
        $(byText("Перейти к вакансиям")).click();
        $("#cat6").click();
        $(byText("QA Engineer, Engine")).click();
    }

    public static void openPageForm(){
        $(byText(CvPage.respondButtonSelector)).click();
    }

    public static void typeNames(){
        $(byName(firstNameSelector)).setValue(firstName);
        $(byName(firstNameSelector)).shouldBe(visible);
        $(byName(lastNameSelector)).setValue(lastName);
        $(byName(lastNameSelector)).shouldBe(visible);
    }

    public static void typeEmail() {
        $(byName(emailSelector)).setValue(email);
        $(byName(emailSelector)).shouldBe(visible);
    }

    public static void typePhoneNumber(){
        $(byName(phoneNumberSelector)).setValue(phoneNumber);
        $(byName(phoneNumberSelector)).shouldBe(visible);
    }

    public static void typeAbout(){
        $(byName(aboutSelector)).setValue(about);
        $(byName(aboutSelector)).shouldBe(visible);
    }

    public static void pressAgreementCheckbox(){
        $(checkboxSelector).click();
        $(checkboxSelector).shouldBe(visible);
    }

    public static void uploadCV(){
        $(byName(secondFilenameSelector)).uploadFromClasspath("cv/" + secondFilename);
    }

    public static void checkTheLogo() {
        $(".navbar-brand").should(exist);
        $(".navbar-brand").shouldBe(Condition.visible);
    }

    public static void checkTopMenu(){
        $("#navbar-ex1-collapse").should(exist);
        $("#navbar-ex1-collapse").shouldBe(Condition.visible).shouldHave(
                text("Главная"),
                text("Вакансии"),
                text("Курсы"),
                text("О компании"),
                text("FAQ"));
    }

    public static void submitTheForm(){
        //$(submitButtonSelector).click();
    }
}
