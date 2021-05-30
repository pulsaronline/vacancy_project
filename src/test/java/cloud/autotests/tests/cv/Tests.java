package cloud.autotests.tests.cv;

import cloud.autotests.tests.TestBase;
import cloud.autotests.tests.cv.pages.CvPage;
import cloud.autotests.tests.cv.pages.MainPage;

import cloud.autotests.tests.cv.pages.VacancyPage;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import static io.qameta.allure.Allure.step;

@Story("job.playrix.com tests")
public class Tests extends TestBase {

    @Test
    @Owner("MaksimBessudnov")
    @Tag("ui")
    @DisplayName("UI test: Check items on the main page")
    void mainPageUITest() {
        step("Open main page", MainPage::openMainPage);
        step("Check the company logo", MainPage::checkTheLogo);
        step("Check the top menu", MainPage::checkTopMenu);
        step("Check the top menu submenus", MainPage::checkTopMenuSubmenus);
        step("Check the header images", MainPage::checkHeaderImages);
        step("Check footer menu", MainPage::checkFooterMenu);
        step("Check the social buttons", MainPage::checkSocialButtons);
        step("Check copyright", MainPage::checkCopyright);
    }

    @Test
    @Owner("MaksimBessudnov")
    @Tag("ui")
    @DisplayName("UI test: Check items on the vacancies page")
    void vacancyPageUITest() {
        step("Open vacancy page", VacancyPage::openVacancyPage);
        step("Check the company logo", MainPage::checkTheLogo);
        step("Check the top menu", MainPage::checkTopMenu);
        step("Check footer menu", MainPage::checkFooterMenu);
        step("Check footer menu", VacancyPage::vacanciesCheck);
    }

    @Test
    @Owner("MaksimBessudnov")
    @Tag("ui")
    @DisplayName("UI test: Fill, check and submit the target vacancy form")
    void cvPageFillAndCheckUITest() {
        step("Open target page", CvPage::openCvPage);
        step("Open the form", CvPage::openPageForm);
        step("Type First and Last names", CvPage::typeNames);
        step("Type email", CvPage::typeEmail);
        step("Type contact phone number", CvPage::typePhoneNumber);
        step("Type something about myself", CvPage::typeAbout);
        step("Press agreement checkbox", CvPage::pressAgreementCheckbox);
        step("Upload my CV", CvPage::uploadCV);
        step("Check the company logo", MainPage::checkTheLogo);
        step("Check the top menu", MainPage::checkTopMenu);
        step("Check footer menu", MainPage::checkFooterMenu);
        step("Submit and send the form", CvPage::submitTheForm);
    }

    @Test
    @Owner("MaksimBessudnov")
    @Tag("api")
    @Disabled("Example test code for further test development")
    @DisplayName("API test: _______ playrix.com")
    void apiWebTest() {
        // TODO: implement any API test
    }
}