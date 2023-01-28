package lochaqc.Unit13_Alert_Popup_iFrame;

import lochaqc.common.BaseTest_OLD;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandleAlert extends BaseTest_OLD {
    @Test
    public void TestAlert01() throws InterruptedException {
        driver.get("http://demo.guru99.com/test/delete_customer.php");

        driver.findElement(By.name("cusid")).sendKeys("53920");
        driver.findElement(By.name("submit")).submit();

        // Khai báo chuyển hướng đến Alert với đối tượng
        Alert alert = driver.switchTo().alert();

        // Get message trên alert
        String alertMessage = driver.switchTo().alert().getText();

        // Displaying alert message
        System.out.println(alertMessage);
        Thread.sleep(2000);

        // accept() = nhấn Ok button
        // driver.switchTo().alert().accept(); //Cách 1
        alert.accept(); //Cách 2

        //Nhấn Cancel button
        //alert.dismiss();

        Thread.sleep(8000);

        Alert alert2 = driver.switchTo().alert();

        Thread.sleep(2000);

        System.out.println(alert2.getText());
    }

    @Test
    public void TestAlert02() throws InterruptedException {
        driver.get("http://demo.automationtesting.in/Alerts.html");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[normalize-space()='Alert with Textbox']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='click the button to demonstrate the prompt box']")).click();
        //button[normalize-space()='click the button to demonstrate the prompt box']
        //Nhấn sendKeys vào ô text
        driver.switchTo().alert().sendKeys("Anh Tester");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        WebElement resut = driver.findElement(By.xpath("//p[@id='demo1']"));
        System.out.println(resut.getText());
        Assert.assertTrue(resut.getText().contains("Anh Tester"), "Value has not been filled yet");
        Thread.sleep(2);

    }




}
