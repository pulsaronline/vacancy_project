package cloud.autotests.tests.cv;

import cloud.autotests.tests.TestBase;
import cloud.autotests.tests.cv.pages.CvPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Story("job.playrix.com tests")
public class Tests extends TestBase {


    @Test
    @Owner("MaksimBessudnov")
    @Tag("ui")
    @DisplayName("UI test: Fill, check and submit the target vacancy form")
    void cvPageFillAndTest() {
         /*String respondButtonSelector = "Откликнуться";
         String firstName = "Максим",
                firstNameSelector = "first_name";
         String lastName = "Бессуднов",
                lastNameSelector = "last_name";
         String email = "beslite@gmail.com",
                emailSelector = "email";
         String phoneNumber = "+79263069330",
                phoneNumberSelector = "contact";
         String about = "Здравствуйте! Опыт работы в качестве QA engineer 3 года. Ссылки на портфолио в моем CV.",
                aboutSelector = "cover_letter";
         String checkboxSelector = "#js-agree";
         String secondFilename = "CV_Bessudnov.pdf",
                secondFilenameSelector = "second_file";*/

//        step("Open target page", () -> open("https://job.playrix.com/open-positions/?vid=467"));
        step("Open target page", CvPage::openTargetVacancyPage);
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

        /*step("Open the form", () -> $(byText(respondButtonSelector)).click());

        step("Type Firstname", () -> {
            $(byName(firstNameSelector)).setValue(firstName);
            $(byName(firstNameSelector)).shouldBe(visible);
        });

        step("Type Lastname", () -> {
            $(byName(lastNameSelector)).setValue(lastName);
            $(byName(lastNameSelector)).shouldBe(visible);

        });

        step("Type email", () -> {
            $(byName(emailSelector)).setValue(email);
            $(byName(emailSelector)).shouldBe(visible);
        });

        step("Type contact phone number", () -> {
            $(byName(phoneNumberSelector)).setValue(phoneNumber);
            $(byName(phoneNumberSelector)).shouldBe(visible);
        });

        step("Type something about yourself", () -> {
            $(byName(aboutSelector)).setValue(about);
            $(byName(aboutSelector)).shouldBe(visible);
        });

        step("Press agreement checkbox", () -> {
            $(checkboxSelector).click();
            $(checkboxSelector).shouldBe(visible);
        });

        step("Upload my CV", () -> {
            $(byName(secondFilenameSelector)).uploadFromClasspath("cv/" + secondFilename);
        });*/
    }

    @Test
    @Owner("MaksimBessudnov")
    @Tag("ui")
    @DisplayName("UI test: Check items on the page")
    void mainPageTest() {
        step("Open target page", () -> open("https://job.playrix.com/open-positions/?vid=467"));

        step("Check the company logo", () -> {
            $(".navbar-brand").should(exist);
            $(".navbar-brand").shouldBe(Condition.visible);
        });

        step("Check the top menu", () -> {
            $("#navbar-ex1-collapse").should(exist);
            $("#navbar-ex1-collapse").shouldBe(Condition.visible).shouldHave(
                    text("Главная"),
                    text("Вакансии"),
                    text("Курсы"),
                    text("О компании"),
                    text("FAQ"));
        });
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