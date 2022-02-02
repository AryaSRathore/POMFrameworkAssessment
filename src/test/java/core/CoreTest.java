package core;

import dataProvider.Constants;
import functions.LoginPageActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import utils.BrowserManager;



public class CoreTest {
    protected WebDriver driver;
    Constants constants;

    @BeforeClass
    public void startBrowser(){
        driver = BrowserManager.getDriver();
        driver.get(constants.configFileReader());
//        LoginPageActions loginPageActions = new LoginPageActions(driver);

    }


//    @BeforeTest
//    public void initloginpageclass(){
//        LoginPageActions loginPageActions = new LoginPageActions(driver);
//    }

    protected static void logStep(String step){
        Logger.step(step);
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
