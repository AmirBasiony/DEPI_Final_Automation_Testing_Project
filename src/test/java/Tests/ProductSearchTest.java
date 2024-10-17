package Tests;

import Pages.LoginPage;
import Pages.SecureAreaPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductSearchTest extends TestBase {
    private LoginPage loginPageObject;
    private SecureAreaPage secureAreaPageObject;

    @BeforeClass
    public void setup() {
        loginPageObject = new LoginPage(driver);
        secureAreaPageObject = new SecureAreaPage(driver);
        loginToHomePage();
    }

    private void loginToHomePage() {
        loginPageObject.navigateToPage();
        loginPageObject.openDropdown();
        loginPageObject.openLoginPage();
        loginPageObject.enterEmail("xoxafe5719@skrank.com");
        loginPageObject.enterPassword("Password123");
        loginPageObject.clickSubmit();
        secureAreaPageObject.validateRLoginPositiveScenario();
    }

    // Positive test case: Search for a valid product
    @Test
    public void validProductSearch() {
        test = extent.createTest("Valid Product Search", "This test validates searching for a valid product.");

        // Locate the search box and input a valid product name
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.clear();
        searchBox.sendKeys("MacBook");

        // Click on the search button
        WebElement searchButton = driver.findElement(By.xpath("//button[@type='button' and @class='btn btn-default btn-lg']"));
        searchButton.click();

        // Verify that the product appears in the search results
        WebElement productResult = driver.findElement(By.xpath("//a[contains(text(), 'MacBook')]"));
        Assert.assertTrue(productResult.isDisplayed(), "Valid product search failed. Product not found.");
    }

    // Negative test case: Search for an invalid product
    @Test
    public void invalidProductSearch() {
        test = extent.createTest("Invalid Product Search", "This test validates searching for an invalid product.");

        // Locate the search box and input an invalid product name
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.clear();
        searchBox.sendKeys("InvalidProductName123");

        // Click on the search button
        WebElement searchButton = driver.findElement(By.xpath("//button[@type='button' and @class='btn btn-default btn-lg']"));
        searchButton.click();

        // Verify that the 'no results' message is displayed
        WebElement noResultsMessage = driver.findElement(By.xpath("//p[contains(text(), 'There is no product that matches the search criteria.')]"));
        Assert.assertTrue(noResultsMessage.isDisplayed(), "Invalid product search failed. No results message not displayed.");
    }
}
