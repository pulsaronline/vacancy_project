package cloud.autotests.tests.cv.pages;

import com.codeborne.selenide.Condition;

import static cloud.autotests.tests.TestBase.BASEURL;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class VacancyPage {
    static String defaultButtonSelector = "Перейти к вакансиям";

    public static void openVacancyPage(){
        open(BASEURL);
        $(byText(defaultButtonSelector)).click();
    }

    public static void vacanciesCheck(){

    }
}
