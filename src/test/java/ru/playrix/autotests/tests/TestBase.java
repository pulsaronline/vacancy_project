package ru.playrix.autotests.tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit5.AllureJunit5;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.playrix.autotests.helpers.DriverHelper;

import static ru.playrix.autotests.helpers.AttachmentsHelper.*;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

@ExtendWith({AllureJunit5.class})
public class TestBase {
    public static String BASEURL = "https://playrix.com/games";

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = TestData.getApiUrl();
        Configuration.baseUrl = TestData.getWebUrl();
        //Configuration.startMaximized = true;
    }

    @AfterEach
    public void addAttachments() {
        String sessionId = DriverHelper.getSessionId();

        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", DriverHelper.getConsoleLogs());

        closeWebDriver();
        if (DriverHelper.isVideoOn()) attachVideo(sessionId);
    }
}