package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configs.EnvironmentConfigInterface;
import configs.RemoteConfigInterface;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static java.lang.String.format;

public class TestBase {
    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        EnvironmentConfigInterface configEnv = ConfigFactory.create(EnvironmentConfigInterface.class,
                System.getProperties());
        RemoteConfigInterface configRemote = ConfigFactory.create(RemoteConfigInterface.class,
                System.getProperties());

        String selenoidLogin = System.getProperty("selenoidLogin", configRemote.selenoidLogin()),
                selenoidPassword = System.getProperty("selenoidPassword", configRemote.selenoidPassword()),
                browserSize = System.getProperty("browserSize", "1980x1024"),
                browserName = System.getProperty("browserName", "CHROME"),
                browserVersion = System.getProperty("browserVersion", "99"),
                fullSelenoidUrlWithLogPass = format("https://%s:%s@selenoid.autotests.cloud/wd/hub",
                        selenoidLogin, selenoidPassword);

        Configuration.baseUrl = configEnv.mainUrl();
        Configuration.browser = browserName;
        Configuration.browserVersion = browserVersion;
        Configuration.browserSize = browserSize;

        String host = System.getProperty("host", "remote");

        if(host.equals("remote")){
            Configuration.remote = fullSelenoidUrlWithLogPass;

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }
    }

    @AfterEach
    @DisplayName("Добавить аттачи")
    void addAttachments() {
        Attach.screenshotAs("Итоговый скрин");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}
