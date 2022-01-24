package Actions;

import Pages.LoginPageElements;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPageActions extends CoreActions{
    public LoginPageActions(WebDriver driver){
        super(driver);
    }
    String currentTitle;

    @Step("Log in to the site")
    public void login(String username, String Password){
        driver.findElement(LoginPageElements.USERNAME_TXTBOX).clear();
        driver.findElement(LoginPageElements.USERNAME_TXTBOX).sendKeys(username);
        driver.findElement(LoginPageElements.PASSWORD_TXTBOX).clear();
        driver.findElement(LoginPageElements.PASSWORD_TXTBOX).sendKeys(Password);

    }

    @Step("Verify the opened page")
    public void verifyHomepage(){
        currentTitle = driver.getTitle();
        Assert.assertEquals(currentTitle, LoginPageElements.HOMEPAGETITLE);
    }

}
