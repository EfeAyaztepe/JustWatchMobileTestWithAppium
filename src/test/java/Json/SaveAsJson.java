package Json;

import Json.Elements;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SaveAsJson {

    static String signInButton_HomePage="new UiSelector().className(\"android.widget.Button\").text(\"Sign in\")";
    static String continueWithGoogle_LoginPage="new UiSelector().text(\"Continue with Google\")";
    static String selectEmail_LoginPage="com.google.android.gms:id/container";
    static String loginControlText_SettingsPage="new UiSelector().text(\"Logged in with \")";
    static String closeSettingsButton_SettingsPage="new UiSelector().resourceId(\"android:id/content\").childSelector(new UiSelector().className(\"android.widget.Button\").index(1))";
    static String acceptCookiesButton_HomePage="new UiSelector().className(\"android.widget.Button\").text(\"I agree\")";
    static String searchButton_HomePage="\t\n" +
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android" +
            ".widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View" +
            "/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[1]/" +
            "android.widget.Button";
    static String searchBox_SearchPage="new UiSelector().resourceId(\"base\").childSelector(new UiSelector().className(\"android.widget.EditText\"))";
    static String suggestName_SearchPage="new UiSelector().resourceId(\"base\").childSelector(new UiSelector().text(\"Better Call Saul\").index(1))";
    static String trackButton_ProductPage="new UiSelector().className(\"android.widget.Button\").text(\"Track show\")";
    static String TvSeries_WatchlistPage="new UiSelector().resourceId(\"base\").childSelector(new UiSelector().className(\"android.view.View\").descriptionContains(\"Saul\"))";

    public static void main(String[] args) throws IOException {

        Elements hobj1=new Elements("signInButton","UiSelector",signInButton_HomePage);
        Elements hobj2=new Elements("acceptCookie","UiSelector",acceptCookiesButton_HomePage);
        Elements hobj3=new Elements("searchButton","xpath",searchButton_HomePage);

        Elements lobj1=new Elements("continueWithLogin","UiSelector",continueWithGoogle_LoginPage);
        Elements lobj2=new Elements("selectEmail","UiSelector",selectEmail_LoginPage);

        Elements settingsobj1=new Elements("loginControlText","UiSelector",loginControlText_SettingsPage);
        Elements settingsobj2=new Elements("closeSettingsButton","UiSelector",closeSettingsButton_SettingsPage);

        Elements searchobj1=new Elements("searchBox","UiSelector",searchBox_SearchPage);
        Elements searchobj2=new Elements("suggestName","UiSelector",closeSettingsButton_SettingsPage);
        Elements searchobj3=new Elements("suggestName","UiSelector",suggestName_SearchPage);

        Elements pobj1=new Elements("trackButton","UiSelector",trackButton_ProductPage);

        Elements wobj1 = new Elements("TvSeries","UiSelector",TvSeries_WatchlistPage);


        List<Object>HomePageList = new ArrayList<>(Arrays.asList(hobj1,hobj2,hobj3));
        List<Object>LoginPageList = new ArrayList<>(Arrays.asList(lobj1,lobj2));
        List<Object>SettingsPageList = new ArrayList<>(Arrays.asList(settingsobj1,settingsobj2));
        List<Object>SearchPageList = new ArrayList<>(Arrays.asList(searchobj1,searchobj2));
        List<Object>ProductPageList = new ArrayList<>(Arrays.asList(pobj1));
        List<Object>WatchlistPageList= new ArrayList<>(Arrays.asList(wobj1));



        Writer writer = new FileWriter("src/test/java/JsonFiles/HomePage.json");
        try {
            Gson gson1 = (new GsonBuilder()).setPrettyPrinting().create();
            gson1.toJson(HomePageList, writer);
        } catch (Exception e) {
        }
        writer.close();


        writer = new FileWriter("src/test/java/JsonFiles/LoginPage.json");
        try {
            Gson gson1 = (new GsonBuilder()).setPrettyPrinting().create();
            gson1.toJson(LoginPageList, writer);
        } catch (Exception e) {
        }
        writer.close();


        writer = new FileWriter("src/test/java/JsonFiles/SettingsPage.json");
        try {
            Gson gson1 = (new GsonBuilder()).setPrettyPrinting().create();
            gson1.toJson(SettingsPageList, writer);
        } catch (Exception e) {
        }
        writer.close();


        writer = new FileWriter("src/test/java/JsonFiles/SearchPage.json");
        try {
            Gson gson1 = (new GsonBuilder()).setPrettyPrinting().create();
            gson1.toJson(SearchPageList, writer);
        } catch (Exception e) {
        }
        writer.close();


        writer = new FileWriter("src/test/java/JsonFiles/ProductPage.json");
        try {
            Gson gson1 = (new GsonBuilder()).setPrettyPrinting().create();
            gson1.toJson(ProductPageList, writer);
        } catch (Exception e) {
        }
        writer.close();



        writer = new FileWriter("src/test/java/JsonFiles/WatchlistPage.json");
        try {
            Gson gson1 = (new GsonBuilder()).setPrettyPrinting().create();
            gson1.toJson(WatchlistPageList, writer);
        } catch (Exception e) {
        }
        writer.close();
    }
}
