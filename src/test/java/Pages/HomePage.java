package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void SearchOnSpecificItem( String item){
        //3- locate search bar
        WebElement SearchBar= driver.findElement(By.cssSelector("input[class='form-control input-lg']"));
        //4- Action --> Search for item
        SearchBar.sendKeys(item);
        SearchBar.sendKeys(Keys.ENTER);
    }



}


