package core;

import dataProvider.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.BrowserManager;

public class CoreTest {
    protected WebDriver driver;
    Constants constants;

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
