package Tests;

import Pages.LoginPage;
import Pages.SecureAreaPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class MainSubCategoryTests extends TestBase {

    // Instance variables for page objects
    private LoginPage loginPageObject;
    private SecureAreaPage secureAreaPageObject;
    private Actions actions;

    @BeforeClass
    public void setup() {
        // Initialize page objects and Actions
        loginPageObject = new LoginPage(driver);
        secureAreaPageObject = new SecureAreaPage(driver);
        actions = new Actions(driver);

        // Log in to the home page
        loginToHomePage();
    }

    private void loginToHomePage() {
        loginPageObject.navigateToPage();
        loginPageObject.openDropdown();
        loginPageObject.openLoginPage();
        loginPageObject.enterEmail("xsdvfe87571@skrank.com");
        loginPageObject.enterPassword("Password123");
        loginPageObject.clickSubmit();
        secureAreaPageObject.validateRLoginPositiveScenario();
    }

    // Test case for selecting categories randomly
    @Test
    public void selectCategoriesRandomly() {
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=common/home");

        // Select a random main category
        List<WebElement> mainCategories = driver.findElements(By.cssSelector(".nav.navbar-nav > li > a"));
        Assert.assertFalse(mainCategories.isEmpty(), "Main categories list is empty");
        WebElement randomMainCategory = mainCategories.get(new Random().nextInt(mainCategories.size()));
        randomMainCategory.click();

        // Verify main category selection
        WebElement selectedMainCategory = driver.findElement(By.cssSelector(".nav.navbar-nav > li.active > a"));
        Assert.assertTrue(selectedMainCategory.isDisplayed(), "Selected main category is not displayed");

        // Select a random sub-category
        List<WebElement> subCategories = driver.findElements(By.cssSelector(".dropdown-menu > li > a"));
        if (!subCategories.isEmpty()) {
            WebElement randomSubCategory = subCategories.get(new Random().nextInt(subCategories.size()));
            randomSubCategory.click();

            // Verify sub-category selection
            WebElement selectedSubCategory = driver.findElement(By.cssSelector(".dropdown-menu > li.active > a"));
            Assert.assertTrue(selectedSubCategory.isDisplayed(), "Selected sub-category is not displayed");
        } else {
            Assert.fail("No sub-categories found for the selected main category");
        }
    }

    // Test case for hovering categories randomly
    @Test
    public void hoverCategoriesRandomly() {
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=common/home");

        // Hover over a random main category
        List<WebElement> mainCategories = driver.findElements(By.cssSelector(".nav.navbar-nav > li > a"));
        Assert.assertFalse(mainCategories.isEmpty(), "Main categories list is empty");
        WebElement randomMainCategory = mainCategories.get(new Random().nextInt(mainCategories.size()));
        actions.moveToElement(randomMainCategory).perform();

        // Verify hover effect on main category
        Assert.assertTrue(randomMainCategory.isDisplayed(), "Hover effect is not displayed on main category");

        // Hover over a random sub-category
        List<WebElement> subCategories = driver.findElements(By.cssSelector(".dropdown-menu > li > a"));
        if (!subCategories.isEmpty()) {
            WebElement randomSubCategory = subCategories.get(new Random().nextInt(subCategories.size()));
            actions.moveToElement(randomSubCategory).perform();

            // Verify hover effect on sub-category
            Assert.assertTrue(randomSubCategory.isDisplayed(), "Hover effect is not displayed on sub-category");
        } else {
            Assert.fail("No sub-categories found for the selected main category");
        }
    }

    // Test case to verify main category selection persists
    @Test
    public void verifyMainCategorySelectionPersists() {
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=common/home");

        // Select a random main category
        List<WebElement> mainCategories = driver.findElements(By.cssSelector(".nav.navbar-nav > li > a"));
        Assert.assertFalse(mainCategories.isEmpty(), "Main categories list is empty");
        WebElement randomMainCategory = mainCategories.get(new Random().nextInt(mainCategories.size()));
        randomMainCategory.click();

        // Refresh the page
        driver.navigate().refresh();

        // Verify main category selection persists
        WebElement selectedMainCategory = driver.findElement(By.cssSelector(".nav.navbar-nav > li.active > a"));
        Assert.assertTrue(selectedMainCategory.isDisplayed(), "Main category selection did not persist after refresh");
    }

    // Test case to verify sub-category selection persists
    @Test
    public void verifySubCategorySelectionPersists() {
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=common/home");

        // Select a random main category
        List<WebElement> mainCategories = driver.findElements(By.cssSelector(".nav.navbar-nav > li > a"));
        Assert.assertFalse(mainCategories.isEmpty(), "Main categories list is empty");
        WebElement randomMainCategory = mainCategories.get(new Random().nextInt(mainCategories.size()));
        randomMainCategory.click();

        // Select a random sub-category
        List<WebElement> subCategories = driver.findElements(By.cssSelector(".dropdown-menu > li > a"));
        if (!subCategories.isEmpty()) {
            WebElement randomSubCategory = subCategories.get(new Random().nextInt(subCategories.size()));
            randomSubCategory.click();

            // Refresh the page
            driver.navigate().refresh();

            // Verify sub-category selection persists
            WebElement selectedSubCategory = driver.findElement(By.cssSelector(".dropdown-menu > li.active > a"));
            Assert.assertTrue(selectedSubCategory.isDisplayed(), "Sub-category selection did not persist after refresh");
        } else {
            Assert.fail("No sub-categories found for the selected main category");
        }
    }

    // Test case to verify hover effect with keyboard navigation
    @Test
    public void verifyHoverEffectWithKeyboardNavigation() {
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=common/home");

        // Navigate to a random main category using keyboard
        List<WebElement> mainCategories = driver.findElements(By.cssSelector(".nav.navbar-nav > li > a"));
        Assert.assertFalse(mainCategories.isEmpty(), "Main categories list is empty");
        WebElement randomMainCategory = mainCategories.get(new Random().nextInt(mainCategories.size()));
        randomMainCategory.sendKeys(Keys.ARROW_DOWN); // Use keyboard navigation

        // Verify hover effect on main category
        Assert.assertTrue(randomMainCategory.isDisplayed(), "Hover effect is not displayed on main category");

        // Navigate to a random sub-category using keyboard
        List<WebElement> subCategories = driver.findElements(By.cssSelector(".dropdown-menu > li > a"));
        if (!subCategories.isEmpty()) {
            WebElement randomSubCategory = subCategories.get(new Random().nextInt(subCategories.size()));
            randomSubCategory.sendKeys(Keys.ARROW_DOWN); // Use keyboard navigation

            // Verify hover effect on sub-category
            Assert.assertTrue(randomSubCategory.isDisplayed(), "Hover effect is not displayed on sub-category");
        } else {
            Assert.fail("No sub-categories found for the selected main category");
        }
    }
}
