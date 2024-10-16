//package Tests;
//
//import Pages.ForgetPassPage;
//import Pages.HomePage;
//import Pages.OrderPage;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class ForgetPassTest{
//
//    WebDriver driver;
//    HomePage homePage_object;
//    OrderPage orderPage_object;
//    ForgetPassPage ForgetPassPage_Object;
//
//    @Test
//    public void enterNonExistEmail()
//    {
//        // 1- Open Edge Browser
//        driver = new EdgeDriver();
//        ForgetPassPage_Object = new ForgetPassPage(driver);
//        driver.manage().window().maximize();
//        // Navigate to the forget password page
//        ForgetPassPage_Object.navigateToForgetPass();
//
//        // Enter a non-existent email
//        ForgetPassPage_Object.enterEmail("4564aasd89@56asdsd.asd");
//
//        // Click on the Continue button
//        ForgetPassPage_Object.clickContinueButton();
//
//        // Verify that the warning message is shown for non-existent email
//        ForgetPassPage_Object.CheckEmailExistence("NotExist");
//
//        driver.close();
//    }
//
//    @Test
//    public void enterExistEmail()
//    {
//        // 1- Open Chrome Browser
//        driver= new ChromeDriver();
//        ForgetPassPage_Object = new ForgetPassPage(driver);
//        driver.manage().window().maximize();
//
//        // Navigate to the forget password page
//        ForgetPassPage_Object.navigateToForgetPass();
//
//        // Enter an existing email
//        ForgetPassPage_Object.enterEmail("amirbasiony14@gmail.com");
//
//        // Click on the Continue button
//        ForgetPassPage_Object.clickContinueButton();
//
//        // Verify that the success message is shown for the existing email
//        ForgetPassPage_Object.CheckEmailExistence("Exist");
//
//        driver.close();
//    }
//}

package Tests;

import Pages.ForgetPassPage;
import Pages.HomePage;
import Pages.OrderPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ForgetPassTest {

    WebDriver driver;
    ForgetPassPage forgetPassPage_object;

    @BeforeMethod
    public void setUp() {
        forgetPassPage_object = new ForgetPassPage(driver);
    }

    @Test
    public void enterNonExistEmail() {
        // Open Edge Browser
        driver = new EdgeDriver();
        runForgetPasswordTest("4564aasd89@56asdsd.asd", "NotExist");
    }

    @Test
    public void enterExistEmail() {
        // Open Chrome Browser
        driver = new ChromeDriver();
        runForgetPasswordTest("amirbasiony14@gmail.com", "Exist");
    }

    private void runForgetPasswordTest(String email, String checkType) {
        // Initialize ForgetPassPage
        forgetPassPage_object = new ForgetPassPage(driver);
        driver.manage().window().maximize();

        // Navigate to the forget password page
        forgetPassPage_object.navigateToForgetPass();

        // Enter the email
        forgetPassPage_object.enterEmail(email);

        // Click on the Continue button
        forgetPassPage_object.clickContinueButton();

        // Verify the email existence
        forgetPassPage_object.CheckEmailExistence(checkType);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
    }
}
