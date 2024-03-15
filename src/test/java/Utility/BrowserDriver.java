package Utility;

import TestData.LoginData;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.ByteArrayInputStream;

public class BrowserDriver {
    public static WebDriver driver;

    public BrowserDriver(){

        driver = new ChromeDriver();
        driver.get(LoginData.url);
        driver.manage().window().maximize();
    }

    public void closeBrowser(Scenario scenario)
    {
        if (scenario.isFailed())
        {
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Failed Screenshot", new ByteArrayInputStream(screenshot));
        }
        driver.quit();
    }
}
