package Actions;

import Pages.CartPageElements;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartsPageAction extends CoreActions{

    String fetchedItemNameOnHomePage;
    String fetchedItemPriceOnHomePage;
    String currentItemName;
    String currentItemPrice;
    HomePageActions homePageActions;

    public CartsPageAction(WebDriver driver){
        super(driver);
    }

    @Step("Verify whether the item name and prices are same or not")
    public void verifyTheItemDetails(){
        fetchedItemNameOnHomePage = homePageActions.getItemName();
        fetchedItemPriceOnHomePage = homePageActions.getItemPrice();
        currentItemName = driver.findElement(CartPageElements.ITEM_NAME).getText();
        currentItemPrice = driver.findElement(CartPageElements.ITEM_PRICE).getText();

        Assert.assertEquals(currentItemName, fetchedItemNameOnHomePage);
        Assert.assertEquals(currentItemPrice, fetchedItemPriceOnHomePage);
    }

    @Step("Perform Checkout Operation")
    public void checkOut(){
        driver.findElement(CartPageElements.CHECKOUT).click();
    }

    @Step("Verify whether the cart is empty after checking out")
    public void verifyIfCartIsEmpty(){
        Boolean result = driver.findElement(CartPageElements.CART_COLUMN).isDisplayed();
        Assert.assertFalse(result);
    }

}
