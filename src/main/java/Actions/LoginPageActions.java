package Actions;

import Pages.LoginPageElements;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class LoginPageActions extends CoreActions{
    public LoginPageActions(WebDriver driver){
        super(driver);
    }
    String currentTitle;
    String loginCredentialsAsString;
    String[] loginCredentialsAsList;
    String passwrd;

    @Step("Get The list of usernames and password")
    public void getUserNameInfo(){
        loginCredentialsAsString = driver.findElement(LoginPageElements.LOGIN_CREDENTIALS_LIST).getText();
        loginCredentialsAsList = loginCredentialsAsString.split(System.lineSeparator());
        passwrd = driver.findElement(LoginPageElements.PASSWORD_LOCATOR).getText();
    }

    @Step("Log in to the site")
    public void login(){
        for(int i = 1; i < loginCredentialsAsList.length; i++){
            driver.findElement(LoginPageElements.USERNAME_TXTBOX).clear();
            driver.findElement(LoginPageElements.USERNAME_TXTBOX).sendKeys(loginCredentialsAsList[i]);
            driver.findElement(LoginPageElements.PASSWORD_TXTBOX).clear();
            driver.findElement(LoginPageElements.PASSWORD_TXTBOX).sendKeys(passwrd);
            driver.findElement(LoginPageElements.LOGIN_BTN).click();
            currentTitle = driver.getTitle();
            if(currentTitle.equals(LoginPageElements.HOMEPAGETITLE))
                break;
            else
                continue;

        }

    }

}
