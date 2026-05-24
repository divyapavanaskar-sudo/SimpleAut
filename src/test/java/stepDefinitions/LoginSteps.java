package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.LoginPage;
import utils.ExtentReportUtils;

public class LoginSteps {
private LoginPage loginPage=new LoginPage();

@Given("user is on login page")
    public void setLoginPage()
{
    ExtentReportUtils.logStep("Application is launched");
}

@And("I enter username and password")
public void loginwith()
{
    loginPage.enterCreds();
}
@And("I click on Fuel link")
    public void click_on_fuel()
{
    loginPage.fuelClick();

}






}