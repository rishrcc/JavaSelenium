package Tests;

import Helpers.LoginHelper;
import TestData.LoginData;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class LoginTest {

    public static WebDriver driver;
    static ExtentReports report;
    public static ExtentTest test;
    static ExtentReports extent = new ExtentReports();



    @BeforeSuite
    public static void Setup()
    {
        driver = new ChromeDriver();
     driver.get(LoginData.url);
     driver.manage().window().maximize();
     ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
     extent.attachReporter(spark);
    }

    @AfterSuite
    public static void CleanUpReport(){
        extent.flush();
    }

    @AfterTest
    public static void TearDown()
    {
        driver.quit();
    }

    @Test
    void LoginSuccess()
    {
        test = extent.createTest("Login Success","Test of login with valid username and password");
        LoginHelper.enterUsernameAndPassword(LoginData.validUsername,LoginData.validPassword);
        LoginHelper.clickOnLogin();
    }

    @Test
    void LoginFailed()
    {
        test = extent.createTest("Login Failed","Test of login with invalid username and valid password");
        LoginHelper.enterUsernameAndPassword(LoginData.invalidUsername,LoginData.invalidPassword);
        LoginHelper.clickOnLogin();
    }
}
