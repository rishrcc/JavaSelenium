package StepDefinition;
import Helpers.LoginHelper;
import TestData.LoginData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginDef {

    @Given("^I provide username and password$")
    public void enterUsernameAndPassword()
    {
        LoginHelper.enterUsernameAndPassword(LoginData.validUsername,LoginData.validPassword);
    }

    @When("^I click on login button$")
    public void clickOnLoginButton()
    {
        LoginHelper.clickOnLogin();
    }

    @Then("^I should view the homepage$")
    public void navigateToHomepage()
    {
        System.out.println("Not defined yet");
    }
}
