package Pages;

import Test.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

public class SettingsPage extends BasePage{

    private static final Logger logger = LogManager.getLogger(SettingsPage.class);
    public void LoginControl(){
        String text;
        text=getText("loginControlText_SettingsPage");
        if(text.contains("Logged")){
            System.out.println("Giris Basarili!");
            Assert.assertTrue("Giris Basarisiz",text.contains("Logged"));
        }
        logger.info("Login Control Done");
    }

    public void closeSettings(){
        click("closeSettingsButton_SettingsPage"); logger.info("Clicked to closeSettingsButton");
    }
    public void Logout(){
        click("logoutButton_HomePage");
    }
}
