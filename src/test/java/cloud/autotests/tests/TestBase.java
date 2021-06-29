package cloud.autotests.tests;

import cloud.autotests.tests.cv.TestData;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit5.AllureJunit5;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static cloud.autotests.helpers.AttachmentsHelper.*;
import static cloud.autotests.helpers.DriverHelper.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

@ExtendWith({AllureJunit5.class})
public class TestBase {
    public static String BASEURL = "https://playrix.com/games";

    @BeforeAll
    static void setUp() {
        configureDriver();
        RestAssured.baseURI = TestData.getApiUrl();
        Configuration.baseUrl = TestData.getWebUrl();
        Configuration.startMaximized = true;
    }

    @AfterEach
    public void addAttachments(){
        String sessionId = getSessionId();

        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());

        closeWebDriver();
        if (isVideoOn()) attachVideo(sessionId);
    }

    public static void checkLocale(){
        if($(".header__menu.main-menu").shouldHave(text("RU")).isDisplayed()) {
            $(byText("RU")).click();
        }
    }

    public static void acceptCookies(){
        $$(".popup-cookies__btn.btn.btn--green").findBy(text("Принять")).click();
    }
}