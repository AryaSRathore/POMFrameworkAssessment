package Pages;

import org.openqa.selenium.By;

public class LoginPageElements {
    public static final By USERNAME_TXTBOX = By.xpath("//input[@id='user-name']");
    public static final By PASSWORD_TXTBOX = By.xpath("//input[@id='password']");
    public static final By LOGIN_BTN = By.xpath("//input[@id='login-button']");
    public static final By ERROR_MSG = By.xpath("//h3[contains(text(), 'Epic sadface: Username is required')]");
    public static final String USERNAME = "standard_user";
    public static final String PASSWORD = "secret_sauce";
    public static final String HOMEPAGETITLE = "Swag Labs";


}
