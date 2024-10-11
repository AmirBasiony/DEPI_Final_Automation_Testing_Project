package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ForgetPassPage {
    WebDriver driver;

    // Constructor to initialize the WebDriver instance
    public ForgetPassPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to navigate to the Forgot Password page
    public void navigateToForgetPass() {
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=account/forgotten");
    }

    // Method to enter the email in the email input field
    public void enterEmail(String email) {
        driver.findElement(By.name("email")).sendKeys(email);
    }

    // Method to click the Continue button
    public void clickContinueButton() {
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
    }

    // Method to check if the email exists or not and perform corresponding assertions
    public void CheckEmailExistence(String CheckType) {
        if (CheckType.equals("NotExist")) {
            // Perform warning message assertion
            WarningMessageTest();
        } else if (CheckType.equals("Exist")) {
            // Perform success message assertion
            SuccessMessageTest();
        }
    }

    // Method to verify the success message
    public void SuccessMessageTest() {
        // Locate the element containing the success message
        WebElement successMessage = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));

        // Retrieve the actual text from the element
        String actualMessage = successMessage.getText().trim();  // Trim any extra whitespace

        // Define the expected success message
        String expectedMessage = "An email with a confirmation link has been sent your email address.";

        // Assert that the actual message matches the expected message
        Assert.assertEquals(actualMessage, expectedMessage, "The success message does not match!");
    }

    // Method to verify the warning message
    public void WarningMessageTest() {
        // Locate the element containing the warning message
        WebElement warningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));

        // Retrieve the actual text from the element
        String actualMessage = warningMessage.getText().trim();  // Trim any extra whitespace

        // Define the expected warning message
        String expectedMessage = "Warning: The E-Mail Address was not found in our records, please try again!";

        // Assert that the actual message matches the expected message
        Assert.assertEquals(actualMessage, expectedMessage, "The warning message does not match!");
    }
}
