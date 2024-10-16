package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SecureAreaPage
{
    WebDriver driver;

    public SecureAreaPage(WebDriver driver)
    {
        this.driver = driver;
    }


    public void validateRegistrationWithInvalidData()
    {
        Assert.assertTrue(driver.findElement(By.cssSelector(".alert-danger")).isDisplayed(), "Error message not displayed for existing email.");

    }


    public void validateRegistrationSuccessfully()
    {
        Assert.assertTrue(driver.findElement(By.id("content")).isDisplayed(), "Your Account Has Been Created!");

    }

    public void validateRegistrationWithoutCompleteData()
    {
        Assert.assertTrue(driver.findElement(By.cssSelector(".text-danger")).isDisplayed(), "E-Mail Address does not appear to be valid!");

    }

    public void validateRegistrationWithoutMatchingPasswords()
    {
        Assert.assertTrue(driver.findElement(By.cssSelector(".alert-danger")).isDisplayed(), "Error message not displayed for password mismatch.");

    }

    public void validateRLoginPositiveScenario()
    {
        Assert.assertTrue(driver.findElement(By.id("content")).isDisplayed(), "My Account page was not displayed after successful login.");

    }

    public void validateRLoginInvalidEmailFormat()
    {
        Assert.assertTrue(driver.findElement(By.cssSelector(".alert-danger")).isDisplayed(), "Error message not displayed for invalid email format.");

    }

    public void validateRLoginInvalidCredentials()
    {
        Assert.assertTrue(driver.findElement(By.cssSelector(".alert-danger")).isDisplayed(), "Error message not displayed for invalid credentials.");

    }

    public void validateRLoginWithoutEmail()
    {
        Assert.assertTrue(driver.findElement(By.cssSelector(".alert-danger")).isDisplayed(), "Error message not displayed for missing email.");

    }


    public void validateRLoginWithoutPassword()
    {
        Assert.assertTrue(driver.findElement(By.cssSelector(".alert-danger")).isDisplayed(), "Error message not displayed for missing password.");

    }


}
