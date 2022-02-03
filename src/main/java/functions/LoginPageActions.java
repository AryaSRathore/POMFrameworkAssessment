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
        loginCredentialsAsString = gettext(LoginPageElements.LOGIN_CREDENTIALS_LIST);
        loginCredentialsAsList = loginCredentialsAsString.split(System.lineSeparator());
        passwrd = gettext(LoginPageElements.PASSWORD_LOCATOR);
        pasword = passwrd.split(System.lineSeparator());

    }

    @Step("Log in to the site")
    public HomePageActions login(){
        for(int i = 1; i < loginCredentialsAsList.length; i++){
            driver.findElement(LoginPageElements.USERNAME_TXTBOX).clear();
            enterText(LoginPageElements.USERNAME_TXTBOX, loginCredentialsAsList[i]);
            driver.findElement(LoginPageElements.PASSWORD_TXTBOX).clear();
            enterText(LoginPageElements.PASSWORD_TXTBOX, pasword[1]);
            click(LoginPageElements.LOGIN_BTN);
            currentTitle = driver.getTitle();
            if(!currentTitle.equals(LoginPageElements.HOMEPAGETITLE))
                return new HomePageActions(driver);
            else
                continue;
        }
        return null;

    }

}
