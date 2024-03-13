package Helpers;
import Pages.LoginPage;
import Utility.BrowserDriver;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static Tests.LoginTest.*;

public class LoginHelper extends BrowserDriver {

    public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public static void enterUsernameAndPassword(String username, String password)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LoginPage.txtUsername)));
        driver.findElement(By.xpath(LoginPage.txtUsername)).sendKeys(username);
        driver.findElement(By.xpath(LoginPage.txtPassword)).sendKeys(password);
        //test.log(Status.PASS,"Username and Password entered successfully");
    }

    public static void clickOnLogin()
    {
        driver.findElement(By.xpath(LoginPage.btnLogin)).click();
        //test.log(Status.PASS,"Login button clicked on successfully");
    }

}
