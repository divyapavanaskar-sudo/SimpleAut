package core;

import drivers.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driver=new ThreadLocal<>();
    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void initDriver()
    {
        WebDriver webDriver= WebDriverManager.createDriver();
        driver.set(webDriver);
    }

    public static void quitDriver()
    {
        driver.get().quit();
        driver.remove();
    }
}