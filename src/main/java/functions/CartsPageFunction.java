package functions;

import objectRepository.CartPageElements;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class CartsPageFunction extends CoreActions{
    String currentItemName;
    String currentItemPrice;
    SoftAssert softAssert = new SoftAssert();

    public CartsPageFunction(WebDriver driver){
        super(driver);
    }

    @Step("Verify whether the item name and prices are same or not")
    public void verifyTheItemDetails(String homePageItemName, String homePageItemPrice){
        currentItemName = gettext(CartPageElements.ITEM_NAME);
        currentItemPrice = gettext(CartPageElements.ITEM_PRICE);

        softAssert.assertEquals(currentItemName, homePageItemName);
        softAssert.assertEquals(currentItemPrice, homePageItemPrice);
    }

    @Step("Perform Checkout Operation")
    public CheckoutPageActions checkOut(){
        click(CartPageElements.CHECKOUT);
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
