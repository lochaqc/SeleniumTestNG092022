package lochaqc.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest_OLD {
    public WebDriver driver;

    @BeforeMethod
    public void createBrowser(){
        System.out.println("Start browser from BaseTest_OLD");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //chờ đợi ngầm định cho mỗi câu lệnh tìm driver.findElement với time = 10s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //cờ đợi trang load xong (40s)
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @AfterMethod
    public void closeBrowser(){
        System.out.println("Close browser from BaseTest_OLD");
        driver.quit();
    }

}
