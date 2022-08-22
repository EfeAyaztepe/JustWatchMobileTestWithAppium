package Pages;


import Test.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class HomePage extends BasePage{
    private static final Logger logger = LogManager.getLogger(HomePage.class);
    public void goToSettingsForLogin() throws InterruptedException {
        ReadJsons();
        waitBymilliSeconds(5000);
        click("signInButton_HomePage"); logger.info("Clicked to signInButton");
    }

    public void goToSettingsForLoginControl(){
        Assert.assertTrue(isElementVisible(findElementWait(getByy("settingsButton_HomePage")),10));
        Assert.assertTrue(isElementClickable(getByy("settingsButton_HomePage"),10));
        WebElement webElement = findElementWait(getByy("settingsButton_HomePage"));
        if(isElementVisible(webElement,20)) {
            isElementClickable(getByy("settingsButton_HomePage"),20);
            click("settingsButton_HomePage");
            logger.info("Login Control Done");

        }
        else{
            System.out.println("Element Bulunamadi");
        }
    }

    public void goToSeriesSection(){
    click("popularSection_HomePage"); logger.info("Clicked to popularSection");
    click("tvShowSection_HomePage");  logger.info("Clicked to tvShowSection");

    }


    public void goWatchList(){
        click("Watchlist_HomePage"); logger.info("Clicked to Watchlist_HomePage");
    }

    public void getRandomSeries() throws InterruptedException {
        waitBymilliSeconds(800);
        int minimum=0;
        int maximum=2;
        Random rand = new Random();
       int randomNum = minimum + rand.nextInt((maximum - minimum) + 1);
        String path="new UiSelector().resourceId(\"base\").childSelector(new UiSelector().className(\"android.widget.Image\").instance("+randomNum+"))";
        Assert.assertTrue(isElementClickable(getByy(path),10));
        click(path);
    }

    public void goToSettings(){
        click("settingsButton_HomePage");
    }

}
