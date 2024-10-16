package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void navigateToPage()
    {
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=common/home");

    }


    public void openDropdown()
    {
        driver.findElement(By.xpath("//a[@title='My Account']")).click();

    }

    public void openLoginPage()
    {
        driver.findElement(By.xpath("//a[contains(text(), 'Login')]")).click();

    }

    public void enterEmail(String email)
    {
        driver.findElement(By.id("input-email")).sendKeys(email);
    }

    public void enterPassword(String password)
    {
        driver.findElement(By.id("input-password")).sendKeys(password);
    }

    public void clickSubmit()
    {
        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    public WebElement content()
    {
        return driver.findElement(By.id("content"));
    }

    public WebElement errormessage()
    {
        return driver.findElement(By.cssSelector(".alert-danger"));
    }
}
