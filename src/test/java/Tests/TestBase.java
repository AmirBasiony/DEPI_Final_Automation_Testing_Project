package Tests;

import Pages.ForgetPassPage;
import Pages.HomePage;
import Pages.OrderPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {


    WebDriver driver;
    HomePage homePage_object;
    OrderPage orderPage_object;
    ForgetPassPage ForgetPassPage_Object;
    //LoginPage loginPage;

    @BeforeClass
    public void preconditions(){
        // 1- Open Browser
        driver= new ChromeDriver();

        homePage_object= new HomePage(driver);
        orderPage_object= new OrderPage(driver);
        ForgetPassPage_Object = new ForgetPassPage(driver);
        driver.manage().window().maximize();
       // loginPage= new LoginPage(driver);
    }

    @AfterClass
    public void CloseBrowser(){
        // 7- Close Browser
        driver.close();
    }



   // https://awesomeqa.com
}
