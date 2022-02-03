package core;

import dataProvider.Constants;
import functions.LoginPageActions;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.BrowserManager;



public class CoreTest {
    protected WebDriver driver;
    Constants constants;
    LoginPageActions loginPageActions;

    @BeforeClass
    public void startBrowser(){
        driver = BrowserManager.getDriver();
        driver.get(constants.configFileReader());

    }



    protected static void logStep(String step){
        Logger.step(step);
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
