package Pages;

import Test.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

public class WatchlistPage extends BasePage{
    private static final Logger logger = LogManager.getLogger(WatchlistPage.class);
    public void goToTvSeries(){
        click("TvSeries_WatchlistPage"); logger.info("Clicked to TvSeries");
    }

    public void backToHome() throws InterruptedException {
        waitBymilliSeconds(3000);
        click("Home_WatchlistPage");
    }

    public void itemControl(){
        Assert.assertTrue(isElementVisible(findElementWait(getByy("item_WatchlistPage")),10)); logger.info("Item successfully added to watchlist");
    }
}
