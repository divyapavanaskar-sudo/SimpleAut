package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigReader;

public class WebDriverManager {
    public static WebDriver createDriver() {
            String browser = ConfigReader.get("browser");
            String execution=ConfigReader.get("execution_type");
            if(execution.equalsIgnoreCase("remote"))
            {
                return RemoteDriverManager.createRemoteDriver();
            }
            if (browser.equalsIgnoreCase("chrome")) {
               // System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                return new ChromeDriver();
            }
            if (browser.equalsIgnoreCase("firefox"))
                return new FirefoxDriver();
         else {
            throw new RuntimeException("Browser Not Supported" +browser);
        }
    }
}

