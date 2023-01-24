package lochaqc.Unit11_Assertion;

import lochaqc.common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHardAssertion extends BaseTest {
    @Test(priority = 1)
    public void TestAssertEqual() {

        driver.get("https://anhtester.com");

        String expectedTitle = "Anh Tester Automation";
        String actualTitle = driver.getTitle();

        System.out.println("*** Checking For The Title ***");

        Assert.assertEquals(actualTitle, expectedTitle,"Title is incorrect");

        System.out.println("Hello Automation class");
    }

    @Test(priority = 2)
    public void TestAssertTrue() {

        driver.get("https://anhtester.com");

        String expectedTitle = "Anh Developer";
        String actualTitle = driver.getTitle();

        System.out.println("*** Checking For The Title ***");

        Assert.assertTrue(actualTitle.contains(expectedTitle), "Not contain " + expectedTitle);

        System.out.println(actualTitle);
    }
}
