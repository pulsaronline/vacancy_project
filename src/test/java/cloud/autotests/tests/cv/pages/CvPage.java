package cloud.autotests.tests.cv.pages;

import static cloud.autotests.tests.TestBase.BASEURL;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CvPage {
    static String
            respondButtonSelector = "Откликнуться",
            firstName = "Максим",
            firstNameSelector = "first_name",
            lastName = "Бессуднов",
            lastNameSelector = "last_name",
            email = "beslite@gmail.com",
            emailSelector = "email",
            phoneNumber = "+79263069330",
            phoneNumberSelector = "contact",
            about = "Здравствуйте! Опыт работы в качестве QA engineer 3 года. Ссылки на портфолио в моем CV.",
            aboutSelector = "cover_letter",
            checkboxSelector = "#js-agree",
            secondFilename = "CV_Bessudnov.pdf",
            secondFilenameSelector = "second_file",
            submitButtonSelector = "#js-apply";

    public static void openCvPage(){
        //open("https://job.playrix.com/");
        open(BASEURL);
        $(byText("Перейти к вакансиям")).click();
        $("#cat6").click();
        $(byText("QA Engineer, Engine")).click();
    }

    public static void openPageForm(){
        $(byText(respondButtonSelector)).click();
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

    public static void submitTheForm(){
        //$(submitButtonSelector).click();
    }
}
