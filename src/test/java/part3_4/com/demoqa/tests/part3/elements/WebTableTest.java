package part3_4.com.demoqa.tests.part3.elements;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3_4.com.demoqa.base.BaseTest;

public class WebTableTest extends BaseTest {

    @Test
    public void testWebTable() {
        var webTablePage = homePage.goToElements().clickWebTables();
        webTablePage.clickEdit("ashfat@example.com");
        webTablePage.setAge("26");
        webTablePage.clickSubmitButton();
        String actualAge = webTablePage.getTableAge("ashfat@example.com");
        String expectedAge = "26";
        Assert.assertEquals(actualAge, expectedAge, "Actual & Accepted Ages Do Not Match");
    }
}
