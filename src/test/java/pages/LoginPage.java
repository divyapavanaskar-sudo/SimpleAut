package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{
  private By fuel=By.xpath("//img[@title='Fuel']");
  private By usernm=By.name("loginfmt");
  private String username="divya.pavanaskar@brillio.com";
  private By nextBtn=By.id("idSIButton9");
  private String pwd="";
  private By pwdBtn=By.name("passwd");



    public void fuelClick() {
      actionUtils.clickOnEle(fuel);

    }

    public void enterCreds() {
    actionUtils.enterText(usernm,username);
    actionUtils.clickOnEle(nextBtn);
    actionUtils.enterText(pwdBtn,pwd);
    actionUtils.clickOnEle(nextBtn);

    }
}


