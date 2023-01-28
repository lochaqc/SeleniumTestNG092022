package lochaqc.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest{
    public WebDriver driver;

    @BeforeMethod
    public void createBrowser(){
        System.out.println("Start browser from BaseTest");
        driver = new ChromeDriver();
        driver.manage().window().maximize();


        //cờ đợi trang load xong (40s)
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @AfterMethod
    public void closeBrowser(){
        System.out.println("Close browser from BaseTest");
        driver.quit();
    }
}
