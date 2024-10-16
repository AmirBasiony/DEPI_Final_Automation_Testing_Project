package Tests;

import Pages.ForgetPassPage;
import Pages.HomePage;
import Pages.OrderPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
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
    ExtentReports report;
    ExtentTest test;
    ExtentReports extent = new ExtentReports();

    @BeforeClass
    public void preconditions()
    {
        // 1- Open Browser
        driver= new ChromeDriver();

        homePage_object= new HomePage(driver);
        orderPage_object= new OrderPage(driver);
        ForgetPassPage_Object = new ForgetPassPage(driver);

        ExtentSparkReporter spark = new ExtentSparkReporter("target/spark.html");
        extent.attachReporter(spark);

        driver.manage().window().maximize();
    }

    @AfterClass
    public void CloseBrowser()
    {
        // 7- Close Browser
        driver.close();
        extent.flush();
    }

   // https://awesomeqa.com
}
