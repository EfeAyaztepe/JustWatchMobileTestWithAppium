package Pages;

import Test.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(LoginPage.class);
    public void Login() throws InterruptedException {
        click("continueWithGoogle_LoginPage"); logger.info("Clicked to continueWithGoogle");
        click("selectEmail_LoginPage");        logger.info("Clicked to selectEmail");
        waitBymilliSeconds(5000);


    }
}
