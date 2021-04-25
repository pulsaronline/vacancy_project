package cloud.autotests.tests.demowebshop;

import cloud.autotests.tests.TestBase;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Cookie;

import static cloud.autotests.api.LogFilter.filters;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

@Story("Login tests")
public class LoginTests extends TestBase {

    @BeforeAll
    static void configureBaseUrl() {
        RestAssured.baseURI = TestData.getApiUrl();
        Configuration.baseUrl = TestData.getWebUrl();
    }

    @Test
    @Owner("MaksimBessudnov")
    @Tag("ui web test - fill the form")
//    @Disabled("Example test code for further test development")
    @DisplayName("Fill and submit the form")
    void loginTest() {
         String respondButtonSelector = "Откликнуться";
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
                secondFilenameSelector = "second_file";

/*        step("Open login page", () -> {
            open("/login");
            $(".page-title").shouldHave(text("Welcome, Please Sign In!"));
        });

        step("Fill in login form", () -> {
            $("#Email").val(TestData.getUserLogin());
            $("#Password").val(TestData.getUserPassword())
                    .pressEnter();
        });

        step("Verify successful authorization", () ->
                $(".account").shouldHave(text(TestData.getUserLogin())));
 */
        step("Open target page", () -> {
            open("https://job.playrix.com/open-positions/?vid=467");
        });

        step("Open fill form", () -> {
            $(byText(respondButtonSelector)).click();
        });

        step("Type Firstname", () -> {
            //$(byName(firstNameSelector)).shouldHave(text("Имя"));
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
        });
    }

    @Test
    @Owner("MaksimBessudnov")
    @Tag("ui web test - check some form elements")
//    @Disabled("Example test code for further test development")
//    @DisplayName("Successful authorization with set cookie, received by API")
    @DisplayName("Check items on the page")
    void loginWithCookieTest() {
        step("Open target page", () -> {
        open("https://job.playrix.com/open-positions/?vid=467");
        });

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
/*        step("Get cookie by api and set it to browser", () -> {
            String authorizationCookie =
                    given()
                            .filter(filters().withCustomTemplates())
                            .log().uri()
                            .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                            .formParam("Email", TestData.getUserLogin())
                            .formParam("Password", TestData.getUserPassword())
                    .when()
                            .post("/login")
                    .then()
                            .statusCode(302)
                            .log().body()
                            .extract()
                            .cookie("NOPCOMMERCE.AUTH");

            step("Open minimal content, because cookie can be set with site opened", () ->
                    open("/Themes/DefaultClean/Content/images/logo.png"));

            getWebDriver().manage().addCookie(new Cookie("NOPCOMMERCE.AUTH", authorizationCookie));
        });

        step("Open main page", () -> {
            open("");
            $(".topic-html-content-header").shouldHave(text("Welcome to our store"));
        });

        step("Verify successful authorization", () ->
                $(".account").shouldHave(text(TestData.getUserLogin())));
    }
*/
    }
}