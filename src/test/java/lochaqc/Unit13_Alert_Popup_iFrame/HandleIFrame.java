package lochaqc.Unit13_Alert_Popup_iFrame;

import lochaqc.common.BaseTest_OLD;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HandleIFrame extends BaseTest_OLD {
    @Test
    public void iFrame01() throws InterruptedException {

        driver.get("https://anhtester.com/contact");
        Thread.sleep(10000);
        System.out.println("iframe total: " + driver.findElements(By.tagName("iframe")).size());
        Thread.sleep(1000);
        //----Switch to content of Messenger--------
        driver.switchTo().frame(0);
        System.out.println(driver.findElement(By.tagName("strong")).getText());

        //----Switch to icon of Messenger---------

        //1. Switch to Parent WindowHandle
        driver.switchTo().parentFrame();

        //2. Switch to iframe icon of Messenger
        driver.switchTo().frame(1);
        driver.findElement(By.tagName("svg")).click(); //Nhấn icon để ẩn messenger chat đi

        Thread.sleep(2000);
    }
}
