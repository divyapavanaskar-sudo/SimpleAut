package hooks;

import core.DriverFactory;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;
import utils.ExtentReportUtils;
import utils.ScreenshotUtils;

import java.io.IOException;

public class Hooks {
    @Before
    public void setUp(Scenario scenario)
    {
        DriverFactory.initDriver();
        String webSite=ConfigReader.get("url");
        DriverFactory.getDriver().get(webSite);
        DriverFactory.getDriver().manage().window().maximize();
        ExtentReportUtils.initReport();
        ExtentReportUtils.createTest(scenario.getName());

    }


    @AfterStep
    public void afterStep(Scenario scenario) throws IOException {

        if (scenario.isFailed()) {
            String path = ScreenshotUtils.capture(scenario);
            ExtentReportUtils.logFail("Step Failed");
            ExtentReportUtils.attachScreenshot(path);
        } else {
            ExtentReportUtils.logPass("Step Passed");
        }
        ExtentReportUtils.flushReport();
    }



}
