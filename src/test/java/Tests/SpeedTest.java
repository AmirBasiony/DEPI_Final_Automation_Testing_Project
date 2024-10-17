package Tests;

import Pages.LoginPage;
import Pages.SecureAreaPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class SpeedTest extends TestBase {
    private WebDriverWait wait;
    LoginPage loginPage;
    SecureAreaPage secureAreaPage;

    @BeforeClass
    public void preConditions() {
        loginPage = new LoginPage(driver);
        secureAreaPage = new SecureAreaPage(driver);

        // Initialize WebDriverWait
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));  // Adjust the timeout as necessary
    }

    @Test
    public void testPageLoadTime() {
        // Create a new test in ExtentReports
        test = extent.createTest("Speed Test", "This test measures the time required to reload the page");

        // Record the start time
        long startTime = System.currentTimeMillis();

        // Navigate to the website
        driver.get("https://awesomeqa.com/ui/index.php?route=common/home");

        // Wait for a specific element to ensure the page has fully loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("top-links")));

        // Record the end time
        long endTime = System.currentTimeMillis();

        // Calculate the page load time
        long loadTime = endTime - startTime;

        // Log the load time to the report
        test.info("Home page load time: " + loadTime + " milliseconds");

        // Verify that the page load time is within acceptable limits
        Assert.assertTrue(loadTime < 20000, "Home page took too long to load");

        // Log the result to ExtentReports
        if (loadTime < 20000) {
            test.pass("Page loaded in acceptable time: " + loadTime + " ms");
        } else {
            test.fail("Page took too long to load: " + loadTime + " ms");
        }
    }
}
