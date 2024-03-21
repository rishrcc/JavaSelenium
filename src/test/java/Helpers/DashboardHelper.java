package Helpers;

import Pages.DashboardPage;
import Utility.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardHelper extends BrowserDriver {

    public WebDriverWait wait;

    public DashboardHelper(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void verifyDashboardTitle()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(DashboardPage.txtTitleDashboard)));
    }

}
