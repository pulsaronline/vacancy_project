package cloud.autotests.tests.cv.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static cloud.autotests.tests.TestBase.BASEURL;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    static String defaultButtonSelector = "Перейти к вакансиям";
    static String headerMenuSelector = ".navbar-brand";
    static String bottomMenuSelector = ".logo_footer";
    static String navbarSelector = "#navbar-ex1-collapse";
    static String linksMenuSelector = ".links";
    static String fbSelector = ".facebook";
    static String vkSelector = ".vk";
    static String youTubeSelector = ".youtube";
    static String instagramSelector = ".instagram";
    static String linkedinSelector =  ".linkedin";
    static String twitterSelector = ".twitter";

    public static void openMainPage(){
        open(BASEURL);
    }

    public static void checkTheLogo() {
        $(headerMenuSelector).should(exist).shouldBe(Condition.visible);
        $(bottomMenuSelector).should(exist).shouldBe(Condition.visible);
    }

    public static void checkTopMenu(){
        $(navbarSelector).should(exist).shouldBe(Condition.visible)
                .shouldHave(
                text("Главная"),
                text("Вакансии"),
                text("Курсы"),
                text("О компании"),
                text("FAQ"));
    }

    public static void checkBottomMenu(){
        $(linksMenuSelector).should(exist).shouldBe(Condition.visible)
                .shouldHave(
                text("ИГРЫ"),
                text("ПОМОЩЬ"),
                text("КОМПАНИЯ"),
                text("КОНТАКТЫ"));
    }

    public static void checkSocialButtons(){
        $(fbSelector).should(exist).shouldBe(Condition.visible);
        $(vkSelector).should(exist).shouldBe(Condition.visible);
        $(youTubeSelector).should(exist).shouldBe(Condition.visible);
        $(instagramSelector).should(exist).shouldBe(Condition.visible);
        $(linkedinSelector).should(exist).shouldBe(Condition.visible);
        $(twitterSelector).should(exist).shouldBe(Condition.visible);
    }

    public static void checkDefaultButton(){
        $(byText(defaultButtonSelector)).click();
    }
}
