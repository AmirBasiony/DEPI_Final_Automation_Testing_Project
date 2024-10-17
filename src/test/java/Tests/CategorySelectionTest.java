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

public class CategorySelectionTest extends TestBase {
    LoginPage LoginPage_Object;
    SecureAreaPage secureAreaPage_Object;
    @BeforeClass
    public void setup()
    {
        LoginPage_Object = new LoginPage(driver);
        secureAreaPage_Object = new SecureAreaPage(driver);
        loginToHomePage();

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
    public void verifyCategorySelection() throws InterruptedException {
        test = extent.createTest("Category Selection Test", "This test validates the user can navigate through categories.");

        selectCategory("Tablets");
        verifyCategorySelection("Tablets");

        selectCategory("Software");
        verifyCategorySelection("Software");

        selectCategory("Phones & PDAs");
        verifyCategorySelection("Phones & PDAs");

        selectCategory("Cameras");
        verifyCategorySelection("Cameras");

    }

    public void selectCategory(String categoryName) {
        // Find and click the category link by visible text
        WebElement categoryLink = driver.findElement(By.linkText(categoryName));
        categoryLink.click();
    }

    public void verifyCategorySelection(String categoryName) {
        // Verify that the header of the category page matches the selected category
        WebElement categoryHeader = driver.findElement(By.tagName("h2"));
        Assert.assertTrue(categoryHeader.getText().contains(categoryName),
                "Category page does not display the correct category: " + categoryName);
    }


    @Test
    public void verifySubcategorySelection() throws InterruptedException {
        test = extent.createTest("subCategory Selection Test", "This test validates the user can navigate through subcategories.");

        // Step 2: Select categories
        selectSubcategory("Desktops", "PC (0)");
        verifySubcategorySelection("PC");

        selectSubcategory("Laptops & Notebooks", "Macs (0)");
        verifySubcategorySelection("Macs");

        selectSubcategory("Components", "Monitors (2)");
        verifySubcategorySelection("Monitors");

        selectSubcategory("MP3 Players", "test 15 (0)");
        verifySubcategorySelection("test 15");

    }


    public void selectSubcategory(String categoryName, String subCategoryName) {
        // Step 1: Click the arrow to activate the dropdown for the category
        WebElement dropdownArrow = driver.findElement(By.linkText(categoryName));
        dropdownArrow.click();

        // Step 2: Wait for the subcategories to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(subCategoryName)));

        // Step 3: Select the subcategory
        WebElement subCategoryLink = driver.findElement(By.linkText(subCategoryName));
        subCategoryLink.click();
    }

    public void verifySubcategorySelection(String SubcategoryName) {
        // Verify that the header of the category page matches the selected category
        WebElement categoryHeader = driver.findElement(By.tagName("h2"));
        Assert.assertTrue(categoryHeader.getText().contains(SubcategoryName),
                "Category page does not display the correct category: " + SubcategoryName);
    }
}
