package Tests;

import Pages.LoginPage;
import Pages.SecureAreaPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CurrencySwitchTest extends TestBase {
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
    public void verifyCurrencySwitch() throws InterruptedException {
        test = extent.createTest("Currency Switch Test", "This test validates the currency switch functionality.");
        loginToHomePage();

        // Step 1: Click Currency Dropdown
        WebElement currencyDropdown = driver.findElement(By.xpath("//div[@class='btn-group']"));
        currencyDropdown.click();
        Thread.sleep(2000);

        // Step 3: Switch to USD
        WebElement usdOption = driver.findElement(By.name("USD"));
        usdOption.click();
        Thread.sleep(2000);  // Wait for the prices to update

        // Verify prices are in USD
        WebElement priceInUSD = driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/button/strong"));
        Assert.assertTrue(priceInUSD.isDisplayed(), "Price is not displayed in USD");


        // Step 4: Switch to Euro
        WebElement currencyDropdownAgain = driver.findElement(By.xpath("//div[@class='btn-group']"));
        currencyDropdownAgain.click();  // Click dropdown again
        WebElement euroOption = driver.findElement(By.name("EUR"));
        euroOption.click();
        Thread.sleep(2000);  // Wait for the prices to update

        // Verify prices are in Euro
        WebElement priceInEuro = driver.findElement(By.xpath("//span[contains(text(),'€')]"));
        Assert.assertTrue(priceInEuro.isDisplayed(), "Price is not displayed in Euro");
    }

    }

