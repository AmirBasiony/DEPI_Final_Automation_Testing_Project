package Tests;

import Pages.LoginPage;
import Pages.SecureAreaPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class MainSubCategoryTests extends TestBase {

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
        LoginPage_Object.enterEmail("xsdvfe87571@skrank.com");
        LoginPage_Object.enterPassword("Password123");
        LoginPage_Object.clickSubmit();
        secureAreaPage_Object.validateRLoginPositiveScenario();
    }

    @Test
    public void selectCategoriesRandomly()
    {
        // Navigate to the website
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=common/home");

        // Select a random main category
        List<WebElement> mainCategories = driver.findElements(By.cssSelector(".nav.navbar-nav > li > a"));
        Assert.assertFalse(mainCategories.isEmpty(), "Main categories list is empty");
        WebElement randomMainCategory = mainCategories.get(new Random().nextInt(mainCategories.size()));
        randomMainCategory.click();

        // Verify main category selection
        WebElement selectedMainCategory = driver.findElement(By.cssSelector(".nav.navbar-nav > li.active > a"));
        Assert.assertTrue(selectedMainCategory.isDisplayed(), "Selected main category is not displayed");

        // Select a random sub-category (assuming sub-categories are within the main category)
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

    @Test
    public void hoverCategoriesRandomly() {
        Actions actions = new Actions(driver);

        // Navigate to the website
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=common/home");

        // Hover over a random main category
        List<WebElement> mainCategories = driver.findElements(By.cssSelector(".nav.navbar-nav > li > a"));
        Assert.assertFalse(mainCategories.isEmpty(), "Main categories list is empty");
        WebElement randomMainCategory = mainCategories.get(new Random().nextInt(mainCategories.size()));
        actions.moveToElement(randomMainCategory).perform();

        // Verify hover effect on main category
        WebElement hoverEffectMain = driver.findElement(By.cssSelector(".nav.navbar-nav > li:hover > a"));
        Assert.assertTrue(hoverEffectMain.isDisplayed(), "Hover effect is not displayed on main category");

        // Hover over a random sub-category (assuming sub-categories are within the main category)
        List<WebElement> subCategories = driver.findElements(By.cssSelector(".dropdown-menu > li > a"));
        if (!subCategories.isEmpty()) {
            WebElement randomSubCategory = subCategories.get(new Random().nextInt(subCategories.size()));
            actions.moveToElement(randomSubCategory).perform();

            // Verify hover effect on sub-category
            WebElement hoverEffectSub = driver.findElement(By.cssSelector(".dropdown-menu > li:hover > a"));
            Assert.assertTrue(hoverEffectSub.isDisplayed(), "Hover effect is not displayed on sub-category");
        } else {
            Assert.fail("No sub-categories found for the selected main category");
        }
    }

    @Test
    public void verifyMainCategorySelectionPersists() {
        // Navigate to the website
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

    @Test
    public void verifySubCategorySelectionPersists() {
        // Navigate to the website
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=common/home");

        // Select a random main category
        List<WebElement> mainCategories = driver.findElements(By.cssSelector(".nav.navbar-nav > li > a"));
        Assert.assertFalse(mainCategories.isEmpty(), "Main categories list is empty");
        WebElement randomMainCategory = mainCategories.get(new Random().nextInt(mainCategories.size()));
        randomMainCategory.click();

        // Select a random sub-category (assuming sub-categories are within the main category)
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

    @Test
    public void verifyHoverEffectWithKeyboardNavigation() {
        Actions actions = new Actions(driver);

        // Navigate to the website
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=common/home");

        // Navigate to a random main category using keyboard
        List<WebElement> mainCategories = driver.findElements(By.cssSelector(".nav.navbar-nav > li > a"));
        Assert.assertFalse(mainCategories.isEmpty(), "Main categories list is empty");
        WebElement randomMainCategory = mainCategories.get(new Random().nextInt(mainCategories.size()));
        randomMainCategory.sendKeys(Keys.ARROW_DOWN); // This may not work as intended; consider using actions

        // Verify hover effect on main category
        WebElement hoverEffectMain = driver.findElement(By.cssSelector(".nav.navbar-nav > li:hover > a"));
        Assert.assertTrue(hoverEffectMain.isDisplayed(), "Hover effect is not displayed on main category");

        // Navigate to a random sub-category using keyboard (assuming sub-categories are within the main category)
        List<WebElement> subCategories = driver.findElements(By.cssSelector(".dropdown-menu > li > a"));
        if (!subCategories.isEmpty()) {
            WebElement randomSubCategory = subCategories.get(new Random().nextInt(subCategories.size()));
            randomSubCategory.sendKeys(Keys.ARROW_DOWN); // This may not work as intended; consider using actions

            // Verify hover effect on sub-category
            WebElement hoverEffectSub = driver.findElement(By.cssSelector(".dropdown-menu > li:hover > a"));
            Assert.assertTrue(hoverEffectSub.isDisplayed(), "Hover effect is not displayed on sub-category");
        } else {
            Assert.fail("No sub-categories found for the selected main category");
        }
    }
}
