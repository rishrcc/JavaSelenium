package Utility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {

    public WebDriver driver;

    @Before
    public void setup()
    {
        driver = BrowserDriver.getDriver();
    }

    @After
    public  void tearDown(Scenario scenario)
    {
        BrowserDriver.quitDriver(scenario);
    }

}

