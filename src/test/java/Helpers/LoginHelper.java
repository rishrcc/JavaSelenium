package Helpers;

import Pages.LoginPage;
import Utility.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginHelper extends BrowserDriver {

    public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public static void enterUsernameAndPassword(String username, String password)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LoginPage.txtUsername)));
        driver.findElement(By.xpath(LoginPage.txtUsername)).sendKeys(username);
        driver.findElement(By.xpath(LoginPage.txtPassword)).sendKeys(password);
    }

    public static void clickOnLogin()
    {
        driver.findElement(By.xpath(LoginPage.btnLogin)).click();
    }
}
