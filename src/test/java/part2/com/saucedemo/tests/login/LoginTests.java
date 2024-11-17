package part2.com.saucedemo.tests.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import part2.com.saucedemo.base.BaseTest;

public class LoginTests extends BaseTest {

    @Test
    public void testLoginErrorMessage(){
          loginPage.logIntoApplication("standard_user", "456897");
//        loginPage.setUsername("standard_user");
//        loginPage.setPassword("456897");
//        loginPage.clickLoginButton();

        String actualMessage = loginPage.getErrorMessage();
        Assert.assertTrue(actualMessage.contains("Epic sadface"));
    }
}
