package StepDefinition;

import Helpers.LoginHelper;
import TestData.LoginData;
import Utility.BrowserDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginDef {

    public WebDriver driver;
    public LoginHelper loginhelper;

    public LoginDef()
    {
        driver = BrowserDriver.getDriver();
        loginhelper = new LoginHelper(driver);
        driver.get(LoginData.url);
        driver.manage().window().maximize();
    }
    @Given("^I provide username and password$")
    public void enterUsernameAndPassword() {
        LoginHelper.enterUsernameAndPassword(LoginData.validUsername,LoginData.validPassword);
    }

    @Given("^I enter (.*) and (.*)$")
    public void enterUsernameAndPasswordFromExamples(String username, String password) {
        LoginHelper.enterUsernameAndPassword(username,password);
    }

    @When("^I click on login button$")
    public void clickOnLoginButton()
    {
        LoginHelper.clickOnLogin();
    }

    @Given("^I am an admin logged in$")
    public void adminLogged()
    {
        LoginHelper.enterUsernameAndPassword(LoginData.validUsername,LoginData.validPassword);
        LoginHelper.clickOnLogin();
    }

}
