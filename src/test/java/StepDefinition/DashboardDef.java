package StepDefinition;

import Helpers.DashboardHelper;
import Utility.BrowserDriver;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class DashboardDef {

    public WebDriver driver;
    public DashboardHelper DashboardAction;

    public DashboardDef()
    {
        driver = BrowserDriver.getDriver();
        DashboardAction = new DashboardHelper(driver);
    }

    @Then("^I should view the Dashboard$")
    public void navigateToDashboard()
    {
        DashboardAction.verifyDashboardTitle();
    }
}
