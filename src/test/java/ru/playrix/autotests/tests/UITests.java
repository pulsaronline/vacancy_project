package ru.playrix.autotests.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.playrix.autotests.helpers.DriverHelper;
import ru.playrix.autotests.helpers.UIHelper;
import ru.playrix.autotests.tests.pages.ui.CvPage;
import ru.playrix.autotests.tests.pages.ui.GamesPage;
import ru.playrix.autotests.tests.pages.ui.VacancyPage;

import io.qameta.allure.Owner;
import io.qameta.allure.Story;

import static io.qameta.allure.Allure.step;

@Story("job.playrix.com UI tests")
public class UITests extends TestBase {

    @Test
    @Owner("BessudnovMaksim")
    @Tag("ui")
    @DisplayName("UI sampling test: Check items on the \"Games page\"")
    void mainPageUITest() {
        step("Init web driver", DriverHelper::configureDriver);
        step("Open main page", GamesPage::openMainPage);
        //step("Accept cookies", UIHelper::acceptCookies);
        step("Check company logo", GamesPage::checkTheLogo);
        step("Check top menu", GamesPage::checkTopMenu);
        step("Check top menu submenus", GamesPage::checkTopMenuSubmenus);
        step("Check header images", GamesPage::checkHeaderImages);
        step("Check games", GamesPage::checkGames);
        step("Check footer menu", GamesPage::checkFooterMenu);
        step("Check social buttons", GamesPage::checkSocialButtons);
        step("Check copyright", GamesPage::checkCopyright);
    }

    @Test
    @Owner("BessudnovMaksim")
    @Tag("ui")
    @DisplayName("UI sampling test: Check items on the \"Vacancies page\"")
    void vacancyPageUITest() {
        step("Init web driver", DriverHelper::configureDriver);
        step("Open vacancy page", VacancyPage::openVacancyPage);
        //step("Accept cookies", UIHelper::acceptCookies);
        step("Check company logo", GamesPage::checkTheLogo);
        step("Check top menu", GamesPage::checkTopMenu);
        step("Check footer menu", GamesPage::checkFooterMenu);
        step("Check header vacancies menu", VacancyPage::headerVacanciesCheck);
        step("Check body tags of the vacancies", VacancyPage::bodyVacanciesTagCheck);
        step("Check body names of the vacancies", VacancyPage::bodyVacanciesNamesCheck);
        step("Check footer FAQ section", VacancyPage::footerFaqSectionCheck);
    }

    @Test
    @Owner("BessudnovMaksim")
    @Tag("ui")
    @DisplayName("UI sampling test: Fill, check and submit the vacancy form")
    void cvPageFillAndCheckUITest() {
        step("Init web driver", DriverHelper::configureDriver);
        step("Open target page", CvPage::openCvPage);
        //step("Accept cookies", UIHelper::acceptCookies);
        step("Open the form", CvPage::openPageForm);
        step("Type First and Last names", CvPage::typeName);
        step("Type email", CvPage::typeEmail);
        step("Type skype id", CvPage::typeScype);
        step("Type city", CvPage::typeCity);
        step("Type desired salary", CvPage::typeSalary);
        step("Click checkboxes", CvPage::clickCheckboxes);
        step("Type where do i know about company", CvPage::whereDidYouKnowAbout);
        step("Type why i am interested in work in the company", CvPage::whyYouInterestedIn);
        step("Type about myself", CvPage::aboutMyself);
        step("Upload my CV", CvPage::uploadCV);
        step("Type contact phone number", CvPage::typePhoneNumber);
        step("Type contact phone number", CvPage::typeTelegramId);
        step("Press agreement checkbox", CvPage::pressAgreementCheckbox);
        step("Check the company logo", GamesPage::checkTheLogo);
        step("Check the top menu", GamesPage::checkTopMenu);
        step("Check footer menu", GamesPage::checkFooterMenu);
        step("Submit and send the form", CvPage::submitTheForm);
    }
}