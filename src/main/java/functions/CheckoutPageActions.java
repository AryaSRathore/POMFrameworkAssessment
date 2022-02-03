package functions;

import objectRepository.CheckoutPageElements;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CheckoutPageActions extends CoreActions{
    public CheckoutPageActions(WebDriver driver){super(driver);}

    @Step("Fill in the information and click on continue button and proceed to finish")
    public void fillInCredentials(){
        enterText(CheckoutPageElements.FIRST_NAME_TXTBOX, CheckoutPageElements.First_Name);
        enterText(CheckoutPageElements.LAST_NAME_TXTBOX, CheckoutPageElements.Last_Name);
        enterText(CheckoutPageElements.POSTAL_CODE_TXTBOX, CheckoutPageElements.Postal_Code);
        click(CheckoutPageElements.CONTINUE_BTN);
        click(CheckoutPageElements.FINISH_BTN);
    }

    @Step("Click on BACK HOME BUTTON")
    public HomePageActions clickOnBackHomeBtn(){
        click(CheckoutPageElements.BACK_HOME_BTN);
        return new HomePageActions(driver);
    }
}
