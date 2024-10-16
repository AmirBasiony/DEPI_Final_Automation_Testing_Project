package Tests;

import Pages.LoginPage;
import Pages.SecureAreaPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class UserLogoutTest  extends TestBase {
    LoginPage LoginPage_Object;
    SecureAreaPage secureAreaPage_Object;
    @BeforeClass
    public void setup()
    {
        LoginPage_Object = new LoginPage(driver);
        secureAreaPage_Object = new SecureAreaPage(driver);

    }
    private void loginToHomePage() {
        LoginPage_Object.navigateToPage();
        LoginPage_Object.openDropdown();
        LoginPage_Object.openLoginPage();
        LoginPage_Object.enterEmail("xoxafe5719@skrank.com");
        LoginPage_Object.enterPassword("Password123");
        LoginPage_Object.clickSubmit();
        secureAreaPage_Object.validateRLoginPositiveScenario();
    }
    @Test
    public void pressLogoutButton()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        loginToHomePage();
        LoginPage_Object.openDropdown();
        // Wait for Locating the Logout button using an XPath selector
        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://awesomeqa.com/ui/index.php?route=account/logout']")));
        // Click on the Logout button
        logoutButton.click();

        // Locate the paragraph element containing the logout message
        WebElement logoutMessageElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(), 'You have been logged off your account.')]")));

        // Get the text from the element
        String logoutMessageText = logoutMessageElement.getText();

        // Assert that the text is as expected
        Assert.assertEquals(logoutMessageText, "You have been logged off your account. It is now safe to leave the computer.");

        // Use WebDriverWait to ensure the element is clickable
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.btn.btn-primary"))).click();

        // Get the current URL
        String currentUrl = driver.getCurrentUrl();

        // Assert that the current URL is as expected
        Assert.assertEquals(currentUrl, "https://awesomeqa.com/ui/index.php?route=common/home");
    }
}
