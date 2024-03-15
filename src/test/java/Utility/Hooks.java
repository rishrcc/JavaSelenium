package Utility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    public static BrowserDriver driver;

    @Before
    public void setup()
    {
        driver = new BrowserDriver();
    }

    @After
    public void tearDown(Scenario scenario)
    {

        driver.closeBrowser(scenario);
    }

}
