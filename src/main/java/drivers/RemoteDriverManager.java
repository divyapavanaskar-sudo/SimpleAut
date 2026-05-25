package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteDriverManager {
    public static WebDriver createRemoteDriver() {
        String browser = ConfigReader.get("browser");
        String gridUrl = ConfigReader.get("grid.url");
        try {
            switch (browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    chromeOptions.addArguments("--headless=new");
                    chromeOptions.addArguments("--no-sandbox");
                    chromeOptions.addArguments("--disable-dev-shm-usage");
                    // ✅ Capabilities (IMPORTANT)
                    chromeOptions.setCapability("browserName", "chrome");
                    chromeOptions.setCapability("acceptInsecureCerts", true);
                    chromeOptions.setCapability("platformName", "Windows 11");
                    chromeOptions.setCapability("browserVersion", "latest");

                    return new RemoteWebDriver(new URL(gridUrl),chromeOptions);

                case "firefox":
                    FirefoxOptions firefoxOptionstions= new FirefoxOptions();
                    return new RemoteWebDriver(new URL(gridUrl), firefoxOptionstions);

                default:
                    throw  new RuntimeException("Browser not supported" +browser);
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to create Remote driver", e);
        }
    }
}
