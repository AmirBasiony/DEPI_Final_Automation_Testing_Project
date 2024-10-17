package Tests;

import Pages.LoginPage;
import Pages.SecureAreaPage;
import Pages.ContactUsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContactUsTest extends TestBase {
    private LoginPage loginPage;
    private SecureAreaPage secureAreaPage;
    private ContactUsPage contactUsPage;

    @BeforeClass
    public void setup() {
        loginPage = new LoginPage(driver);
        secureAreaPage = new SecureAreaPage(driver);
        contactUsPage = new ContactUsPage(driver); // Initialize Contact Us Page
    }

    private void loginToHomePage() {
        loginPage.navigateToPage();
        loginPage.openDropdown();
        loginPage.openLoginPage();
        loginPage.enterEmail("xoxafe5719@skrank.com");
        loginPage.enterPassword("Password123");
        loginPage.clickSubmit();
        secureAreaPage.validateRLoginPositiveScenario();
    }

    @Test
    public void verifyContactUsSubmission() {
        test = extent.createTest("Verify Contact Us Form Submission", "This test validates the Contact Us form submission.");
        loginToHomePage();

        // Step 1: Navigate to Contact Us page
        contactUsPage.navigateTo();

        // Step 2: Fill out the contact form
        contactUsPage.fillOutForm("Test User", "testuser@example.com", "This is a test enquiry message.");

        // Step 3: Submit the contact form
        contactUsPage.submitForm();

        // Step 4: Verify submission success message
        Assert.assertTrue(contactUsPage.isSubmissionSuccessMessageDisplayed(), "Submission success message is not displayed.");
    }
}
