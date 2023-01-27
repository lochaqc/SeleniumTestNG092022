package lochaqc.Bai15_Waits;

import lochaqc.common.BaseTest_OLD;
import keyword.WebUI;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestImplicitWait extends BaseTest_OLD {
    @Test
    public void loginCRM(){

        driver.get("https://rise.fairsketch.com/signin");
        //driver.findElement(By.xpath("//button[normalize-space()='Super Admin']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Clients']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Clients')]")).click();

        WebUI.sleep(2);

    }
    @Test
    public void loginHRM(){

        driver.get("https://app.hrsale.com/erp/login");
        driver.findElement(By.xpath("//button[normalize-space()='Super Admin']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Employees']")).click();
        WebUI.sleep(2);

    }

}
