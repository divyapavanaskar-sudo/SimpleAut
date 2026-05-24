package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionUtils {
    private WebDriver driver;
    private WebDriverWait wait;
    private int TIMEOUT=20;
    public ActionUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }
       public WebElement find(By locator)
       {
          return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
       }
       public void clickOnEle(By locator)
        {
         wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        }

     public void enterText(By locator, String text)
     {
         find(locator).click();
         find(locator).sendKeys(text);


     }

}

