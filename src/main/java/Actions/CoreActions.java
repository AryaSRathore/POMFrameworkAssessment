package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoreActions {
    protected final WebDriver driver;
    protected CoreActions(WebDriver driver){
        this.driver=driver;
    }



    protected void enterText(By element, String text) {
        driver.findElement(element).sendKeys(text);
    }



    public static void sleep(double sec) {
        try {
            Thread.sleep((long) (sec * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
