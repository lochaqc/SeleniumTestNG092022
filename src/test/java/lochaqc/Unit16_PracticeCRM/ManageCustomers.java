package lochaqc.Unit16_PracticeCRM;

import keyword.WebUI;
import lochaqc.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class ManageCustomers extends BaseTest {


    public static void waitForPageLoaded(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return js.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        //Check JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            System.out.println("Javascript is NOT Ready.");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                error.printStackTrace();
                Assert.fail("FAILED. Timeout waiting for page load.");



            }
        }
    }


    @BeforeMethod
    public void loginCRM(){
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }

    private String CUSTOMER_NAME = "CMC Global";
    private String WEBSITE = "https://cmcglobal.com.vn/vi/home-vi/";

    @Test
    public void addCustomer(){
        //loginCRM();
        waitForPageLoaded(driver);
        driver.findElement(By.xpath("//span[normalize-space()='Customers']")).click();
        //driver.findElement(By.xpath("//a[normalize-space()='New Customer']")).click();
        //driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Anh Tester Blog");

        driver.findElement(By.xpath("//a[normalize-space()='New Customer']")).click();
        driver.findElement(By.id("company")).sendKeys(CUSTOMER_NAME);
        driver.findElement(By.id("vat")).sendKeys("10");
        driver.findElement(By.id("phonenumber")).sendKeys("0123456789");
        driver.findElement(By.id("website")).sendKeys(WEBSITE);
        WebUI.sleep(1);
        driver.findElement(By.xpath("//label[@for='groups_in[]']/following-sibling::div")).click();
        WebUI.sleep(1);
        driver.findElement(By.xpath("//label[@for='groups_in[]']/following-sibling::div//input[@type='search']")).sendKeys("Gold", Keys.ENTER);
        WebUI.sleep(1);
        driver.findElement(By.xpath("//label[@for='groups_in[]']/following-sibling::div")).click();
        WebUI.sleep(1);
        driver.findElement(By.id("address")).sendKeys("Viet Nam");
        driver.findElement(By.id("city")).sendKeys("Can Tho");
        driver.findElement(By.id("state")).sendKeys("Can Tho");
        driver.findElement(By.id("zip")).sendKeys("92000");
        WebUI.sleep(1);
        driver.findElement(By.xpath("//label[@for='country']/following-sibling::div")).click();
        WebUI.sleep(1);
        driver.findElement(By.xpath("//label[@for='country']/following-sibling::div//input[@type='search']")).sendKeys("Vietnam", Keys.ENTER);
        WebUI.sleep(1);
        driver.findElement(By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']")).click();
        WebUI.sleep(1);
        driver.findElement(By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']")).click();
        waitForPageLoaded(driver);
        WebUI.sleep(5);

        String getCustomerNameInDetail = driver.findElement(By.xpath("//input[@id='company']")).getAttribute("Value");
        System.out.println(getCustomerNameInDetail);
        Assert.assertEquals(getCustomerNameInDetail, CUSTOMER_NAME, "Customer name not matched");

        waitForPageLoaded(driver);
        driver.findElement(By.xpath("//span[normalize-space()='Customers']")).click();
        driver.findElement(By.xpath("//input[@class='form-control input-sm']")).sendKeys(CUSTOMER_NAME);
        WebUI.sleep(3);

        String getCustomerNameOnTable = driver.findElement(By.xpath("//tbody/tr[1]/td[3]/a")).getText();
        System.out.println(getCustomerNameOnTable);
        Assert.assertEquals(getCustomerNameOnTable, CUSTOMER_NAME, "Customer name is not found on Table");
        //Kiểm tra Save thành công chuyển hướng đến trang Customer Details
        //driver.findElement(By.xpath("")).click();
        //driver.findElement(By.xpath("")).click();




    }



}
