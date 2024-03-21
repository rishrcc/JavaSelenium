package Helpers;

import Pages.LoginPage;
import Utility.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginHelper extends BrowserDriver {

    public WebDriverWait wait;

    public LoginHelper(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void enterUsernameAndPassword(String username, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LoginPage.txtUsername)));
        driver.findElement(By.xpath(LoginPage.txtUsername)).sendKeys(username);
        driver.findElement(By.xpath(LoginPage.txtPassword)).sendKeys(password);
    }

    public void clickOnLogin()
    {
        driver.findElement(By.xpath(LoginPage.btnLogin)).click();
    }

    public void test_method(){
        System.out.println("Method called");
    }
}
