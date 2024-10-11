package Tests;

import org.openqa.selenium.By;
import org.testng.Assert;

public class OrderTest extends TestBase {

    // Check On adding the item is success We have too Ways
     /************ 1- Adding item through cart Item *************/
    public  void AddingItemToListIsSuccessfulThroughCartItem(){
        // 1- Navigate to home page
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=common/home");
        // Select Specific Item
        driver.findElement(By.cssSelector("button[onclick='cart.add('40');']"));
        // 2- Adding Item To the cart
        driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']"));
    }
    /************ 2- Adding item through Navigate to the  Item page  *************/
    public  void AddingItemToListIsSuccessfulThroughNavigateToItemPage(){
        // 1- Navigate to home page
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=common/home");
        // Select Specific Item
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=product/product&amp;product_id=40");
        // 2- Adding Item To the cart
        orderPage_object.clickToAddCart();
        driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']"));

    }

}
