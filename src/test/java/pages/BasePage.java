package pages;

import core.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ActionUtils;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
     protected ActionUtils actionUtils;
    public BasePage()
    {
        this.driver= DriverFactory.getDriver();
        this.actionUtils=new ActionUtils(driver);
    }
}
