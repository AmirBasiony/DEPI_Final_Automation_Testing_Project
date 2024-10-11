package Tests;

import org.testng.annotations.Test;

public class ForgetPassTest extends TestBase {

    @Test
    public void enterNonExistEmail() {
        // Navigate to the forget password page
        ForgetPassPage_Object.navigateToForgetPass();

        // Enter a non-existent email
        ForgetPassPage_Object.enterEmail("4564aasd89@56asdsd.asd");

        // Click on the Continue button
        ForgetPassPage_Object.clickContinueButton();

        // Verify that the warning message is shown for non-existent email
        ForgetPassPage_Object.CheckEmailExistence("NotExist");
    }

    @Test
    public void enterExistEmail() {
        // Navigate to the forget password page
        ForgetPassPage_Object.navigateToForgetPass();

        // Enter an existing email
        ForgetPassPage_Object.enterEmail("amirbasiony14@gmail.com");

        // Click on the Continue button
        ForgetPassPage_Object.clickContinueButton();

        // Verify that the success message is shown for the existing email
        ForgetPassPage_Object.CheckEmailExistence("Exist");
    }
}