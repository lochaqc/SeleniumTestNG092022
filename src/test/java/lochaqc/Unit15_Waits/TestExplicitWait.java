package lochaqc.Unit15_Waits;

import keyword.WebUI;
import lochaqc.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestExplicitWait extends BaseTest {

    @Test
    public void loginHRM_NoWait(){
        driver.get("https://app.hrsale.com/erp/login");
        driver.findElement(By.xpath("//button[normalize-space()='Super Admin']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Employees']")).click();

    }

    @Test
    public void loginHRM_Wait(){
        driver.get("https://app.hrsale.com/erp/login");
        driver.findElement(By.xpath("//button[normalize-space()='Super Admin']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Employees']")));
        driver.findElement(By.xpath("//span[normalize-space()='Employees']")).click();

    }
    @Test
    public void addBrandCMS(){
        driver.get("http://cms.anhtester.com/login");
        driver.findElement(By.xpath("//button[normalize-space()='Copy']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Brand']")));
        WebUI.waitForElementVisible(driver,By.xpath("//span[normalize-space()='Brand']"), 5 );
        driver.findElement(By.xpath("//span[normalize-space()='Brand']")).click();
        String headerAddNewBrand = driver.findElement(By.xpath("//div[@class='card-header']/h5")).getText();
        System.out.println(headerAddNewBrand);
        Assert.assertEquals(headerAddNewBrand, "Add New Brand");
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Demo brand1", Keys.ENTER);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr/td[2]")));
        WebUI.waitForElementVisible(driver,By.xpath("//tbody/tr/td[2]"), 7 );
        String brandName = driver.findElement(By.xpath("//tbody/tr/td[2]")).getText();
        System.out.println(brandName);
        Assert.assertEquals(brandName, "Demo brand1");




    }




}
