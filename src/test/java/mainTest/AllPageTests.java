package mainTest;

import Actions.CartsPageAction;
import Actions.CheckoutPageActions;
import Actions.HomePageActions;
import Actions.LoginPageActions;
import core.CoreTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class AllPageTests extends CoreTest {
    LoginPageActions loginPageActions;
    HomePageActions homePageActions;
    CartsPageAction cartsPageAction;
    CheckoutPageActions checkoutPageActions;

    @Test(priority = 1)
    @Description("")
    public void initloginpageclass(){
        loginPageActions = new LoginPageActions(driver);
    }

    @Test(dependsOnMethods = "initloginpageclass", priority = 2)
    @Description("Test that launches the website and lets user login")
    @Severity(SeverityLevel.CRITICAL)
    public void testForLoggingIntoTheWesite(){
        logStep("Get login credentials");
        loginPageActions.getUserNameInfo();

        logStep("Perform login Operation");
        loginPageActions.login();

    }

    @Test(dependsOnMethods = "initloginpageclass", priority = 3)
    @Description("")
    @Severity(SeverityLevel.NORMAL)
    public void testForAddingItemToTheCartAndNavigatingToCartsPage(){
        logStep("Click on add item button on first item on screen");
        homePageActions.addItemToCart();

        logStep("Navigate to Carts Page");
        homePageActions.goToCartsPage();
    }

    @Test(dependsOnMethods = "initloginpageclass", priority = 4)
    @Description("")
    @Severity(SeverityLevel.NORMAL)
    public void testForVerifyingItemsOnCartsPage(){

        logStep("Verify whether the added item is same as that of Cart Item");
        cartsPageAction.verifyTheItemDetails();

        logStep("Proceed to Checkout Page");
        cartsPageAction.checkOut();
    }

    @Test(priority = 5)
    @Description("")
    @Severity(SeverityLevel.NORMAL)
    public void testForCompletingCheckout(){
        logStep("Filling in credentials and finishing the checkout process");
        checkoutPageActions.fillInCredentials();
    }

    @Test(priority = 6)
    @Description("")
    @Severity(SeverityLevel.NORMAL)
    public void testForValidatingWhetherTheCartIsEmptyAfterCheckout(){
        logStep("Validating if the cart is empty after comleting checkout process");
        cartsPageAction.verifyIfCartIsEmpty();
    }

}
