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

    public static void openMainPage(){
        open(BASEURL);
    }

    public static void checkBottomMenu(){
        $(".links").should(exist);
        $(".links").shouldBe(Condition.visible).shouldHave(
                text("ИГРЫ"),
                text("ПОМОЩЬ"),
                text("КОМПАНИЯ"),
                text("КОНТАКТЫ"));
    }

    public static void checkSocialButtons(){
        $(".facebook").should(exist);
        $(".facebook").shouldBe(Condition.visible);
        $(".vk").should(exist);
        $(".vk").shouldBe(Condition.visible);
        $(".youtube").should(exist);
        $(".youtube").shouldBe(Condition.visible);
        $(".instagram").should(exist);
        $(".instagram").shouldBe(Condition.visible);
        $(".linkedin").should(exist);
        $(".linkedin").shouldBe(Condition.visible);
        $(".twitter").should(exist);
        $(".twitter").shouldBe(Condition.visible);
    }
    public static void checkDefaultButton(){
        $(byText(MainPage.defaultButtonSelector)).click();
    }
}
