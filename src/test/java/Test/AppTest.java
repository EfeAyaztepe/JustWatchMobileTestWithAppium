package Test;

import Pages.*;
import org.junit.Test;

public class AppTest extends BaseTest{
    @Test
    public void JustWatchTest() throws InterruptedException {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        SearchPage searchPage = new SearchPage();
        SettingsPage settingsPage = new SettingsPage();
        ProductPage productPage = new ProductPage();
        WatchlistPage watchlistPage = new WatchlistPage();
        BasePage basePage = new BasePage();

        homePage.goToSettingsForLogin();
        loginPage.Login();
        homePage.goToSettingsForLoginControl();
        settingsPage.LoginControl();
        settingsPage.closeSettings();
        searchPage.searchSeries();
        productPage.isItProductPage();
        productPage.trackSeries();
        productPage.backToHome();
        homePage.goWatchList();
        watchlistPage.itemControl();
        homePage.goToSettings();
        settingsPage.Logout();
        //For Merge////
        ///////////////////
        ///////////////////




    }
}
