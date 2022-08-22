package Pages;

import Json.Elements;
import Test.BaseTest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasePage extends BaseTest {

    public static Reader reader;
    FluentWait<AndroidDriver<MobileElement>> wait;
    public BasePage(){
        wait = setFluentWait(15);
    }
    public FluentWait<AndroidDriver<MobileElement>> setFluentWait(long timeout){

        return new FluentWait<>(BaseTest.driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
    }

    WebElement findElementWait(By by){
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void click(String key){
        findElementWait(getByy(key)).click();
    }


    public void waitBymilliSeconds(int Seconds) throws InterruptedException {
        Thread.sleep(Seconds+1000);
    }

    public void sendKeys(String key,String text){
        findElementWait(getByy(key)).sendKeys(text);
    }

    public String getText(String key){
        return findElementWait(getByy(key)).getText();
    }
    public boolean isElementVisible(WebElement webElement, long timeout){

        try {
            setFluentWait(timeout).until(ExpectedConditions.visibilityOf(webElement));
            return true;
        }catch (Exception e){
            return false;
        }
    }


    public static void ReadJsons(){
        try {
            Path path = Paths.get("src/test/java/JsonFiles");
            List<Path> paths = findByFileExtension(path, ".json");
            List<Elements> jsonElements = null;
            for (Path value : paths) {
                reader = new BufferedReader(new FileReader(String.valueOf(value)));
                jsonElements = new Gson().fromJson(reader, TypeToken.getParameterized(List.class, Elements.class).getType());

                assert jsonElements != null;
                jsonElements.parallelStream().forEach(a -> map.put(a.getKey(), a));

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static List<Path> findByFileExtension(Path path, String fileExtension)
            throws IOException {

        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException("Path must be a directory!");
        }

        List<Path> result;
        try (Stream<Path> walk = Files.walk(path)) {
            result = walk
                    .filter(Files::isRegularFile)
                    .filter(p -> p.getFileName().toString().endsWith(fileExtension))
                    .collect(Collectors.toList());
        }
        return result;

    }

    public boolean isElementClickable(By by, long timeout){

        try {
            setFluentWait(timeout).until(ExpectedConditions.elementToBeClickable(by));
            return true;
        }catch (Exception e){
            return false;
        }
    }


    public By getByy(String key){
        By locater = null;
        if(!map.containsKey(key)){
            throw new NullPointerException(key + " elementi Bulunamadı");
        }
        Elements elements = map.get(key);
        String value = elements.getValue();
        switch (elements.getType().trim()){

            case "xpath":locater=MobileBy.xpath(elements.getValue());
                break;
            case "UiSelector":locater=MobileBy.AndroidUIAutomator(elements.getValue());
                break;
            case "id":locater=MobileBy.id(elements.getValue());
                break;
            default:System.out.println("Element Bulunamadı");
                Assert.fail(key + " elementinin " + elements.getType() + " tipi hatalı");
        }
        return locater;
    }

}
