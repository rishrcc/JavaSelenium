package Utility;

import TestData.LoginData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserDriver {
    public static WebDriver driver;
    public BrowserDriver(){
        driver = new ChromeDriver();
        driver.get(LoginData.url);
        driver.manage().window().maximize();
    }

    public void closeBrowser()
    {
        driver.quit();
    }
}
