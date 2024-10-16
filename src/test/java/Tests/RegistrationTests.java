package Tests;

import Pages.RegistrationPage;
import Pages.SecureAreaPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class RegistrationTests extends TestBase{

    RegistrationPage registrationPage;
    SecureAreaPage secureAreaPage;


    @BeforeClass
    public void preConditions() {
        registrationPage = new RegistrationPage(driver);
        secureAreaPage = new SecureAreaPage(driver);

    }
    @Test
    public void RegistrationPositiveScenario() {

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
    public void RegistrationNegativeScenarioWithExistingEmail()
    {

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
