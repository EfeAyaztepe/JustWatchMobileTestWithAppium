package Pages;

import Test.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

public class ProductPage extends BasePage{
    private static final Logger logger = LogManager.getLogger(ProductPage.class);
   public void  isItProductPage(){
        Assert.assertTrue(isElementVisible(findElementWait(getByy("nameVisibility_ProductPage")),10));
        String seriesName=getText("nameVisibility_ProductPage");
       System.out.println(seriesName);
       logger.info("ProductPage Control Done");
    }
    public void trackSeries(){
        click("trackButton_ProductPage"); logger.info("Clicked to trackButton");
    }
    public void backToHome(){
        click("backButton_ProductPage"); logger.info("Clicked to backButton");
        click("backButton2_ProductPage"); logger.info("Clicked to backButton2");
    }

    public void platformControl(){
for(int i=0;i<2;i++){
    String path="new UiSelector().resourceId(\"base\").childSelector(new UiSelector().className(\"android.widget.Image\").textContains(\"A\").instance(0))";
    String platform;
    platform=findElementWait(getByy(path)).getText();
    System.out.println(platform); logger.info("//Platforms//");
    Assert.assertTrue(platform.contains("Amazon Prime Video")); logger.info("Amazon Platform Control Done");
}

    }

    public void clickNone(){
        click("None_ProductPage");
    }
    public void unTrack(){
       click("unTrack_ProductPage"); logger.info("Clicked to unTrack");
       Assert.assertTrue(isElementVisible(findElementWait(getByy("trackButton_ProductPage")),10)); logger.info("trackButton Visibility Control Done");
    }


}
