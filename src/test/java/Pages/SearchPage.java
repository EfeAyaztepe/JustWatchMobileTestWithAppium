package Pages;

import Test.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SearchPage extends BasePage{
    private static final Logger logger = LogManager.getLogger(SearchPage.class);
    public void searchSeries() throws InterruptedException {
        waitBymilliSeconds(800);
        String searchingSeriesName="Better Call Saul";
        click("searchButton_HomePage"); logger.info("Clicked to searchButton");
        sendKeys("searchBox_SearchPage",searchingSeriesName); logger.info("Key sent to searchBox");
        String suggestName=getText("suggestName_SearchPage"); logger.info("TvSeries Name get");
        if(searchingSeriesName.equals(suggestName)){
            System.out.println("isimler aynı ürüne gidiliyor"); logger.info("Tv Series Name Control Done");
            click("suggestName_SearchPage"); logger.info("Clicked to suggestName");
        }
    }


}
