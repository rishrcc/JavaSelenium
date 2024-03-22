package Tests;

import Helpers.LoginHelper;
import TestData.LoginData;
import Utility.ApiOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;


public class LoginTest {

    public static WebDriver driver;

    @BeforeSuite
    public static void Setup() throws IOException, URISyntaxException {
        driver = new ChromeDriver();
     //driver.get(LoginData.url);
        ApiOperations api = new ApiOperations();
        String accessTok = api.sendPostRequestForAzureToken();
        System.out.println(accessTok);
        String createContext = api.sendPostRequestToCreateContext(accessTok);
        System.out.print(createContext);
        driver.get(createContext);

     driver.manage().window().maximize();
    }

    @AfterTest
    public static void TearDown()
    {
        driver.quit();
    }

    @Test(enabled = false)
    void LoginSuccess() {
        LoginHelper loginhelper = new LoginHelper(driver);
        loginhelper.enterUsernameAndPassword(LoginData.validUsername,LoginData.validPassword);
        loginhelper.clickOnLogin();
    }

    @Test(enabled = false)
    void LoginFailed() {
        LoginHelper loginhelper = new LoginHelper(driver);
        loginhelper.enterUsernameAndPassword(LoginData.validUsername,LoginData.invalidPassword);
        loginhelper.clickOnLogin();
    }

    @Test
    void openBankingSwitchTab() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"acceptationConditions\"]")).click();

        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/app-root/app-process/app-consent/form/div[9]/button[2]")).click();

        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/app-root/app-process/app-bank-choice/div/div[2]/div")).click();

        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/app-root/app-process/app-bank-choice/div/div[2]/input")).sendKeys("Test");

        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/app-root/app-process/app-bank-choice/div/ul/li/span[1]")).click();

        Thread.sleep(5000);
        Set<String> windowHandles = driver.getWindowHandles();

        String currentTabHandle = driver.getWindowHandle();
        // Switch to the new tab
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentTabHandle)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(5000);
                break;
            }
        }

        String newTabTitle = driver.getTitle();
        System.out.println("Title of the new tab: " + newTabTitle);


        driver.findElement(By.xpath("//i[contains(text(),'verified_user')]")).click();
        Thread.sleep(5000);

        // Close the new tab (if needed)
        driver.close();

        // Switch back to the original tab
        //driver.switchTo().window(windowHandles.iterator().next());

    }
}
