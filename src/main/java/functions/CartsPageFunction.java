package functions;

import objectRepository.CartPageElements;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class CartsPageFunction extends CoreActions{
    String currentItemName;
    String currentItemPrice;
    Boolean result;
    SoftAssert softAssert = new SoftAssert();
    HomePageActions homePageActions;

    public CartsPageFunction(WebDriver driver){
        super(driver);
    }

    @Step("Verify whether the item name and prices are same or not")
    public void verifyTheItemDetails(String homePageItemName, String homePageItemPrice){
        currentItemName = driver.findElement(CartPageElements.ITEM_NAME).getText();
        currentItemPrice = driver.findElement(CartPageElements.ITEM_PRICE).getText();

        softAssert.assertEquals(currentItemName, homePageItemName);
        softAssert.assertEquals(currentItemPrice, homePageItemPrice);
    }

    @Step("Perform Checkout Operation")
    public CheckoutPageActions checkOut(){
        driver.findElement(CartPageElements.CHECKOUT).click();
        return new CheckoutPageActions(driver);
    }

    @Step("Verify whether the cart is empty after checking out")
    public void verifyIfCartIsEmpty(){
        try {
            if (driver.findElement(CartPageElements.CART_COLUMN).isDisplayed())
                System.out.println("The Cart is not empty");
        }catch (NoSuchElementException e){
            System.out.println("This Cart is empty");
        }
    }

}
