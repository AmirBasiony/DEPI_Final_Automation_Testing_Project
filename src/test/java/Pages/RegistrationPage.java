package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage
{
    WebDriver driver;
    public RegistrationPage(WebDriver driver) {
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

    public void openRegisterlink()
    {
        driver.findElement(By.xpath("//a[contains(text(), 'Register')]")).click();

    }

    public void enterFirstname(String fname)
    {
        driver.findElement(By.id("input-firstname")).sendKeys(fname);
    }

    public void enterLastname(String lastname)
    {
        driver.findElement(By.id("input-lastname")).sendKeys(lastname);
    }

    public void enterEmail(String email)
    {
        driver.findElement(By.id("input-email")).sendKeys(email);
    }

    public void enterTelephoneNumber(String tele)
    {
        driver.findElement(By.id("input-telephone")).sendKeys(tele);
    }


    public void enterPassword(String pass)
    {
        driver.findElement(By.id("input-password")).sendKeys(pass);
    }

    public void enterConfirmPassword(String cpass)
    {
        driver.findElement(By.id("input-confirm")).sendKeys(cpass);
    }

    public void acceptprivacrpolicy()
    {
        driver.findElement(By.name("agree")).click();
    }

    public void clickSubmitbtn()
    {
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
    }

    public WebElement content()
    {
        return driver.findElement(By.id("content"));
    }

    public WebElement errormessage()
    {
        return driver.findElement(By.cssSelector(".text-danger"));
    }

    public WebElement erroralert()
    {
        return driver.findElement(By.cssSelector(".alert-danger"));
    }
}
