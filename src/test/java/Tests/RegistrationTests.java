package Tests;

import Pages.RegistrationPage;
import Pages.SecureAreaPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    RegistrationPage registrationPage;
    SecureAreaPage secureAreaPage;

    @BeforeClass
    public void preConditions() {
        registrationPage = new RegistrationPage(driver);
        secureAreaPage = new SecureAreaPage(driver);
    }

    @Test
    public void RegistrationPositiveScenario() {
        test = extent.createTest("Positive Registration Test", "This test validates successful registration with valid data.");

        registrationPage.navigateToPage();
        registrationPage.openDropdown();
        registrationPage.openRegisterlink();
        registrationPage.enterFirstname("John");
        registrationPage.enterLastname("Doe");
        registrationPage.enterEmail("xsdvfe87571@skrank.com");
        registrationPage.enterTelephoneNumber("1234567890");
        registrationPage.enterPassword("Password123");
        registrationPage.enterConfirmPassword("Password123");
        registrationPage.acceptprivacrpolicy();
        registrationPage.clickSubmitbtn();
        secureAreaPage.validateRegistrationSuccessfully();
    }

    @Test
    public void RegistrationNegativeScenarioWithExistingEmail() {
        test = extent.createTest("Registration with Existing Email Test", "This test validates registration with an already existing email.");

        registrationPage.navigateToPage();
        registrationPage.openDropdown();
        registrationPage.openRegisterlink();
        registrationPage.enterFirstname("John");
        registrationPage.enterLastname("Doe");
        registrationPage.enterEmail("xoxbhaf12790@skrank.com"); // Existing email
        registrationPage.enterTelephoneNumber("1234567890");
        registrationPage.enterPassword("Password123");
        registrationPage.enterConfirmPassword("Password123");
        registrationPage.acceptprivacrpolicy();
        registrationPage.clickSubmitbtn();
        secureAreaPage.validateRegistrationWithInvalidData();
    }

    @Test
    public void RegistrationNegativeScenarioWithoutEmail() {
        test = extent.createTest("Registration Without Email Test", "This test validates registration without entering an email.");

        registrationPage.navigateToPage();
        registrationPage.openDropdown();
        registrationPage.openRegisterlink();
        registrationPage.enterFirstname("John");
        registrationPage.enterLastname("Doe");
        registrationPage.enterEmail("");  // Leave email blank
        registrationPage.enterTelephoneNumber("1234567890");
        registrationPage.enterPassword("Password123");
        registrationPage.enterConfirmPassword("Password123");
        registrationPage.acceptprivacrpolicy();
        registrationPage.clickSubmitbtn();
        secureAreaPage.validateRegistrationWithoutCompleteData();
    }

    @Test
    public void RegistrationNegativeScenarioWithoutMatchingPasswords() {
        test = extent.createTest("Registration Without Matching Passwords Test", "This test validates registration with mismatched passwords.");

        registrationPage.navigateToPage();
        registrationPage.openDropdown();
        registrationPage.openRegisterlink();
        registrationPage.enterFirstname("John");
        registrationPage.enterLastname("Doe");
        registrationPage.enterEmail("xoxafe5719@skrank.com");
        registrationPage.enterTelephoneNumber("1234567890");
        registrationPage.enterPassword("Password123");
        registrationPage.enterConfirmPassword("Password124");
        registrationPage.acceptprivacrpolicy();
        registrationPage.clickSubmitbtn();
        secureAreaPage.validateRegistrationWithoutMatchingPasswords();
    }

    @Test
    public void RegistrationNegativeScenarioWithoutAcceptPolicy() {
        test = extent.createTest("Registration Without Accepting Policy Test", "This test validates registration without accepting the privacy policy.");

        registrationPage.navigateToPage();
        registrationPage.openDropdown();
        registrationPage.openRegisterlink();
        registrationPage.enterFirstname("John");
        registrationPage.enterLastname("Doe");
        registrationPage.enterEmail("xoxb23haf12790@skrank.com");
        registrationPage.enterTelephoneNumber("1234567890");
        registrationPage.enterPassword("Password123");
        registrationPage.enterConfirmPassword("Password123");
        registrationPage.clickSubmitbtn();
        secureAreaPage.validateRegistrationWithInvalidData();
    }
}
