package cloud.autotests.tests.cv.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static cloud.autotests.tests.TestBase.BASEURL;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    public static String
            //header menu locators and values
            headerGamesMenuName = "Игры",
            headerCompanyMenuName = "Компания",
            headerCarrierMenuName = "Карьера",
            headerLocaleMenuName = "EN",
            headerHistorySubMenuName = "История",
            headerVacanciesSubMenuName = "Вакансии",
            headerMenuSelector =".main-menu__link",
            headerMenuSearchSelector =".main-menu__search-icon--hover",
            headerSubmenuSelector = ".main-menu__sub-item",
            headerLogoMenuSelector = ".header__logo-img",
            headerMenuGradientImageSelector = ".games-page__header-images--gradient",
            headerMenuGradientImageValue = "https://playrix.com/f/img/ui/game/header/gradient_static.png",
            headerMenuMMImageSelector = ".games-page__header-images--MM",
            headerMenuMMImageValue = "https://playrix.com/f/img/ui/game/header/MM.png",
            headerMenuGrassImageSelector = ".games-page__header-images--grass",
            headerMenuGrassImageValue = "https://playrix.com/f/img/ui/game/header/grass1.png",
            headerMenuHouseImageSelector = ".games-page__header-images--house",
            headerMenuHouseImageValue = "https://playrix.com/f/img/ui/game/header/house.png",
            headerMenuAustinImageSelector = ".games-page__header-images--austin",
            headerMenuAustinImageValue = "https://playrix.com/f/img/ui/game/header/Austin.png",
            headerMenuCatImageSelector = ".games-page__header-images--cat",
            headerMenuCatImageValue = "https://playrix.com/f/img/ui/game/header/cat.png",
            headerMenuRixImageSelector = ".games-page__header-images--rix",
            headerMenuRixImageValue = "https://playrix.com/f/img/ui/game/header/rix.png",
            headerMenuPandaImageSelector = ".games-page__header-images--panda",
            headerMenuPandaImageValue = "https://playrix.com/f/img/ui/game/header/panda_static.png",
            headerNavbarSelector = ".header__menu.main-menu",
            //footer menu locators and values
            footerMenuConfidentialName = "Конфиденциальность",
            footerMenuContactsName = "Контакты",
            footerMenuSupportName = "Поддержка",
            footerMenuSelector = ".footer__link-gallery",
            footerSocialMenuSelector = ".footer__social-link",
            fbLink = "https://www.facebook.com/PlayrixGames",
            vkLink = "https://vk.com/playrix",
            twitterLink = "https://twitter.com/Playrix",
            linkedinLink =  "https://www.linkedin.com/company/playrix-entertainment",
            instagramLink = "https://www.instagram.com/playrix",
            youTubeLink = "https://www.youtube.com/user/Playrix",
            footerCopyrightSelector = ".footer__copyright",
            footerCopyrightValue = "© 2004—2021 Playrix";

    public static void openMainPage(){
        open(BASEURL);
    }

    public static void checkTheLogo() {
        $(headerLogoMenuSelector).should(exist).shouldBe(Condition.visible);
        $(headerMenuSearchSelector).should(exist);
    }

    public static void checkTopMenu(){
        $(headerNavbarSelector).should(exist)
                .shouldHave(
                text(headerGamesMenuName),
                text(headerCompanyMenuName),
                text(headerCarrierMenuName),
                text(headerLocaleMenuName));
        $(headerLogoMenuSelector).should(exist).shouldBe(Condition.visible);
    }

    public static void checkTopMenuSubmenus(){
        $$(headerMenuSelector).findBy(text(headerGamesMenuName)).should(exist).shouldBe(Condition.visible);
        $$(headerMenuSelector).findBy(text(headerCompanyMenuName)).hover();
        $$(headerSubmenuSelector).findBy(text(headerHistorySubMenuName)).should(exist);
        $$(headerMenuSelector).findBy(text(headerCarrierMenuName)).hover();
        $$(headerSubmenuSelector).findBy(text(headerVacanciesSubMenuName)).should(exist);
    }

    public static void checkHeaderImages(){
        $(headerMenuGradientImageSelector)
                .shouldHave(attribute("src", headerMenuGradientImageValue));
        $(headerMenuMMImageSelector)
                .shouldHave(attribute("src", headerMenuMMImageValue));
        $(headerMenuMMImageSelector)
                .shouldHave(attribute("src", headerMenuMMImageValue));
        $(headerMenuGrassImageSelector)
                .shouldHave(attribute("src", headerMenuGrassImageValue));
        $(headerMenuHouseImageSelector)
                .shouldHave(attribute("src", headerMenuHouseImageValue));
        $(headerMenuAustinImageSelector)
                .shouldHave(attribute("src", headerMenuAustinImageValue));
        $(headerMenuCatImageSelector)
                .shouldHave(attribute("src", headerMenuCatImageValue));
        $(headerMenuRixImageSelector)
                .shouldHave(attribute("src", headerMenuRixImageValue));
        $(headerMenuPandaImageSelector)
                .shouldHave(attribute("src", headerMenuPandaImageValue));
    }

    public static void checkFooterMenu(){
        $(footerMenuSelector).should(exist).shouldBe(Condition.visible)
                .shouldHave(
                text(footerMenuConfidentialName),
                text(footerMenuContactsName),
                text(footerMenuSupportName));
    }

    public static void checkSocialButtons(){
        ElementsCollection links = $$(footerSocialMenuSelector).snapshot();
        links.filter(Condition.href(fbLink)).shouldHave(CollectionCondition.size(1));
        links.filter(Condition.href(vkLink)).shouldHave(CollectionCondition.size(1));
        links.filter(Condition.href(twitterLink)).shouldHave(CollectionCondition.size(1));
        links.filter(Condition.href(linkedinLink)).shouldHave(CollectionCondition.size(1));
        links.filter(Condition.href(instagramLink)).shouldHave(CollectionCondition.size(1));
        links.filter(Condition.href(youTubeLink)).shouldHave(CollectionCondition.size(1));
    }

    public static void checkCopyright(){
        $(footerCopyrightSelector).should(exist).shouldBe(Condition.visible)
                .shouldHave(
                 text(footerCopyrightValue));
    }
}
