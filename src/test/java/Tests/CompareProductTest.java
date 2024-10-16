package Tests;

import Pages.LoginPage;
import Pages.SecureAreaPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class CompareProductTest extends TestBase {
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
    public void compareProduct()
    {
        test = extent.createTest("Compare Product Test", "This test validates the product comparison feature.");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginToHomePage();

        WebElement HomeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='https://awesomeqa.com/ui/image/catalog/opencart-logo.png']")));
        LoginPage_Object.navigateToPage();

        // Wait for the compare button to be visible and clickable
        WebElement compareButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@onclick=\"compare.add('40');\"]")));
        compareButton.click();

        // Wait for the alert to appear
        WebElement alertMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'alert alert-success')]")));

        // Verify the alert message content
        String actualText = alertMessage.getText();
        Assert.assertTrue(actualText.contains("Success: You have added") && actualText.contains("to your product comparison"), "Alert message does not match expected text.");

        // Locate the "product comparison" link and click it
        WebElement comparisonLink = alertMessage.findElement(By.linkText("product comparison"));
//        Assert.assertEquals("product comparison",comparisonLink,"product comparison");
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=product/compare");

        // Wait for the Product Details heading to be visible
        WebElement productDetailsHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[contains(text(), 'Product Details')]")));

        // Verify the heading text
        Assert.assertEquals(productDetailsHeading.getText(), "Product Details", "The heading text does not match.");
    }

}
