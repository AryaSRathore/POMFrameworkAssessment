package objectRepository;

import org.openqa.selenium.By;

public class LoginPageElements {
    public static final By USERNAME_TXTBOX = By.xpath("//input[@id='user-name']");
    public static final By PASSWORD_TXTBOX = By.xpath("//input[@id='password']");
    public static final By LOGIN_BTN = By.xpath("//input[@id='login-button']");
    public static final By ERROR_MSG_Locator = By.xpath("//h3//button[@class='error-button']");
    public static final By PASSWORD_LOCATOR = By.xpath("//div[@class='login_password']");
    public static final By LOGIN_CREDENTIALS_LIST = By.xpath("//div[@id='login_credentials']");
    public static final String HOMEPAGETITLE = "Swag Labs";



}
