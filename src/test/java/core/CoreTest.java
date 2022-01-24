package core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.BrowserManager;
import utils.Constants;

public class CoreTest {
    protected WebDriver driver;
    protected String username = "standard_user";
    protected String password = "secret_sauce";

    @BeforeClass
    public void startBrowser(){
        driver = BrowserManager.getDriver();
        driver.get(Constants.url);

    }

    protected static void logStep(String step){
        Logger.step(step);
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
