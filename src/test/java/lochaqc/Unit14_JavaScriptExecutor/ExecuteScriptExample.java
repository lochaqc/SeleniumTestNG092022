package lochaqc.Unit14_JavaScriptExecutor;

import lochaqc.common.BaseTest_OLD;
import keyword.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ExecuteScriptExample extends BaseTest_OLD {

    @Test
    public void testScript01(){
        driver.get("https://demo.activeitzone.com/ecommerce/users/login");
        //driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click();
        //driver.findElement(By.xpath("//button[@onclick='autoFillSeller()']")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver; //Khai báo và khởi tạo giá trị cho đối tượng
        //js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@onclick='autoFillSeller()']")));
        driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click();

        //Điền giá trị vào input
        //Cách 1:
        //js.executeScript("document.getElementById('email').setAttribute('value','customer@example.com');");
        //js.executeScript("document.getElementById('password').setAttribute('value','123456');");

        //Cách 2
        //js.executeScript("arguments[0].setAttribute('value','customer@example.com');", driver.findElement(By.xpath("//input[@id='email']")));
        //js.executeScript("arguments[0].setAttribute('value','123456');", driver.findElement(By.xpath("//input[@id='password']")));

        //Cách 3: dùng 3 tham số
        js.executeScript("arguments[0].setAttribute('value', arguments[1]);", driver.findElement(By.xpath("//input[@id='email']")), "customer@example.com");
        js.executeScript("arguments[0].setAttribute('value', arguments[1]);", driver.findElement(By.xpath("//input[@id='password']")), "123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        WebUI.sleep(2);

        WebElement buttonUpgradePackage = driver.findElement(By.xpath("//a[normalize-space()='Upgrade Package']"));

        js.executeScript("arguments[0].scrollIntoView(true);", buttonUpgradePackage);
        WebUI.sleep(5);

    }

    @Test
    public void testScript02(){
        driver.get("https://demo.activeitzone.com/ecommerce/users/login");
        //driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click();
        //driver.findElement(By.xpath("//button[@onclick='autoFillSeller()']")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver; //Khai báo và khởi tạo giá trị cho đối tượng
        WebUI.sleep(1);
        driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click();
        //js.executeScript("alert('Welcome to the wonderland');");
        js.executeScript("arguments[0].style.border='3px solid red'", driver.findElement(By.xpath("//h1[normalize-space()='Login to your account.']")));
        WebUI.sleep(5);

    }


}
