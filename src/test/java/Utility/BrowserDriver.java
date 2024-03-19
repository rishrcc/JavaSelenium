package Utility;

import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.ByteArrayInputStream;


public class BrowserDriver {
    public static WebDriver driver;

    public BrowserDriver(WebDriver driver)
    {

        BrowserDriver.driver = driver;
    }

    public static WebDriver getDriver()
    {
        if (driver == null) {
            //System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void quitDriver(Scenario scenario)
    {
        if (driver != null) {
            if (scenario.isFailed())
            {
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment("Failed Screenshot", new ByteArrayInputStream(screenshot));
            }
            driver.quit();
            driver = null;
        }
    }
}
