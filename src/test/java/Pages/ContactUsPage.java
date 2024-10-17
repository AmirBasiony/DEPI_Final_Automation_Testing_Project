// ContactUsPage.java
package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsPage {
    WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.findElement(By.linkText("Contact Us")).click();
    }

    public void fillOutForm(String name, String email, String enquiry) {
        WebElement nameField = driver.findElement(By.name("name"));
        WebElement emailField = driver.findElement(By.name("email"));
        WebElement enquiryField = driver.findElement(By.name("enquiry"));

        nameField.clear(); // Clear field before entering text
        nameField.sendKeys(name);

        emailField.clear(); // Clear field before entering text
        emailField.sendKeys(email);

        enquiryField.clear(); // Clear field before entering text
        enquiryField.sendKeys(enquiry);
    }

    public void submitForm() {
        driver.findElement(By.xpath("//input[@value='Submit']")).click();
    }

    public boolean isSubmissionSuccessMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            // Wait for the success message to be visible
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'Your enquiry has been successfully sent to the store owner!')]")));
            return successMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            System.err.println("Success message element not found: " + e.getMessage());
            return false; // The message is not present
        } catch (TimeoutException e) {
            System.err.println("Success message did not appear in the given time: " + e.getMessage());
            return false; // The message did not appear in the given time
        }
    }
}
