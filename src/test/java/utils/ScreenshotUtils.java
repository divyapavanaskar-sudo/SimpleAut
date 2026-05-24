package utils;

import io.cucumber.java.Scenario;
import core.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    public static String capture(Scenario scenario) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) DriverFactory.getDriver();
        File src = ts.getScreenshotAs(OutputType.FILE);

        String path = "reports/screenshots/" + scenario.getName() + ".png";

        FileUtils.copyFile(src, new File(path));
        return path;
    }

}
