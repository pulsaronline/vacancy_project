package cloud.autotests.tests.cv;

import cloud.autotests.tests.TestBase;
import cloud.autotests.tests.cv.api.Specs;
import cloud.autotests.tests.cv.pages.CvPage;
import cloud.autotests.tests.cv.pages.MainPage;

import cloud.autotests.tests.cv.pages.VacancyPage;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Story("job.playrix.com tests")
public class Tests extends TestBase {

    @Test
    @Owner("BessudnovMaksim")
    @Tag("ui")
    @DisplayName("UI sampling test: Check items on the main page")
    void mainPageUITest() {
        step("Open main page", MainPage::openMainPage);
        step("Check company logo", MainPage::checkTheLogo);
        step("Check top menu", MainPage::checkTopMenu);
        step("Check top menu submenus", MainPage::checkTopMenuSubmenus);
        step("Check header images", MainPage::checkHeaderImages);
        step("Check footer menu", MainPage::checkFooterMenu);
        step("Check social buttons", MainPage::checkSocialButtons);
        step("Check copyright", MainPage::checkCopyright);
    }

    @Test
    @Owner("BessudnovMaksim")
    @Tag("ui")
    @DisplayName("UI sampling test: Check items on the vacancies page")
    void vacancyPageUITest() {
        step("Open vacancy page", VacancyPage::openVacancyPage);
        step("Check company logo", MainPage::checkTheLogo);
        step("Check top menu", MainPage::checkTopMenu);
        step("Check footer menu", MainPage::checkFooterMenu);
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
        step("Open target page", CvPage::openCvPage);
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
        step("Check the company logo", MainPage::checkTheLogo);
        step("Check the top menu", MainPage::checkTopMenu);
        step("Check footer menu", MainPage::checkFooterMenu);
        step("Submit and send the form", CvPage::submitTheForm);
    }

    @Test
    @Owner("BessudnovMaksim")
    @Tag("api")
    //@Disabled("Example test code for further test development")
    @DisplayName("API sampling test: _______ playrix.com")
    void apiWebTest() {
        // open("https://playrix.com/games");
        // TODO: implement any API test
        // https://playrix.com/games
        Specs.request
                .when()
                .get("/job/open")
                .then()
                .spec(Specs.responseSpec)
                .log().body();
    }
}