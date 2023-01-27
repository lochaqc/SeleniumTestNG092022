package keyword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebUI {
    public static void sleep(double second){
        try{
            Thread.sleep((long)(1000*second));
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    public static void waitForElementVisible(WebDriver driver, By by, int second){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));


    }
}
