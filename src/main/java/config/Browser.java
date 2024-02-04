package config;

import com.codeborne.selenide.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.net.NetworkUtils;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Configuration.browserVersion;

public class Browser {

    public void selenideConfig(String testName){
        Configuration.proxyEnabled = true;
        Configuration.proxyHost = new NetworkUtils().getNonLoopbackAddressOfThisMachine();
        Configuration.fileDownload = FileDownloadMode.PROXY;
        Configuration.pageLoadTimeout = 120_000;
        setBrowser(testName);
    }

    public static void setBrowser(String testName) {
        var selenideConfig = new SelenideConfig();
        selenideConfig.browser("chrome");
        selenideConfig.browserSize("1920x1080");
        selenideConfig.pageLoadStrategy("normal");
        selenideConfig.timeout(5000);
        selenideConfig.remote("http://8.8.8.8:4444/wd/hub");// Use for Selenoid
        selenideConfig.savePageSource(true);
        selenideConfig.screenshots(true);
        selenideConfig.reportsFolder("test-result/reports");
        selenideConfig.browserCapabilities(capabilities(testName));

        var selenideDriver = new SelenideDriver(selenideConfig);

        WebDriverRunner.setWebDriver(selenideDriver.getAndCheckWebDriver());
    }

    public static DesiredCapabilities capabilities(final String testName) {
        final DesiredCapabilities capabilities = new DesiredCapabilities();
        var options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", browserVersion);
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("videoName", testName+ ".mp4");
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVideo", true,
                "enableLog", true
        ));
        return capabilities;
    }

}
