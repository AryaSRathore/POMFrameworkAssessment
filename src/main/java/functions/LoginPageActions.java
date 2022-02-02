package functions;

import objectRepository.LoginPageElements;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class LoginPageActions extends CoreActions{
    public LoginPageActions(WebDriver driver){
        super(driver);
    }
    String currentTitle;
    String loginCredentialsAsString;
    String[] loginCredentialsAsList;
    String[] pasword;
    String passwrd;

    @Step("Get The list of usernames and password")
    public void getUserNameInfo(){
        loginCredentialsAsString = driver.findElement(LoginPageElements.LOGIN_CREDENTIALS_LIST).getText();
        loginCredentialsAsList = loginCredentialsAsString.split(System.lineSeparator());
        passwrd = driver.findElement(LoginPageElements.PASSWORD_LOCATOR).getText();
        pasword = passwrd.split(System.lineSeparator());

    }

    @Step("Log in to the site")
    public HomePageActions login(){
        for(int i = 1; i < loginCredentialsAsList.length; i++){
            driver.findElement(LoginPageElements.USERNAME_TXTBOX).clear();
            driver.findElement(LoginPageElements.USERNAME_TXTBOX).sendKeys(loginCredentialsAsList[i]);
            driver.findElement(LoginPageElements.PASSWORD_TXTBOX).clear();
            driver.findElement(LoginPageElements.PASSWORD_TXTBOX).sendKeys(pasword[1]);
            driver.findElement(LoginPageElements.LOGIN_BTN).click();
            currentTitle = driver.getTitle();
            if(currentTitle.equals(LoginPageElements.HOMEPAGETITLE))
                return new HomePageActions(driver);
            else
                continue;
        }
        return null;

    }

}
