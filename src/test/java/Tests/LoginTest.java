package Tests;

import Helpers.LoginHelper;
import TestData.LoginData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class LoginTest {

    public static WebDriver driver;

    @BeforeSuite
    public static void Setup()
    {
        driver = new ChromeDriver();
     driver.get(LoginData.url);
     driver.manage().window().maximize();
    }

    @AfterTest
    public static void TearDown()
    {
        driver.quit();
    }

    @Test
    void LoginSuccess() {
        LoginHelper loginhelper = new LoginHelper(driver);
        loginhelper.enterUsernameAndPassword(LoginData.validUsername,LoginData.validPassword);
        loginhelper.clickOnLogin();
    }

    @Test
    void LoginFailed() {
        LoginHelper loginhelper = new LoginHelper(driver);
        loginhelper.enterUsernameAndPassword(LoginData.validUsername,LoginData.invalidPassword);
        loginhelper.clickOnLogin();
    }
}
