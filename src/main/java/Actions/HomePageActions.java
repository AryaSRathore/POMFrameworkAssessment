package Actions;

import Pages.HomePageElements;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class HomePageActions extends CoreActions{
    public HomePageActions(WebDriver driver){
        super(driver);
    }

    @Step("Add an item to cart")
    public void addItemToCart(){
        driver.findElement(HomePageElements.ITEM1).click();

    }
}
