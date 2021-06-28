package cloud.autotests.tests.cv;

import cloud.autotests.helpers.DriverHelper;
import cloud.autotests.tests.TestBase;
import cloud.autotests.tests.cv.pages.api.Specs;
import cloud.autotests.tests.cv.pages.ui.CvPage;
import cloud.autotests.tests.cv.pages.ui.MainPage;

import cloud.autotests.tests.cv.pages.ui.VacancyPage;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Story("job.playrix.com tests")
public class Tests extends TestBase {

    @Test
    @Owner("BessudnovMaksim")
    @Tag("ui")
    @DisplayName("UI sampling test: Check items on the main page")
    void mainPageUITest() {
        step("Init web driver", DriverHelper::configureDriver);
        step("Open main page", MainPage::openMainPage);
        step("Accept cookies", TestBase::acceptCookies);
        step("Check company logo", MainPage::checkTheLogo);
        step("Check top menu", MainPage::checkTopMenu);
        step("Check top menu submenus", MainPage::checkTopMenuSubmenus);
        step("Check header images", MainPage::checkHeaderImages);
        step("Check games", MainPage::checkGames);
        step("Check footer menu", MainPage::checkFooterMenu);
        step("Check social buttons", MainPage::checkSocialButtons);
        step("Check copyright", MainPage::checkCopyright);
    }

    @Test
    @Owner("BessudnovMaksim")
    @Tag("ui")
    @DisplayName("UI sampling test: Check items on the vacancies page")
    void vacancyPageUITest() {
        step("Init web driver", DriverHelper::configureDriver);
        step("Open vacancy page", VacancyPage::openVacancyPage);
        step("Accept cookies", TestBase::acceptCookies);
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
        step("Init web driver", DriverHelper::configureDriver);
        step("Open target page", CvPage::openCvPage);
        step("Accept cookies", TestBase::acceptCookies);
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
    @DisplayName("API sampling test: check the fields and error messages at page\"\"QA Engineer, Engine\"")
    void apiQAEngineerPageFieldsAndErrorMessagesTest() {
        open();
        Specs.request
                .when()
                .get("/api/v1/index.php?vacancyFormBuilder/getList")
                .then()
                // name, surname and error message fields check
                .body("items[0].id", is(1056))
                .body("items[0].name", is("Фамилия и имя"))
                .body("items[0].label", is("Фамилия и имя"))
                .body("items[0].isRequire", is(true))
                .body("items[0].errorMessage", is("Нам нужно знать, как к вам обращаться"))
                .body("items[0].type", is("input"))
                // email and error message fields check
                .body("items[1].id", is(1057))
                .body("items[1].name", is("email"))
                .body("items[1].label", is("Эл. почта"))
                .body("items[1].isRequire", is(true))
                .body("items[1].errorMessage", is("Чтобы с вами связаться, нам нужно знать ваш адрес электронной почты"))
                .body("items[1].type", is("email"))
                // skype and error message fields check
                .body("items[2].id", is(1058))
                .body("items[2].name", is("skype"))
                .body("items[2].label", is("Скайп"))
                .body("items[2].isRequire", is(true))
                .body("items[2].errorMessage", is("Чтобы с вами связаться, нам нужно знать ваш скайп"))
                .body("items[2].type", is("input"))
                // city and error message fields check
                .body("items[3].id", is(1059))
                .body("items[3].name", is("Город"))
                .body("items[3].label", is("Из какого вы города?"))
                .body("items[3].isRequire", is(true))
                .body("items[3].errorMessage", is("Зная город, мы направим ваше резюме сразу в ближайший к вам офис"))
                .body("items[3].type", is("input"))
                // salary and error message fields check
                .body("items[4].id", is(1060))
                .body("items[4].name", is("Пожелание по зарплате"))
                .body("items[4].label", is("Пожелание по зарплате"))
                .body("items[4].isRequire", is(true))
                .body("items[4].errorMessage", is("Мы хотели бы понимать ваши зарплатные ожидания\r\n"))
                .body("items[4].type", is("input"))
                // cooperation and error message fields check
                .body("items[5].id", is(1061))
                .body("items[5].name", is("Варианты сотрудничества"))
                .body("items[5].label", is("Какие варианты сотрудничества вы рассматриваете?"))
                .body("items[5].isRequire", is(false))
                .body("items[5].type", is("checkbox"))
                // where did you know about company, options and error message fields check
                .body("items[6].id", is(1067))
                .body("items[6].name", is("Откуда вы узнали о вакансии?"))
                .body("items[6].codeName", is("Узнали о вакансии из:"))
                .body("items[6].label", is("Откуда вы узнали о вакансии?"))
                .body("items[6].isRequire", is(false))
                .body("items[6].errorMessage", is("Мы хотели бы понимать, откуда вы знаете о нашей компании\r\n"))
                .body("items[6].options[0]", is("App2Top/TalentsInGames"))
                .body("items[6].options[1]", is("CG Event"))
                .body("items[6].options[2]", is("DOU"))
                .body("items[6].options[3]", is("DTF"))
                .body("items[6].options[4]", is("DevGamm"))
                .body("items[6].options[5]", is("Facebook"))
                .body("items[6].options[6]", is("Games Gathering"))
                .body("items[6].options[7]", is("HH"))
                .body("items[6].options[8]", is("Indeed"))
                .body("items[6].options[9]", is("Instagram"))
                .body("items[6].options[10]", is("Linkedin"))
                .body("items[6].options[11]", is("Render.ru"))
                .body("items[6].options[12]", is("Vkontakte"))
                .body("items[6].options[13]", is("White Nights"))
                .body("items[6].options[14]", is("job.playrix.com"))
                .body("items[6].options[15]", is("Арт-площадки (ArtStation, Behance и др)"))
                .body("items[6].options[16]", is("Конкурсы"))
                .body("items[6].options[17]", is("Мой Круг/Хабр карьера"))
                .body("items[6].options[18]", is("Подкасты"))
                .body("items[6].options[19]", is("Слет аниматоров"))
                .body("items[6].type", is("combobox"))
                // why you interested in job at the company and error message fields check
                .body("items[7].id", is(1068))
                .body("items[7].name", is("Почему вам интересна наша компания?"))
                .body("items[7].label", is("Почему вам интересен Playrix?"))
                .body("items[7].isRequire", is(true))
                .body("items[7].errorMessage", is("Мы хотели бы понимать, почему вам интересна наша компания\r\n"))
                .body("items[7].type", is("input"))
                // about yourself and error message fields check
                .body("items[8].id", is(1069))
                .body("items[8].name", is("О себе"))
                .body("items[8].label", is("Расскажите коротко о себе, добавьте ссылки на свои работы"))
                .body("items[8].isRequire", is(true))
                .body("items[8].errorMessage", is("Заявки с коротким рассказом о себе и ссылками на работы предпочтительней"))
                .body("items[8].type", is("textarea"))
                // CV file and error message fields check
                .body("items[9].id", is(1070))
                .body("items[9].name", is("Файл резюме"))
                .body("items[9].label", is(""))
                .body("items[9].isRequire", is(false))
                .body("items[9].errorMessage", is("Файл не был загружен"))
                .body("items[9].type", is("file"))
                // phone number and error message fields check
                .body("items[10].id", is(1117))
                .body("items[10].name", is("Телефон"))
                .body("items[10].label", is("Телефон"))
                .body("items[10].isRequire", is(true))
                .body("items[10].errorMessage", is("Нам нужно знать ваш телефон"))
                .body("items[10].type", is("input"))
                // telegram username and error message fields check
                .body("items[11].id", is(2483))
                .body("items[11].name", is("Telegram"))
                .body("items[11].label", is("Telegram"))
                .body("items[11].isRequire", is(false))
                .body("items[11].errorMessage", is("Чтобы с вами связаться, нам нужно знать ваш Telegram"))
                .body("items[11].type", is("input"))
                .spec(Specs.responseSpec);
    }
}