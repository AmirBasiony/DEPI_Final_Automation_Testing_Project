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
import java.time.Instant;

import static org.testng.AssertJUnit.assertTrue;

public class UserProfileUpdateTest extends TestBase {
    LoginPage LoginPage_Object;
    SecureAreaPage secureAreaPage_Object;
    WebDriverWait wait;

    @BeforeClass
    public void setup()
    {
        LoginPage_Object = new LoginPage(driver);
        secureAreaPage_Object = new SecureAreaPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
    public void navigateMyAccountPage()
    {


        // Step 1: Navigate to the webpage where the My Account button is present
        loginToHomePage();
        LoginPage_Object.openDropdown();

        // Step 2: Locate the My Account button
        WebElement myAccountButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("My Account")));

        // Step 3: Click on the My Account button
        myAccountButton.click();

        // For example, you can check the URL after clicking the button
        wait.until(ExpectedConditions.urlToBe("https://awesomeqa.com/ui/index.php?route=account/account"));
    }
    public void updateAllAccountInfo()
    {
        // Locate and click on the "Edit Account" link
        WebElement editAccountLink = driver.findElement(By.cssSelector("a.list-group-item[href='https://awesomeqa.com/ui/index.php?route=account/edit']"));
        editAccountLink.click();

        // Step 2: Locate and clear the input fields before entering new data
        WebElement firstNameField = driver.findElement(By.name("firstname"));
        firstNameField.clear(); // Clear existing text
        firstNameField.sendKeys("Amir"); // Enter new first name

        WebElement lastNameField = driver.findElement(By.name("lastname"));
        lastNameField.clear(); // Clear existing text
        lastNameField.sendKeys("Elbasiony"); // Enter new last name

//        WebElement emailField = driver.findElement(By.name("email"));
//        emailField.clear(); // Clear existing text
//        emailField.sendKeys("amirbasiony22@gmail.com"); // Enter new email

        WebElement telephoneField = driver.findElement(By.name("telephone"));
        telephoneField.clear(); // Clear existing text
        telephoneField.sendKeys("01010101010"); // Enter new telephone number
    }
    public void click_Continue()
    {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
    public void assertTheUpdateSuccess()
    {
        // Step 4: Wait for the success message to appear
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert.alert-success")));

        // Step 5: Assert the success message
        String expectedMessage = "Success: Your account has been successfully updated.";
        assertTrue("Success message is not displayed as expected",
                successMessage.getText().contains(expectedMessage));
    }
    @Test
    public void testUpdateMyAccountInformation()
    {
        navigateMyAccountPage();
        updateAllAccountInfo();
        click_Continue();
        assertTheUpdateSuccess();
    }

}


