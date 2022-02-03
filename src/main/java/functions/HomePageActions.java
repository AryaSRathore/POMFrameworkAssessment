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
        click(HomePageElements.ITEM1);
    }

    @Step("Get name of the item added in cart")
    public String getItemName(){
        itemName = gettext(HomePageElements.INVENTORY_ITEM_NAME);
        return itemName;
    }

    @Step("Get price of the item added in cart")
    public String getItemPrice(){
        itemPrice = gettext(HomePageElements.INVENTORY_ITEM_PRICE);
        return itemPrice;
    }

    @Step("Go to Carts page")
    public CartsPageFunction goToCartsPage(){
        click(HomePageElements.CARTS_BTN);
        return new CartsPageFunction(driver);
    }
}
