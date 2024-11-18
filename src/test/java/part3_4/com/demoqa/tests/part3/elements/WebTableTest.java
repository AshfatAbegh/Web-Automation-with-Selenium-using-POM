package part3_4.com.demoqa.tests.part3.elements;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3_4.com.demoqa.base.BaseTest;

public class WebTableTest extends BaseTest {

    @Test
    public void testWebTable() {
        String email = "cierra@example.com";
        var webTablePage = homePage.goToElements().clickWebTables();
        webTablePage.clickEdit(email);
        webTablePage.setAge("26");
        webTablePage.clickSubmitButton();
        String actualAge = webTablePage.getTableAge(email);
        String expectedAge = "26";
        Assert.assertEquals(actualAge, expectedAge, "Actual & Accepted Ages Do Not Match");
    }
}
