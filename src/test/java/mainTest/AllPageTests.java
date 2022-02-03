package mainTest;

import functions.CartsPageFunction;
import functions.CheckoutPageActions;
import functions.HomePageActions;
import functions.LoginPageActions;
import core.CoreTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class AllPageTests extends CoreTest {
    String fetchedHomePageItemName;
    String fetchedHomePageItemPrice;
    LoginPageActions loginPageActions;

    @Test
    public void initloginpageclass(){
        loginPageActions = new LoginPageActions(driver);
    }
//
    @Test(dependsOnMethods = "initloginpageclass")
    @Description("Test that launches the website and lets user login and add an item to cart, verify item then proceed to checkout")
    @Severity(SeverityLevel.CRITICAL)
    public void testForLoggingIntoTheWebsiteAndAddingContentsToCart(){
        logStep("Get login credentials");
        loginPageActions.getUserNameInfo();

        logStep("Perform login Operation");
        HomePageActions homePageActions = loginPageActions.login();

        logStep("Click on add item button on first item on screen");
        homePageActions.addItemToCart();

        logStep("fetch Item Name and Price from home page and store it in variable");
        fetchedHomePageItemName = homePageActions.getItemName();
        fetchedHomePageItemPrice = homePageActions.getItemPrice();

        logStep("Navigate to Carts Page");
        CartsPageFunction cartsPageAction = homePageActions.goToCartsPage();

        logStep("Verify whether the added item is same as that of Cart Item");
        cartsPageAction.verifyTheItemDetails(fetchedHomePageItemName, fetchedHomePageItemPrice);

        logStep("Proceed to Checkout Page");
        CheckoutPageActions checkoutPageActions = cartsPageAction.checkOut();

        logStep("Filling in credentials and finishing the checkout process");
        checkoutPageActions.fillInCredentials();

        logStep("Click on BACK HOME BUTTON");
        HomePageActions homePageActions1 = checkoutPageActions.clickOnBackHomeBtn();

        logStep("Click on Carts page");
        CartsPageFunction cartsPageFunction1 = homePageActions1.goToCartsPage();

        logStep("Validating if the cart is empty after comleting checkout process");
        cartsPageAction.verifyIfCartIsEmpty();
    }


}
