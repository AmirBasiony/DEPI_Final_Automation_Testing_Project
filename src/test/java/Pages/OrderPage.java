package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {

    WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Add item to shipping Cart
    public  void  clickToAddCart(){
        driver.findElement(By.id("button-cart")).click();
    }

    // Add item to Wish list
    public  void  clickToAddToWishList(){
        driver.findElement(By.cssSelector("button[ data-original-title='Add to Wish List']")).click();
    }
    // Add item to Compare list
    public  void  clickToAddToCompareList(){
        driver.findElement(By.cssSelector("button[ data-original-title='Compare this Product']")).click();
    }
}
