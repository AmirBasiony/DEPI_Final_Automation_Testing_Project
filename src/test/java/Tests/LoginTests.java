package Tests;

import Pages.LoginPage;
import Pages.SecureAreaPage;
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
        loginPage.navigateToPage();
        loginPage.openDropdown();
        loginPage.openLoginPage();
        loginPage.enterEmail("wrongemail@example.com");
        loginPage.enterPassword("WrongPassword123");
        loginPage.clickSubmit();
        secureAreaPage.validateRLoginInvalidCredentials();
    }

    @Test
    public void testLoginWithoutEmail() {
        loginPage.navigateToPage();
        loginPage.openDropdown();
        loginPage.openLoginPage();
        loginPage.enterEmail("");
        loginPage.enterPassword("ValidPassword123");
        loginPage.clickSubmit();
        secureAreaPage.validateRLoginWithoutEmail();
    }

    @Test
    public void testLoginWithoutPassword() {
        loginPage.navigateToPage();
        loginPage.openDropdown();
        loginPage.openLoginPage();
        loginPage.enterEmail("valid_email@example.com");
        loginPage.enterPassword("");
        loginPage.clickSubmit();
        secureAreaPage.validateRLoginWithoutPassword();
    }

}
