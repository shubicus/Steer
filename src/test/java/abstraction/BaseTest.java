package abstraction;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.shubicus.configurations.TestConfiguration;
import org.tinylog.Logger;

import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public abstract class BaseTest implements Gherkin {

    public static final TestConfiguration TEST_CONFIGURATION = ConfigFactory.create(TestConfiguration.class, System.getProperties());

    @BeforeAll
    public static void setUp() {
        Logger.info("BeforeAll setUp");
        Configuration.browser = TEST_CONFIGURATION.browser();
        Configuration.headless = TEST_CONFIGURATION.headless();
        Configuration.baseUrl = TEST_CONFIGURATION.baseUrl();
        Configuration.timeout = TEST_CONFIGURATION.timeout();
        Configuration.pageLoadTimeout = TEST_CONFIGURATION.pageLoadTimeout();
        Configuration.reportsFolder = TEST_CONFIGURATION.reportFolder();
        Configuration.fastSetValue = true;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @AfterAll
    public static void tearDown() {
        Logger.info("AfterAll tearDown");
        closeWebDriver();
    }

    @AfterEach
    public void clearCache() {
        Logger.info("AfterEach clearCache");
        clearBrowserCache();
    }

}