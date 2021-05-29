package cloud.autotests.tests.cv.pages;

import com.codeborne.selenide.Condition;

import static cloud.autotests.tests.TestBase.BASEURL;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class VacancyPage {
    static String
            defaultButtonSelector = "Перейти к вакансиям",
            allSelector = "#cat-1",
            mngmntSelector = "#cat17",
            productSelector = "#cat1",
            gamedisSelector = "#cat5",
            businessSelector = "#cat18",
            marketingSelector = "#cat7",
            uaSelector = "#cat23",
            artSelector = "#cat2",
            analyticsSelector = "#cat3",
            cppSelector = "#cat24",
            pythonSelector = "#cat4",
            frontendSelector = "#cat25",
            itSelector = "#cat19",
            qaSelector = "#cat6",
            financeSelector = "#cat12",
            hrSelector = "#cat8",
            adminSelector = "#cat20";

    public static void openVacancyPage() {
        open(BASEURL);
        $(byText(defaultButtonSelector)).click();
    }

    public static void vacanciesCheck() {
        $(allSelector).should(exist).shouldBe(visible);
        $(mngmntSelector).should(exist).shouldBe(visible);
        $(productSelector).should(exist).shouldBe(visible);
        $(gamedisSelector).should(exist).shouldBe(visible);
        $(businessSelector).should(exist).shouldBe(visible);
        $(marketingSelector).should(exist).shouldBe(visible);
        $(uaSelector).should(exist).shouldBe(visible);
        $(artSelector).should(exist).shouldBe(visible);
        $(analyticsSelector).should(exist).shouldBe(visible);
        $(cppSelector).should(exist).shouldBe(visible);
        $(pythonSelector).should(exist).shouldBe(visible);
        $(frontendSelector).should(exist).shouldBe(visible);
        $(itSelector).should(exist).shouldBe(visible);
        $(qaSelector).should(exist).shouldBe(visible);
        $(financeSelector).should(exist).shouldBe(visible);
        $(hrSelector).should(exist).shouldBe(visible);
        $(adminSelector).should(exist).shouldBe(visible);
    }
}
