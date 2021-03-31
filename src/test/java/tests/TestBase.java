package tests;

import Config.TestConfig;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;


import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AttachmentsHelper.*;

public class TestBase {
    static final TestConfig config = ConfigFactory.create(TestConfig.class, System.getProperties());

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;

        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.browser = config.browser();
        Configuration.browserVersion = config.browserVersion();
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://demoqa.com/automation-practice-form";


        // config for Java + Selenide
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
        Configuration.remote = config.webDriverUrl();

    }

    @AfterEach
    public void afterEach() {
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachVideo();
        attachAsText("Browser console logs", getConsoleLogs());
        if (config.videoStorage() != null)
            attachVideo();
        closeWebDriver();
    }
}
