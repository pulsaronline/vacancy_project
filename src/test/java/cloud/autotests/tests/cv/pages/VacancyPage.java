package cloud.autotests.tests.cv.pages;

import com.codeborne.selenide.Condition;

import static cloud.autotests.tests.TestBase.BASEURL;
import static cloud.autotests.tests.cv.pages.MainPage.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

public class VacancyPage {
    static String
            headerVacanciesButtonSelector = "Вакансии",
            headerVacanciesTagSelector = ".tags-list",
            VacanciesTagSelector = ".jobs-card__section-name",
            headerVacanciesTagAllVacanciesValue = "Все вакансии",
            headerVacanciesTagManagementValue = "Management",
            headerVacanciesTagGameDesignValue = "Game Design",
            headerVacanciesTagMarketingValue = "Marketing",
            headerVacanciesTagBusinessDevelopmentValue = "Business Development",
            headerVacanciesTagMarketingCreativesValue = "Marketing Creatives",
            headerVacanciesTagArtValue = "Art",
            headerVacanciesTagAnimationVFXValue = "Animation & VFX",
            headerVacanciesTagAnalyticsValue = "Analytics",
            headerVacanciesTagCppDevelopmentValue = "С++ Development",
            headerVacanciesTagPythonDevelopmentValue = "Python Development",
            headerVacanciesTagFrontEndDevelopmentValue = "Front-end Development",
            headerVacanciesTagITValue = "IT",
            headerVacanciesTagQAValue = "QA",
            headerVacanciesTagFinanceAndLegalValue = "Finance & Legal",
            headerVacanciesTagHRAndRecruitingValue = "HR & Recruiting",
            headerVacanciesTagPRValue = "PR",
            headerVacanciesTagAdministrationValue = "Administration",
            headerVacanciesTagCommunityAndSupportValue = "Community & Support",
            headerVacanciesTagLocalizationValue = "Localization";

    public static void openVacancyPage() {
        open(BASEURL);
        $$(headerMenuSelector).findBy(text(headerCarrierMenuName)).hover();
        $$(headerSubmenuSelector).findBy(text(headerVacanciesSubMenuName)).should(exist);
        $(byText(headerVacanciesButtonSelector)).click();
    }

    public static void vacanciesCheck() {
        vacanciesCheckBySelector(headerVacanciesTagSelector);
        vacanciesCheckBySelector(VacanciesTagSelector);
    }

    static void vacanciesCheckBySelector(String selector){
        $(selector).shouldHave(text(headerVacanciesTagAllVacanciesValue),
                text(headerVacanciesTagManagementValue),
                text(headerVacanciesTagGameDesignValue),
                text(headerVacanciesTagMarketingValue),
                text(headerVacanciesTagBusinessDevelopmentValue),
                text(headerVacanciesTagMarketingCreativesValue),
                text(headerVacanciesTagArtValue),
                text(headerVacanciesTagAnimationVFXValue),
                text(headerVacanciesTagAnalyticsValue),
                text(headerVacanciesTagCppDevelopmentValue),
                text(headerVacanciesTagPythonDevelopmentValue),
                text(headerVacanciesTagFrontEndDevelopmentValue),
                text(headerVacanciesTagITValue),
                text(headerVacanciesTagQAValue),
                text(headerVacanciesTagFinanceAndLegalValue),
                text(headerVacanciesTagHRAndRecruitingValue),
                text(headerVacanciesTagPRValue),
                text(headerVacanciesTagAdministrationValue),
                text(headerVacanciesTagCommunityAndSupportValue),
                text(headerVacanciesTagLocalizationValue));
    }
}
