package cloud.autotests.tests.cv;

import cloud.autotests.tests.TestBase;
import cloud.autotests.tests.cv.pages.CvPage;
import cloud.autotests.tests.cv.pages.MainPage;

import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import static io.qameta.allure.Allure.step;

@Story("job.playrix.com tests")
public class Tests extends TestBase {


    @Test
    @Owner("MaksimBessudnov")
    @Tag("ui")
    @DisplayName("UI test: Fill, check and submit the target vacancy form")
    void cvPageFillAndCheckTest() {
        step("Open target page", CvPage::openCvPage);
        step("Open the form", CvPage::openPageForm);
        step("Type First and Last names", CvPage::typeNames);
        step("Type email", CvPage::typeEmail);
        step("Type contact phone number", CvPage::typePhoneNumber);
        step("Type something about yourself", CvPage::typeAbout);
        step("Press agreement checkbox", CvPage::pressAgreementCheckbox);
        step("Upload my CV", CvPage::uploadCV);
        step("Check the company logo", CvPage::checkTheLogo);
        step("Check the top menu", CvPage::checkTopMenu);
        step("Submit and send the form", CvPage::submitTheForm);
    }

    @Test
    @Owner("MaksimBessudnov")
    @Tag("ui")
    @DisplayName("UI test: Check items on the main page")
    void mainPageTest() {
        step("Open main page", MainPage::openMainPage);
        step("Check the company logo", CvPage::checkTheLogo);
        step("Check the top menu", CvPage::checkTopMenu);
        step("Check the respond button", MainPage::checkDefaultButton);
        step("Check the bottom menu", MainPage::checkBottomMenu);
        step("Check the social buttons", MainPage::checkSocialButtons);
    }

    @Test
    @Owner("MaksimBessudnov")
    @Tag("api")
    //@Disabled("Example test code for further test development")
    @DisplayName("API test: _______ playrix.com")
    void apiWebTest() {
        // TODO: implement any API test
    }
}