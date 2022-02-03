package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CoreActions {
    protected final WebDriver driver;
    protected CoreActions(WebDriver driver){
        this.driver=driver;
    }



    protected void enterText(By element, String text) {
        driver.findElement(element).sendKeys(text);
    }

    protected void click(By element) {
        driver.findElement(element).click();
    }

    protected void click(WebElement element) {
        element.click();
    }

    protected String gettext(By element) {
        return driver.findElement(element).getText();
    }


}
