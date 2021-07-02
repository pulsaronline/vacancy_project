package ru.playrix.autotests.tests.pages.ui;

import ru.playrix.autotests.helpers.UIHelper;
import com.codeborne.selenide.Selenide;
import ru.playrix.autotests.tests.TestBase;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;
import static ru.playrix.autotests.tests.pages.ui.GamesPage.*;

public class VacancyPage {
    static String
            vacancyPageUrl = "https://playrix.com/job/open",
            // SELECTORS
            // header selectors
            headerVacanciesButtonSelector = "Вакансии",
            headerVacanciesTagSelector = ".tags-list",
            headerVacanciesSelector = ".main-menu__sub-item.main-menu__sub-item--active",
            headerCarrierMenuName = "Карьера",
            // body selectors
            bodyVacanciesTagSelector = ".jobs-card",
            // footer selectors
            footerFaqTagSelector = ".all-jobs-faq__header",
            footerFaqSectionSelector = ".faq-card",
            footerFaqWorkOrganizeDropDownWindowSelector = ".faq-card__fold",
            footerFaqWorkOrganizeWindowSelector = ".faq-card__description",

            // VALUES
            // header menu vacancy section name values
            headerVacanciesTagAllVacanciesValue = "Все вакансии",
            headerVacanciesTagManagementValue = "Management",
            headerVacanciesTagGameDesignValue = "Game Design",
            headerVacanciesTagMarketingValue = "Marketing",
            headerVacanciesTagBusinessDevelopmentValue = "Business Development",
            headerVacanciesTagMarketingCreativesValue = "Marketing Creatives",
            headerVacanciesTagArtValue = "Art",
            headerVacanciesTagAnimationVFXValue = "Animation & VFX",
            headerVacanciesTagAnalyticsValue = "Analytics",
            headerVacanciesTagCppDevelopmentValue = "С++ Development",
            headerVacanciesTagPythonDevelopmentValue = "Python Development",
            headerVacanciesTagFrontEndDevelopmentValue = "Front-end Development",
            headerVacanciesTagITValue = "IT",
            headerVacanciesTagQAValue = "QA",
            headerVacanciesTagFinanceAndLegalValue = "Finance & Legal",
            headerVacanciesTagHRAndRecruitingValue = "HR & Recruiting",
            headerVacanciesTagPRValue = "PR",
            headerVacanciesTagAdministrationValue = "Administration",
            headerVacanciesTagCommunityAndSupportValue = "Community & Support",
            headerVacanciesTagLocalizationValue = "Localization",

            // body vacancy section name values
            // Management
            bodyVacancyDevelopmentDirector = "Development Director",
            bodyVacancyProjectManager = "Project Manager",
            // Game Design
            bodyVacancyExecutiveProducer = "Executive Producer",
            bodyVacancyProducer = "Producer",
            bodyVacancyNarrativeProducer = "Narrative Producer",
            bodyVacancyLeadGameDesigner = "Lead Game Designer",
            bodyVacancyGameDesignerMiniGames = "Game Designer (Mini Games/ Playable Ads)",
            bodyVacancyNarrativeDesigner = "Narrative Designer",
            bodyVacancyTechnicalDesigner = "Technical Designer",
            // Marketing
            bodyVacancyChiefMarketingOfficer = "Chief Marketing Officer",
            bodyVacancyHeadOfMarketing = "Head of Marketing/ Marketing Director",
            bodyVacancyMarketingProducer = "Marketing Producer",
            bodyVacancyTechnicalMarketingProducer = "Technical Marketing Producer",
            bodyVacancyLeadUAManager = "Lead UA Manager",
            bodyVacancyUATeamLead = "UA Team Lead",
            bodyVacancyUAManager = "UA Manager",
            // Business Development
            bodyVacancyMAndADirector = "M&A Director",
            // Marketing Creatives
            bodyVacancyMarketingCreativesProducer = "Marketing Creatives Producer",
            bodyVacancyMarketingCreativesArtProducer = "Marketing Creatives Art Producer",
            bodyVacancyMarketingCreativesDirector = "Marketing Creatives Director",
            bodyVacancyMarketingCreativesManager = "Marketing Creatives Manager",
            bodyVacancyLead2DArtist = "Lead 2D Artist (Creatives)",
            bodyVacancy2DArtistCreatives = "2D Artist (Creatives)",
            bodyVacancyMotionDesigner = "Motion Designer",
            bodyVacancy3DGeneralist = "3D Generalist (3D Artist & Animator)",
            bodyVacancy3DArtistModeller = "3D Artist (Modeller)",
            // Art
            bodyVacancyArtDirector = "Art Director",
            bodyVacancyArtTeamLead = "Art Team Lead",
            bodyVacancyLeadArtist = "Lead Artist",
            bodyVacancyLeadUIArtist = "Lead UI Artist",
            bodyVacancy3DArtist = "3D Artist",
            bodyVacancy2DArtist = "2D Artist",
            bodyVacancy2DArtistMatchThree = "2D Artist (match-3)",
            bodyVacancyUIArtist = "UI Artist",
            bodyVacancyLead2DArtistCreatives = "Lead 2D Artist (Creatives)",
            bodyVacancy2DArtistCreativesArt = "2D Artist (Creatives)", // todo: find unique locator. this one is duplicated with "bodyVacancy2DArtistCreatives"
            // Animation & VFX
            bodyVacancy3DCharacterAnimator = "3D Character Animator",
            // Analytics
            bodyVacancyLeadMarketingAnalystUA = "Lead Marketing Analyst (UA)",
            bodyVacancyDataScientist = "Data Scientist",
            bodyVacancyDataAnalyst = "Data Analyst",
            bodyVacancyDataAnalystUA = "Data Analyst (UA)",
            // С++ Development
            bodyVacancyCppTeamLead = "Programming Team Lead (С++)",
            bodyVacancyCppSeniorDeveloper = "Senior C++ Developer (Frameworks)",
            bodyVacancySeniorCppGameDeveloper = "Senior C++ Game Developer",
            bodyVacancyCppGameDeveloper = "С++ Game Developer",
            bodyVacancyCppGameDeveloperTechnical = "С++ Game Developer (Technical)",
            bodyVacancyProgrammerServer = "Programmer, Server (Node.js)",
            // Python Development
            bodyVacancyPythonTechLead = "Python Tech Lead",
            bodyVacancyPythonProgrammer = "Python Programmer",
            bodyVacancyPythonDeveloper = "Python Developer",
            // Front-end Development
            bodyVacancyPlayableAdsDeveloper = "Playable Ads Developer",
            bodyVacancyJavaScriptDeveloper = "JavaScript Developer",
            // IT
            bodyVacancyTeamLeadITSupport = "Team Lead (IT Support)",
            bodyVacancyTechnicalWriterITDPA = "Technical Writer (IT DPA)",
            bodyVacancyQAAutomationEngineerITBIA = "QA Automation Engineer (IT BIA)",
            bodyVacancyQAEngineerITBIA = "QA Engineer (IT BIA)",
            bodyVacancyFrontendDeveloperITDPA = "Frontend Developer (IT DPA)",
            bodyVacancyFrontendDeveloperITBIA = "Frontend Developer (IT BIA)",
            bodyVacancyBackendDeveloperITDPA = "Backend Developer (IT DPA)",
            bodyVacancyBackendDeveloperITBIA = "Backend Developer (IT BIA)",
            bodyVacancyDataEngineeringLeadITBIA = "Data Engineering Lead (IT BIA)",
            bodyVacancyDataEngineerITBIA = "Data Engineer (IT BIA)",
            bodyVacancyDevOpsSREITPlatform = "DevOps/SRE (IT Platform)",
            bodyVacancySystemAnalystITDPA = "System Analyst (IT DPA)",
            bodyVacancyInformationSecurityEngineer = "Information Security Engineer (IT Security)",
            bodyVacancySystemAdministratorITSupport = "System Administrator (IT Support)",
            // QA
            bodyVacancySeniorQAEngineer = "Senior QA Engineer",
            bodyVacancyJuniorQAEngineer = "Junior QA Engineer",
            bodyVacancyQAEngineerEngine = "QA Engineer, Engine",
            // Finance & Legal
            bodyVacancyLegalCounselPrivacy = "Legal Counsel, Privacy",
            bodyVacancyComplianceOfficer = "Compliance Officer",
            bodyVacancyAnalystConsultant = "1С Analyst/Consultant",
            // HR & Recruiting
            bodyVacancyITRecruiter = "IT Recruiter",
            bodyVacancyArtRecruiter = "Art Recruiter",
            bodyVacancyResearcher = "Researcher",
            bodyVacancyJuniorTalentSourcer = "Junior Talent Sourcer",
            // PR
            bodyVacancyPRManager = "PR Manager",
            // Administration
            bodyVacancyMICEManagerEvent = "MICE Manager, Event",
            bodyVacancyOfficeManager = "Office Manager",
            // Localization
            bodyVacancyTranslatorRUEN = "Translator RU-EN",

            // footer vacancy section name values
            footerFaqTagValue = "FAQ",
            footerFaqWorkOrganizeValue = "Как организована удаленная работа в Playrix?",
            footerFaqReviewValue = "Как долго рассматривается резюме?",
            footerFaqCompetitionValue = "Как проходит конкурс на вакансию?",
            footerFaqSocialValue = "Что входит в социальный пакет?",
            footerFaqFeedbackValue = "Когда я получу ответ после прохождения собеседования/выполнения тестового задания?",
            footerFaqResubmitValue = "Могу ли я повторно подавать резюме на вакансии компании?",
            footerFaqTestsValue = "Есть ли у вас тестовые задания?",
            footerFaqAboutCompanyInfoValue = "Где еще можно ознакомиться с информацией о компании?",
            footerFaqWorkOrganizeFoundersValue = "Основатели Playrix об управлении распределенной командой",
            footerFaqWorkOrganizePodcastValue = "Подкаст на тему удаленной работы с участием основателей компании";

    public static void openVacancyPage() {
        open(TestBase.BASEURL);
        UIHelper.checkLocale();
        UIHelper.acceptCookies();
        $$(headerMenuSelector).findBy(text(headerCarrierMenuName)).scrollTo().click();
        $$(headerSubmenuSelector).findBy(text(headerVacanciesSubMenuName)).should(exist);
        $(byText(headerVacanciesButtonSelector)).hover();
//        $(".main-menu__link.main-menu__link--parent").scrollTo().hover();
//        $$(".main-menu__link.main-menu__link--parent").findBy(text(headerCarrierMenuName)).click();
        $(byText(headerVacanciesButtonSelector)).click();
    }

    public static void headerVacanciesCheck() {
        $(headerVacanciesTagSelector).shouldHave(text(headerVacanciesTagAllVacanciesValue),
                text(headerVacanciesTagManagementValue),
                text(headerVacanciesTagGameDesignValue),
                text(headerVacanciesTagMarketingValue),
                text(headerVacanciesTagBusinessDevelopmentValue),
                text(headerVacanciesTagMarketingCreativesValue),
                text(headerVacanciesTagArtValue),
                text(headerVacanciesTagAnimationVFXValue),
                text(headerVacanciesTagAnalyticsValue),
                text(headerVacanciesTagCppDevelopmentValue),
                text(headerVacanciesTagPythonDevelopmentValue),
                text(headerVacanciesTagFrontEndDevelopmentValue),
                text(headerVacanciesTagITValue),
                text(headerVacanciesTagQAValue),
                text(headerVacanciesTagFinanceAndLegalValue),
                text(headerVacanciesTagHRAndRecruitingValue),
                text(headerVacanciesTagPRValue),
                text(headerVacanciesTagAdministrationValue),
                text(headerVacanciesTagCommunityAndSupportValue),
                text(headerVacanciesTagLocalizationValue));
    }

    public static void bodyVacanciesTagCheck(){
        $(bodyVacanciesTagSelector).shouldHave(
                text(headerVacanciesTagManagementValue),
                text(headerVacanciesTagGameDesignValue),
                text(headerVacanciesTagMarketingValue),
                text(headerVacanciesTagBusinessDevelopmentValue),
                text(headerVacanciesTagMarketingCreativesValue),
                text(headerVacanciesTagArtValue),
                text(headerVacanciesTagAnimationVFXValue),
                text(headerVacanciesTagAnalyticsValue),
                text(headerVacanciesTagCppDevelopmentValue),
                text(headerVacanciesTagPythonDevelopmentValue),
                text(headerVacanciesTagFrontEndDevelopmentValue),
                text(headerVacanciesTagITValue),
                text(headerVacanciesTagQAValue),
                text(headerVacanciesTagFinanceAndLegalValue),
                text(headerVacanciesTagHRAndRecruitingValue),
                text(headerVacanciesTagPRValue),
                text(headerVacanciesTagAdministrationValue),
                text(headerVacanciesTagLocalizationValue));
    }

    public static void bodyVacanciesNamesCheck(){
        $(bodyVacanciesTagSelector).shouldHave(
                // Management
                text(bodyVacancyDevelopmentDirector),
                text(bodyVacancyProjectManager),
                // Game Design
                text(bodyVacancyExecutiveProducer),
                text(bodyVacancyProducer),
                text(bodyVacancyNarrativeProducer),
                text(bodyVacancyLeadGameDesigner),
                text(bodyVacancyGameDesignerMiniGames),
                text(bodyVacancyNarrativeDesigner),
                text(bodyVacancyTechnicalDesigner),
                // Marketing
                text(bodyVacancyChiefMarketingOfficer),
                text(bodyVacancyHeadOfMarketing),
                text(bodyVacancyMarketingProducer),
                text(bodyVacancyTechnicalMarketingProducer),
                text(bodyVacancyLeadUAManager),
                text(bodyVacancyUATeamLead),
                text(bodyVacancyUAManager),
                // Business Development
                text(bodyVacancyMAndADirector),
                // Marketing Creatives
                text(bodyVacancyMarketingCreativesProducer),
                text(bodyVacancyMarketingCreativesArtProducer),
                text(bodyVacancyMarketingCreativesDirector),
                text(bodyVacancyMarketingCreativesManager),
                text(bodyVacancyLead2DArtist),
                text(bodyVacancy2DArtistCreatives),
                text(bodyVacancyMotionDesigner),
                text(bodyVacancy3DGeneralist),
                text(bodyVacancy3DArtistModeller),
                // Art
                text(bodyVacancyArtDirector),
                text(bodyVacancyArtTeamLead),
                text(bodyVacancyLeadArtist),
                text(bodyVacancyLeadUIArtist),
                text(bodyVacancy3DArtist),
                text(bodyVacancy2DArtist),
                text(bodyVacancy2DArtistMatchThree),
                text(bodyVacancyUIArtist),
                text(bodyVacancyLead2DArtistCreatives),
                text(bodyVacancy2DArtistCreativesArt),
                // Animation & VFX
                text(bodyVacancy3DCharacterAnimator),
                // Analytics
                text(bodyVacancyLeadMarketingAnalystUA),
                text(bodyVacancyDataScientist),
                text(bodyVacancyDataAnalyst),
                text(bodyVacancyDataAnalystUA),
                // С++ Development
                text(bodyVacancyCppTeamLead),
                text(bodyVacancyCppSeniorDeveloper),
                text(bodyVacancySeniorCppGameDeveloper),
                text(bodyVacancyCppGameDeveloper),
                text(bodyVacancyCppGameDeveloperTechnical),
                text(bodyVacancyProgrammerServer),
                // Python Development
                text(bodyVacancyPythonTechLead),
                text(bodyVacancyPythonProgrammer),
                //text(bodyVacancyPythonDeveloper),
                // Front-end Development
                text(bodyVacancyPlayableAdsDeveloper),
                text(bodyVacancyJavaScriptDeveloper),
                // IT
                text(bodyVacancyTeamLeadITSupport),
                text(bodyVacancyTechnicalWriterITDPA),
                text(bodyVacancyQAAutomationEngineerITBIA),
                text(bodyVacancyQAEngineerITBIA),
                text(bodyVacancyFrontendDeveloperITDPA),
                text(bodyVacancyFrontendDeveloperITBIA),
                text(bodyVacancyBackendDeveloperITDPA),
                text(bodyVacancyBackendDeveloperITBIA),
                text(bodyVacancyDataEngineeringLeadITBIA),
                text(bodyVacancyDataEngineerITBIA),
                text(bodyVacancyDevOpsSREITPlatform),
                text(bodyVacancySystemAnalystITDPA),
                text(bodyVacancyInformationSecurityEngineer),
                text(bodyVacancySystemAdministratorITSupport),
                // QA
                text(bodyVacancySeniorQAEngineer),
                text(bodyVacancyJuniorQAEngineer),
                text(bodyVacancyQAEngineerEngine),
                // Finance & Legal
                // text(bodyVacancyLegalCounselPrivacy),
                text(bodyVacancyComplianceOfficer),
                text(bodyVacancyAnalystConsultant),
                // HR & Recruiting
                text(bodyVacancyITRecruiter),
                text(bodyVacancyArtRecruiter),
                text(bodyVacancyResearcher),
                // text(bodyVacancyJuniorTalentSourcer),
                // PR
                text(bodyVacancyPRManager),
                // Administration
                text(bodyVacancyMICEManagerEvent),
                text(bodyVacancyOfficeManager),
                // Localization
                text(bodyVacancyTranslatorRUEN)
        ).shouldBe(visible);
    }

    public static void footerFaqSectionCheck(){
        $(footerFaqTagSelector).shouldHave(
                text(footerFaqTagValue)).shouldBe(visible);
        $(footerFaqSectionSelector).shouldHave(
                text(footerFaqWorkOrganizeValue),
                text(footerFaqReviewValue),
                text(footerFaqCompetitionValue),
                text(footerFaqSocialValue),
                text(footerFaqFeedbackValue),
                text(footerFaqResubmitValue),
                text(footerFaqTestsValue),
                text(footerFaqAboutCompanyInfoValue)
                ).shouldBe(visible);
        $(footerFaqWorkOrganizeDropDownWindowSelector).click();
        $(footerFaqWorkOrganizeWindowSelector).shouldBe(visible);
        $(footerFaqSectionSelector).shouldHave(
                text(footerFaqWorkOrganizeFoundersValue),
                text(footerFaqWorkOrganizePodcastValue)).shouldBe(visible);
    }
}