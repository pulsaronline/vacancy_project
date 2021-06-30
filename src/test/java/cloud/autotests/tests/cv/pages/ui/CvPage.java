package cloud.autotests.tests.cv.pages.ui;

import java.io.File;

import static cloud.autotests.tests.TestBase.BASEURL;
import static cloud.autotests.tests.TestBase.checkLocale;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CvPage {
    static String
            respondButtonSelector = "QA Engineer, Engine",
            firstNameValue = "Бессуднов Максим",
            attributeSelector = "placeholder",
            emailValue = "beslite@gmail.com",
            skypeValue = "thecelldweller",
            cityValue = "Москва",
            salaryValue = "100 000",
            attributeFirstNameValue = "Фамилия и имя",
            attributeEmailValue = "Эл. почта",
            attributeSkypeValue = "Скайп",
            attributeCityValue = "Из какого вы города?",
            checkboxOfficeSelector = "Офис",
            checkboxRemoteSelector = "Удаленно",
            whyYouInterestedInSelector = ".error-bubble",
            whyYouInterestedInErrorValue = "Мы хотели бы понимать, почему вам интересна наша компания",
            whyYouInterestedInAnswerValue = "1. Playrix это лидер на рынке игровой индустрии;\n" +
                                            "2. Есть возможность удаленной работы.",
            attributeWhereDidYouKnowAboutValue = "Откуда вы узнали о вакансии?",
            attributeWhereDidYouKnowAboutSourceValue = "HH",
            whyYouInterestedInValue = "Почему вам интересен Playrix?",
            aboutMyselfValueQueryValue = "Расскажите коротко о себе, добавьте ссылки на свои работы",
            attributeSalaryValue = "Пожелание по зарплате",
            phoneNumberValue = "+79263069330",
            phoneNumberAttributeValue = "Телефон",
            telegramIdValue = "@mBessudnov",
            telegramIdAttributeValue = "Telegram",
            uploadCVFileAttributeSelector = "file",
            uploadCVFileAttributeValue = "file",
            filename = "CV_mBessudnov.pdf",
            agreementCheckboxSelector = ".check__box",
            submitButtonSelector = ".all-jobs-form__button",
            aboutMyselfValue = "Здравствуйте!\nДля отправки Вам своего CV я использовал:\n" +
                    "IDE - Intellij idea community 2020.3\n"+
                    "Стек - Java8, Junit5, Selenide(UI тест), REST Assured(API тест)\n"+
                    "Отчетность - Allure report/Testops, Telegram, Slack\n"+
                    "CI - Jenkins";

    public static void openCvPage(){
        //open("https://job.playrix.com/");
        open(BASEURL);
        checkLocale();
        $(byText("Карьера")).click();
        sleep(300);
        $(byText("Вакансии")).click();
        sleep(300);
    }

    public static void openPageForm(){
        $(byText(respondButtonSelector)).click();
    }

    public static void typeName(){
        $(byAttribute(attributeSelector, attributeFirstNameValue))
                .scrollTo()
                .setValue(firstNameValue);
    }

    public static void typeEmail() {
        $(byAttribute(attributeSelector, attributeEmailValue))
                .setValue(emailValue);
    }

    public static void typeScype() {
        $(byAttribute(attributeSelector, attributeSkypeValue))
                .setValue(skypeValue);
    }

    public static void typeCity() {
        $(byAttribute(attributeSelector, attributeCityValue))
                .setValue(cityValue);
    }

    public static void typeSalary() {
        $(byAttribute(attributeSelector, attributeSalaryValue))
                .setValue(salaryValue);
    }

    public static void clickCheckboxes(){
        $(byText(checkboxOfficeSelector)).click();
        $(byText(checkboxRemoteSelector)).click();
    }

    public static void whereDidYouKnowAbout(){
        $(byAttribute(attributeSelector, attributeWhereDidYouKnowAboutValue)).click();
        $(byText(attributeWhereDidYouKnowAboutSourceValue)).click();
    }

    public static void whyYouInterestedIn(){
        $(byAttribute(attributeSelector, whyYouInterestedInValue)).setValue("a");
        $(whyYouInterestedInSelector).shouldHave(text(whyYouInterestedInErrorValue));
        $(byAttribute(attributeSelector, whyYouInterestedInValue))
                .setValue(whyYouInterestedInAnswerValue).pressTab();
    }

    public static void aboutMyself(){
        $(byAttribute(attributeSelector, aboutMyselfValueQueryValue))
                .setValue(aboutMyselfValue).pressEnter();
    }

    public static void typePhoneNumber(){
        $(byAttribute(attributeSelector, phoneNumberAttributeValue))
                .setValue(phoneNumberValue).pressTab();
    }

    public static void typeTelegramId(){
        $(byAttribute(attributeSelector, telegramIdAttributeValue))
                .setValue(telegramIdValue).pressEnter();
    }

    public static void pressAgreementCheckbox(){
        $(agreementCheckboxSelector).click();
        $(agreementCheckboxSelector).shouldBe(visible);
    }

    public static void uploadCV(){
        File file = new File("https://github.com/pulsaronline/vacancy_project/blob/450dd870427abebabae6123ca32334bee5f5caa6/src/test/resources/cv/CV_mBessudnov.pdf");
        $(byName(uploadCVFileAttributeSelector)).uploadFile(file);
//        $(byAttribute(uploadCVFileAttributeSelector, uploadCVFileAttributeValue))
//                .uploadFromClasspath("cv/" + filename);
    }

    public static void submitTheForm(){
        //$(submitButtonSelector).click();
    }
}
