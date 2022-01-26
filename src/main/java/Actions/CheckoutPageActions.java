package Actions;

import Pages.CheckoutPageElements;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CheckoutPageActions extends CoreActions{
    public CheckoutPageActions(WebDriver driver){super(driver);}

    @Step("Fill in the information and click on continue button and proceed to finish")
    public void fillInCredentials(){
        driver.findElement(CheckoutPageElements.FIRST_NAME_TXTBOX).sendKeys(CheckoutPageElements.First_Name);
        driver.findElement(CheckoutPageElements.LAST_NAME_TXTBOX).sendKeys(CheckoutPageElements.Last_Name);
        driver.findElement(CheckoutPageElements.POSTAL_CODE_TXTBOX).sendKeys(CheckoutPageElements.Postal_Code);
        driver.findElement(CheckoutPageElements.CONTINUE_BTN).click();
        driver.findElement(CheckoutPageElements.FINISH_BTN).click();
    }
}
