package Tests;

import Pages.LoginPage;
import Pages.SecureAreaPage;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    LoginPage loginPage;
    SecureAreaPage secureAreaPage;

    @BeforeClass
    public void preConditions() {
        loginPage = new LoginPage(driver);
        secureAreaPage = new SecureAreaPage(driver);
    }

    @Test
    public void testLoginPositiveScenario() {
        test = extent.createTest("Valid Login Test", "This test validates login with valid credentials.");
        loginPage.navigateToPage();
        loginPage.openDropdown();
        loginPage.openLoginPage();
        loginPage.enterEmail("xoxafe5719@skrank.com");
        loginPage.enterPassword("Password123");
        loginPage.clickSubmit();
        secureAreaPage.validateRLoginPositiveScenario();
    }

    @Test
    public void testLoginInvalidEmailFormat() {
        test = extent.createTest("Invalid Email Format Test", "This test validates login with an invalid email format.");
        loginPage.navigateToPage();
        loginPage.openDropdown();
        loginPage.openLoginPage();
        loginPage.enterEmail("invalid-email-format");
        loginPage.enterPassword("ValidPassword123");
        loginPage.clickSubmit();
        secureAreaPage.validateRLoginInvalidEmailFormat();
    }

    @Test
    public void testLoginInvalidCredentials() {
        test = extent.createTest("Invalid Credentials Test", "This test validates login with invalid credentials.");
        loginPage.navigateToPage();
        loginPage.openDropdown();
        loginPage.openLoginPage();
        loginPage.enterEmail("wrongemail@example.com");
        loginPage.enterPassword("WrongPassword123");
        loginPage.clickSubmit();
        secureAreaPage.validateRLoginInvalidCredentials();
    }

//@Test
//public void testLoginWithoutEmail() {
//        test = extent.createTest("Missing Email Test", "This test validates login with no email provided.");
//    loginPage.navigateToPage();
//    loginPage.openDropdown();
//    loginPage.openLoginPage();
//    loginPage.enterEmail("");
//    loginPage.enterPassword("ValidPassword123");
//    loginPage.clickSubmit();
//    secureAreaPage.validateRLoginWithoutEmail();
//
//}
//
//    @Test
//    public void testLoginWithoutPassword() {
//        test = extent.createTest("Missing Password Test", "This test validates login with no password provided.");
//        loginPage.navigateToPage();
//        loginPage.openDropdown();
//        loginPage.openLoginPage();
//        loginPage.enterEmail("valid_email@example.com");
//        loginPage.enterPassword("");
//        loginPage.clickSubmit();
//        secureAreaPage.validateRLoginWithoutPassword();
//    }
}
