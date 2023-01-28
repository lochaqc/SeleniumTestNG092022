package keyword;




import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




import java.time.Duration;
import java.util.List;

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

    public static Boolean checkElementExist(WebDriver driver, By by){
        List<WebElement> listElement = driver.findElements(by);

        if (listElement.size() > 0){
            System.out.println("Element "+ by + "existing");
            return true;
        } else {
            System.out.println("Element "+ by + "NOT exist");
            return false;

        }

    }

    public static Boolean checkElementExist(WebDriver driver, String xpath){
        List<WebElement> listElement = driver.findElements(By.xpath(xpath));

        if (listElement.size() > 0){
            System.out.println("Element "+ xpath + "existing");
            return true;
        } else {
            System.out.println("Element "+ xpath + "NOT exist");
            return false;

        }


    }

    /**
     * Wait for Page loaded
     * Chờ đợi trang tải xong (Javascript tải xong)
     */





}
