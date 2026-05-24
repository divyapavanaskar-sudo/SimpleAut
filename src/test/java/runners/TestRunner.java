package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.plugin.Plugin;

@CucumberOptions
        (
                features = "src/test/resources/features",
                glue = {"stepDefinitions", "hooks", "pages"},
                plugin = {
                        "pretty",
                        "html:reports/cucumber-report.html",
                        "json:reports/cucumber.json"
                },tags ="@TC1"
        )

public class TestRunner extends AbstractTestNGCucumberTests {
}
