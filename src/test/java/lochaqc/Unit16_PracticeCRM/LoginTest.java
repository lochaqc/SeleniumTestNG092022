package lochaqc.Unit16_PracticeCRM;

import keyword.WebUI;
import lochaqc.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends BaseTest {
    @Test
    public void loginWithoutEmailAndPassword(){
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Verify Requirement for inputting email and pw messages
        //Verify these messages are the same as design

        SoftAssert softAssert = new SoftAssert();

        //Verify that Element exists in DOM
        boolean emailRequired = WebUI.checkElementExist(driver, "//form/div[1]"); //message for email required
        boolean pwRequired = WebUI.checkElementExist(driver, "//form/div[2]"); //message for pw required
        System.out.println(emailRequired);
        System.out.println(pwRequired);

        softAssert.assertTrue(WebUI.checkElementExist(driver, "//form/div[1]"), "Email required not exist");
        softAssert.assertTrue(WebUI.checkElementExist(driver, "//form/div[2]"), "Pw required not sxist");

        //Check element is visible on UI
        boolean msgEmailVisible = driver.findElement(By.xpath("//form/div[1]")).isEnabled(); //message for email required
        boolean msgPwRequired = driver.findElement(By.xpath("//form/div[2]")).isEnabled(); //message for pw required
        System.out.println(emailRequired);
        System.out.println(pwRequired);

        softAssert.assertTrue(msgEmailVisible, "Message email is not enable on UI");
        softAssert.assertTrue(msgPwRequired, "Message Password is not enable on UI");

        //Verify text content on element
        String textForMsgEmailRequired = driver.findElement(By.xpath("//form/div[1]")).getText(); //message content for email required
        String textForMsgPwRequired = driver.findElement(By.xpath("//form/div[2]")).getText(); //message content for pw required
        System.out.println(textForMsgEmailRequired);
        System.out.println(pwRequired);

        softAssert.assertEquals(textForMsgEmailRequired, "The Password field is required.", "Password not matched");
        softAssert.assertEquals(textForMsgPwRequired, "The Email Address field is required.", "Email not matched");

        softAssert.assertAll();


        WebUI.sleep(2);

    }
}
