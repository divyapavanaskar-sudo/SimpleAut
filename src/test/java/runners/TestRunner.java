package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.plugin.Plugin;
import org.testng.annotations.DataProvider;

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

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();

    }
}
