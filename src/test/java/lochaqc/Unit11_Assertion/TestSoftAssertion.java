package lochaqc.Unit11_Assertion;

import lochaqc.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestSoftAssertion extends BaseTest {
    @Test
    public void testSoftAssert(){
        driver.get("https://rise.fairsketch.com/signin");
        String headerSigninPage = driver.findElement(By.xpath("//h2[normalize-space()='Sign in']")).getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(headerSigninPage, "Sign In", "Header is not the same as designed");

        driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();


        WebElement menuClient = driver.findElement(By.xpath("//span[normalize-space()='Clients']"));

        softAssert.assertTrue(menuClient.isDisplayed(), "Menu Client is not displayed");

        menuClient.click();

        WebElement headerTotalClient = driver.findElement(By.xpath("//span[normalize-space()='Total clients']"));

        softAssert.assertTrue(headerTotalClient.isEnabled(), "Header Total Client is Disabled");
        softAssert.assertEquals(headerTotalClient.getText(), "Selenium", "Mismatched");
        //Final step of softassert is Use assertAll() to validate all assert steps above
        softAssert.assertAll();

    }
}
