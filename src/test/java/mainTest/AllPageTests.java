package mainTest;

import Actions.LoginPageActions;
import core.CoreTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class AllPageTests extends CoreTest {
    LoginPageActions loginPageActions;

    @Test
    @Description("")
    public void initloginpageclass(){
        loginPageActions = new LoginPageActions(driver);
    }

    @Test(dependsOnMethods = "initloginpageclass")
    @Description("Test that launches the website and lets user login")
    @Severity(SeverityLevel.CRITICAL)
    public void testForLoggingIntoTheWesite(){
        logStep("Perform Login Operation");
        loginPageActions.login(username, password);

        logStep("Check whether the page opened is Homepage or not");
        loginPageActions.verifyHomepage();
    }

}
