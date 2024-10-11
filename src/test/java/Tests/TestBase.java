package Tests;

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
    //LoginPage loginPage;

    @BeforeClass
    public void preconditions(){
        // 1- Open Browser
        driver= new ChromeDriver();
        homePage_object= new HomePage(driver);
        orderPage_object= new OrderPage(driver);
        driver.manage().window().maximize();
       // loginPage= new LoginPage(driver);

    }


    @AfterClass
    public void CloseBroswer(){
        // 7- Close Browser
        driver.close();
    }



   // https://awesomeqa.com
}
