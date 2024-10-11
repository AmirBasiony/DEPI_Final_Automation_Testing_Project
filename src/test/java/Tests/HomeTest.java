package Tests;

public class HomeTest extends TestBase{

    public void SearchOnSpecificItem(){
        // 1- Navigate To home Page
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=common/home");
        homePage_object.SearchOnSpecificItem("iphone");


    }

}
