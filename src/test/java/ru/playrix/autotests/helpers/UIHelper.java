package ru.playrix.autotests.helpers;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class UIHelper {
    public static void checkLocale(){
        if($(".header__menu.main-menu").shouldHave(text("RU")).isDisplayed()) {
            $(byText("RU")).click();
        }
    }

    public static void acceptCookies(){
        $$(".popup-cookies__btn.btn.btn--green").findBy(text("Принять")).click();
    }
}
