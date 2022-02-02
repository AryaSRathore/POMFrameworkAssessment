package functions;

import objectRepository.HomePageElements;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class HomePageActions extends CoreActions{
    public HomePageActions(WebDriver driver){
        super(driver);
    }

    String itemName;
    String itemPrice;

    @Step("Add an item to cart")
    public void addItemToCart(){
        driver.findElement(HomePageElements.ITEM1).click();
    }

    @Step("Get name of the item added in cart")
    public String getItemName(){
        itemName = driver.findElement(HomePageElements.INVENTORY_ITEM_NAME).getText();
        return itemName;
    }

    @Step("Get price of the item added in cart")
    public String getItemPrice(){
        itemPrice = driver.findElement(HomePageElements.INVENTORY_ITEM_PRICE).getText();
        return itemPrice;
    }

    @Step("Go to Carts page")
    public CartsPageFunction goToCartsPage(){
        driver.findElement(HomePageElements.CARTS_BTN).click();
        return new CartsPageFunction(driver);
    }
}
