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

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;
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
    void apiCarrierQAEngineerPageFieldsAndErrorMessagesTest() {
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

    @Test
    @Owner("BessudnovMaksim")
    @Tag("api")
    @DisplayName("API sampling test: check the fields at page\"\"History\"")
    void apiHistoryPageFieldsTest() {
        open();
        Specs.request
                .when()
                .get("https://playrix.com/api/v1/index.php?historyPage/getList")
                .then()
                // 2020
                .body("items.2020.id[0]", is(1018))
                .body("items.2020.name[0]", is(""))
                .body("items.2020.previewPicture[0]", nullValue())
                .body("items.2020.year[0]", is("2020"))
                .body("items.2020.video[0]", nullValue())
                .body("items.2020.youtube[0]", is(""))
                .body("items.2020.type[0]", is("center"))
                .body("items.2020.previewText[0]", is("<p>\r\n <strong>Playrix — в топ-3</strong>&nbsp;разработчиков мобильных игр в мире\r\n</p>"))
                .body("items.2020.link[0]", nullValue())
                // 2019
                .body("items.2019.id[0]", is(1020))
                .body("items.2019.name[0]", is("Playrix — крупнейшая игровая компания в СНГ"))
                .body("items.2019.previewPicture[0]", nullValue())
                .body("items.2019.year[0]", is("2019"))
                .body("items.2019.video[0]", nullValue())
                .body("items.2019.youtube[0]", is(""))
                .body("items.2019.type[0]", is("simple"))
                .body("items.2019.previewText[0]", is("<p>\r\n\t Благодаря M&amp;A и возможности работать удаленно&nbsp;Playrix стал&nbsp;расти еще быстрее," +
                        " закрепившись&nbsp;в пятерке лучших игровых компаний в мире.\r\n</p>"))
                .body("items.2019.link[0].value", is("/job/open"))
                .body("items.2019.link[0].description", is("Узнать вакансии"))
                // 2018
                .body("items.2018.id[0]", is(1023))
                .body("items.2018.name[0]", is("M&A: cлияния и поглощения"))
                .body("items.2018.previewPicture[0].src", is("/upload/iblock/b00/b00ba6389545ad92fc734d1056a1dfc7.png"))
                .body("items.2018.previewPicture[0].width", is(1399))
                .body("items.2018.previewPicture[0].height", is(1307))
                .body("items.2018.previewPicture[0].size", is(1097355))
                .body("items.2018.previewPicture[0].name", is("history_1 (1).png"))
                .body("items.2018.year[0]", is("2018"))
                .body("items.2018.video[0]", nullValue())
                .body("items.2018.youtube[0]", is(""))
                .body("items.2018.type[0]", is("simple"))
                .body("items.2018.previewText[0]", is("<p>\r\n\t Компания заключила сотрудничество с пятью студиями в СНГ, положив начало развитию" +
                        " направления M&amp;A. В разработку запущено рекордное количество проектов.\r\n</p>"))
                .body("items.2018.link[0]", nullValue())
                .body("items.2018.id[1]", is(1024))
                .body("items.2018.name[1]", is(""))
                .body("items.2018.previewPicture[1]", nullValue())
                .body("items.2018.year[1]", is("2018"))
                .body("items.2018.video[1]", nullValue())
                .body("items.2018.youtube[1]", is(""))
                .body("items.2018.type[1]", is("simple"))
                .body("items.2018.previewText[1]", containsString("Мы можем потратить несколько лет на разработку игры."))
                .body("items.2018.previewText[1]", containsString(" Для нас важно "))
                .body("items.2018.previewText[1]", containsString("сделать качественно"))
                .body("items.2018.previewText[1]", containsString(", а не"))
                .body("items.2018.previewText[1]", containsString("быстро."))
                .body("items.2018.previewText[1]", containsString(" Игорь Бухман, сооснователь Playrix"))
                .body("items.2018.link[1]", nullValue())
                // 2017
                .body("items.2017.id[0]", is(1209))
                .body("items.2017.name[0]", is(""))
                .body("items.2017.previewPicture[0]", nullValue())
                .body("items.2017.year[0]", is("2017"))
                .body("items.2017.video[0]", nullValue())
                .body("items.2017.youtube[0]", is(""))
                .body("items.2017.type[0]", is("center"))
                .body("items.2017.previewText[0]", is("<p>\r\n <strong>Playrix — в топ-10</strong> самых успешных игровых разработчиков мира\r\n</p>"))
                .body("items.2017.link[0]", nullValue())
                .body("items.2017.id[1]", is(1025))
                .body("items.2017.name[1]", is("Рекорды Homescapes"))
                .body("items.2017.previewPicture[1]", nullValue())
                .body("items.2017.year[1]", is("2017"))
                .body("items.2017.video[1]", nullValue())
                .body("items.2017.youtube[1]", is(""))
                .body("items.2017.type[1]", is("simple"))
                .body("items.2017.previewText[1]", is("<p>\r\n\t Проект продолжил историю Остина из Gardenscapes и стал одной из лучших игр года по" +
                        " версии Google Play. Это сделало серию Scapes™ ведущим брендом компании и флагманом рынка match-3.\r\n</p>"))
                .body("items.2017.link[1].value", is("/games/homescapes"))
                .body("items.2017.link[1].description", is("Homescapes"))
                // 2016
                .body("items.2016.id[0]", is(1030))
                .body("items.2016.name[0]", is("Запуск Gardenscapes"))
                .body("items.2016.previewPicture[0]", nullValue())
                .body("items.2016.year[0]", is("2016"))
                .body("items.2016.video[0]", nullValue())
                .body("items.2016.youtube[0]", is(""))
                .body("items.2016.type[0]", is("simple"))
                .body("items.2016.previewText[0]", is("<p>\r\n\t Новаторская механика&nbsp;«\u200Ematch-3 + история»\u200E от Playrix стала настоящим" +
                        " хитом. Проект стал&nbsp;одним из лучших приложений года и лучшей игрой года по версии Facebook.\r\n</p>"))
                .body("items.2016.link[0].value", is("/games/gardenscapes"))
                .body("items.2016.link[0].description", is("Gardenscapes"))
                .body("items.2016.id[1]", is(1950))
                .body("items.2016.name[1]", is(""))
                .body("items.2016.previewPicture[1]", nullValue())
                .body("items.2016.year[1]", is("2016"))
                .body("items.2016.video[1]", nullValue())
                .body("items.2016.youtube[1]", is(""))
                .body("items.2016.type[1]", is("center"))
                .body("items.2016.previewText[1]", containsString(" Разработка"))
                .body("items.2016.previewText[1]", containsString("первой игры серии"))
                .body("items.2016.link[1].value", nullValue())
                // 2015
                .body("items.2015.id[0]", is(1032))
                .body("items.2015.name[0]", is("Быстрый успех Fishdom"))
                .body("items.2015.previewPicture[0]", nullValue())
                .body("items.2015.year[0]", is("2015"))
                .body("items.2015.video[0]", nullValue())
                .body("items.2015.youtube[0]", is(""))
                .body("items.2015.type[0]", is("simple"))
                .body("items.2015.previewText[0]", is("<p>\r\n\t Playrix продолжает разработку в&nbsp;формате&nbsp;F2P и создает&nbsp;проект" +
                        " в жанре match-3 с механикой метаигры. Игра сразу попала в топ-50 App Store и Google Play.\r\n</p>"))
                .body("items.2015.link[0].value", is("/games/fishdom"))
                .body("items.2015.link[0].description", is("Fishdom"))
                // 2014
                .body("items.2014.id[0]", is(1035))
                .body("items.2014.name[0]", is(""))
                .body("items.2014.previewPicture[0]", nullValue())
                .body("items.2014.year[0]", is("2014"))
                .body("items.2014.video[0]", nullValue())
                .body("items.2014.youtube[0]", is(""))
                .body("items.2014.type[0]", is("center"))
                .body("items.2014.previewText[0]", is("Playrix начинает работать&nbsp;<strong>удаленно</strong>"))
                .body("items.2014.link[0].value", nullValue())
                // 2013
                .body("items.2013.id[0]", is(1037))
                .body("items.2013.name[0]", is("Выход на рынок free-to-play"))
                .body("items.2013.previewPicture[0].src", is("/upload/iblock/bd6/bd6a9655df41704ce54fba8a6800eda5.png"))
                .body("items.2013.previewPicture[0].width", is(3234))
                .body("items.2013.previewPicture[0].height", is(2598))
                .body("items.2013.previewPicture[0].size", is(1890968))
                .body("items.2013.previewPicture[0].name", is("history_2.png"))
                .body("items.2013.year[0]", is("2013"))
                .body("items.2013.video[0]", nullValue())
                .body("items.2013.youtube[0]", is(""))
                .body("items.2013.type[0]", is("simple"))
                .body("items.2013.previewText[0]", is("<p>\r\n\t Непростое решение адаптировать разработку под" +
                        " мобильные&nbsp;платформы&nbsp;принесло отличные результаты. F2P-Township попал в топ-50 App Store и Google Play.\r\n</p>"))
                .body("items.2013.link[0].value", is("/games/township"))
                .body("items.2013.link[0].description", is("Township"))
                .body("items.2013.id[1]", is(1038))
                .body("items.2013.name[1]", is(""))
                .body("items.2013.previewPicture[1]", nullValue())
                .body("items.2013.year[1]", is("2013"))
                .body("items.2013.video[1]", nullValue())
                .body("items.2013.youtube[1]", is(""))
                .body("items.2013.type[1]", is("simple"))
                .body("items.2013.previewText[1]", containsString("Смена курса — это не признак слабости. Именно способность "))
                .body("items.2013.previewText[1]", containsString("поменять видение"))
                .body("items.2013.previewText[1]", containsString("позволяет добиться успеха\u200E."))
                .body("items.2013.previewText[1]", containsString(" Дима Бухман, сооснователь Playrix"))
                .body("items.2013.link[1].value", nullValue())
                // 2012
                .body("items.2012.id[0]", is(1042))
                .body("items.2012.name[0]", is("Изменение стратегии"))
                .body("items.2012.previewPicture[0].src", is("/upload/iblock/b74/b745c527941ef7cf6c7515a3675ca09a.png"))
                .body("items.2012.previewPicture[0].width", is(1411))
                .body("items.2012.previewPicture[0].height", is(1237))
                .body("items.2012.previewPicture[0].size", is(935522))
                .body("items.2012.previewPicture[0].name", is("ff34837d9f5b9736771663bcec494bc0.png"))
                .body("items.2012.year[0]", is("2012"))
                .body("items.2012.video[0]", nullValue())
                .body("items.2012.youtube[0]", is(""))
                .body("items.2012.type[0]", is("simple"))
                .body("items.2012.previewText[0]", is("<p>\r\n\t Первую «социальную»\u200E игру, Township, ждал успех. Но компания" +
                        " решила заморозить это направление в пользу растущего рынка мобильных игр.<br>\r\n</p>"))
                .body("items.2012.link[0].value", is("/games/township"))
                .body("items.2012.link[0].description", is("Township"))
                // 2010
                .body("items.2010.id[0]", is(1043))
                .body("items.2010.name[0]", is(""))
                .body("items.2010.previewPicture[0]", nullValue())
                .body("items.2010.year[0]", is("2010"))
                .body("items.2010.video[0]", nullValue())
                .body("items.2010.youtube[0]", is(""))
                .body("items.2010.type[0]", is("center"))
                .body("items.2010.previewText[0]", is("Разработка&nbsp;первой игры для <strong>социальных платформ</strong>"))
                .body("items.2010.link[0].value", nullValue())
                // 2009
                .body("items.2009.id[0]", is(1045))
                .body("items.2009.name[0]", is("Эпоха РС"))
                .body("items.2009.previewPicture[0]", nullValue())
                .body("items.2009.year[0]", is("2009"))
                .body("items.2009.video[0]", nullValue())
                .body("items.2009.youtube[0]", is(""))
                .body("items.2009.type[0]", is("simple"))
                .body("items.2009.previewText[0]", is("<p>\r\n\t За первые несколько лет Playrix выпустил более 20 успешных PC-игр." +
                        " В это время в компании формируются основные принципы работы и миссия.\r\n</p>"))
                .body("items.2009.link[0].value", nullValue())
                // 2004
                .body("items.2004.id[0]", is(1046))
                .body("items.2004.name[0]", is(""))
                .body("items.2004.previewPicture[0]", nullValue())
                .body("items.2004.year[0]", is("2004"))
                .body("items.2004.video[0]", nullValue())
                .body("items.2004.youtube[0]", is(""))
                .body("items.2004.type[0]", is("center"))
                .body("items.2004.previewText[0]", is("Основание <strong>Playrix</strong>"))
                .body("items.2004.link[0].value", nullValue())
                .body("items.2004.id[1]", is(1201))
                .body("items.2004.name[1]", is("Все началось с хобби..."))
                .body("items.2004.previewPicture[1]", nullValue())
                .body("items.2004.year[1]", is("2004"))
                .body("items.2004.video[1]", nullValue())
                .body("items.2004.youtube[1]", is(""))
                .body("items.2004.type[1]", is("simple"))
                .body("items.2004.previewText[1]", is("<p>\r\n\t Братья Дима и Игорь&nbsp;Бухманы решают превратить свое хобби — разработку" +
                        " игр — в бизнес.\r\n</p>"))
                .body("items.2004.link[1].value", nullValue())
                // 2008
                .body("items.2008.id[0]", is(1949))
                .body("items.2008.name[0]", is("Рождение Остина"))
                .body("items.2008.previewPicture[0]", nullValue())
                .body("items.2008.year[0]", is("2008"))
                .body("items.2008.video[0]", nullValue())
                .body("items.2008.youtube[0]", is(""))
                .body("items.2008.type[0]", is("simple"))
                .body("items.2008.previewText[0]", is("<p>\r\n\t Создан первый концепт дворецкого Остина&nbsp;— в будущем самого узнаваемого" +
                        " персонажа мобильных игр серии&nbsp;Scapes™.\r\n</p>"))
                .body("items.2008.link[0].value", is("/games/scapes"))
                .body("items.2008.link[0].description", is("Scapes"))
                .spec(Specs.responseSpec);
    }
}