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
                    ChromeOptions chromeOptionsptions = new ChromeOptions();
                    chromeOptionsptions.addArguments("--start-maximized");
                    return new RemoteWebDriver(new URL(gridUrl),chromeOptionsptions);
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
