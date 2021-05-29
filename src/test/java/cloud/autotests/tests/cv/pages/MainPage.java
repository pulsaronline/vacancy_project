package cloud.autotests.tests.cv.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static cloud.autotests.tests.TestBase.BASEURL;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    static String
            //top menu locators
            gamesTopMenuName = "Игры",
            companyTopMenuName = "Компания",
            carrierTopMenuName = "Карьера",
            historySubMenuName = "История",
            vacanciesSubMenuName = "Вакансии",
            topMenuSelector =".main-menu__link",
            topMenuSearchSelector =".main-menu__search-icon--hover",
            topSubmenuSelector = ".main-menu__sub-item",
            headerMenuSelector = ".header__logo-img",
            headerMenuImagesSelector = ".games-page__header-images--gradient",
            navbarSelector = ".header__menu.main-menu",
            //bottom menu locators
            linksMenuSelector = ".footer__link-gallery",
            footerSocialSelector = ".footer__social-link",
            fbLink = "https://www.facebook.com/PlayrixGames",
            vkLink = "https://vk.com/playrix",
            twitterLink = "https://twitter.com/Playrix",
            linkedinLink =  "https://www.linkedin.com/company/playrix-entertainment",
            instagramLink = "https://www.instagram.com/playrix",
            youTubeLink = "https://www.youtube.com/user/Playrix";



    public static void openMainPage(){
        open(BASEURL);
    }

    public static void checkTheLogo() {
        $(headerMenuSelector).should(exist).shouldBe(Condition.visible);
        $(topMenuSearchSelector).should(exist);
    }

    public static void checkTopMenu(){
        $(navbarSelector).should(exist)
                .shouldHave(
                        text("Игры"),
                        text("Компания"),
                        text("Карьера"),
                        text("EN"));
        $(headerMenuSelector).should(exist).shouldBe(Condition.visible);
    }

    public static void checkTopMenuSubmenus(){
        $$(topMenuSelector).findBy(text(gamesTopMenuName)).should(exist).shouldBe(Condition.visible);
        $$(topMenuSelector).findBy(text(companyTopMenuName)).hover();
        $$(topSubmenuSelector).findBy(text(historySubMenuName)).should(exist);
        $$(topMenuSelector).findBy(text(carrierTopMenuName)).hover();
        $$(topSubmenuSelector).findBy(text(vacanciesSubMenuName)).should(exist);
    }

    public static void checkHeaderImages(){
        $(headerMenuImagesSelector).isDisplayed();
        //$("img[class=games-page__header-images--gradient]").should(exist);
        //$(headerMenuImagesSelector).shouldHave(attribute("alt", "gradient"));

    }

    public static void checkFooterMenu(){
        $(linksMenuSelector).should(exist).shouldBe(Condition.visible)
                .shouldHave(
                text("Конфиденциальность"),
                text("Контакты"),
                text("Поддержка"));
    }

    public static void checkSocialButtons(){
        //$(".footer__social").should(exist);
        //$$(".footer__social-link").findBy(attribute("https://www.facebook.com/PlayrixGames")).should(exist).shouldBe(Condition.visible);
        $(footerSocialSelector).shouldHave(href(fbLink)).shouldHave(href(vkLink));
        /*$(footerSocialSelector).shouldHave(href(vkLink));
        $(footerSocialSelector).shouldHave(href(twitterLink));
        $(footerSocialSelector).shouldHave(href(linkedinLink));
        $(footerSocialSelector).shouldHave(href(instagramLink));
        $(footerSocialSelector).shouldHave(href(youTubeLink));*/

/*
        $(fbSelector).should(exist).shouldBe(Condition.visible);
        $(vkSelector).should(exist).shouldBe(Condition.visible);
        $(youTubeSelector).should(exist).shouldBe(Condition.visible);
        $(instagramSelector).should(exist).shouldBe(Condition.visible);
        $(linkedinSelector).should(exist).shouldBe(Condition.visible);
        $(twitterSelector).should(exist).shouldBe(Condition.visible);
*/
    }
}
