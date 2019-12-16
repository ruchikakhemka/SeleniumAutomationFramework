package tests;

import Pages.BasePage;
import Pages.HomePage;
import Pages.LogOutPage;
import Pages.LoginPage;
import Suite.SuiteManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import testdata.loginCredentials;
import util.DriverManager;

import java.util.List;

public class LoginTest extends SuiteManager{

    String login_message = "Logged in successfully";
    BasePage basePage;
    LoginPage loginPage;
    HomePage homePage;
    LogOutPage logOutPage;

    @Test(description = "Login into spree website",dataProvider = "loginCredentials", dataProviderClass = loginCredentials.class)
    public void testLogin(String username, String passwd)
    {
       basePage = new BasePage();

        loginPage = basePage.clickLoginButton();
        //loginPage =  new LoginPage();
        loginPage.sendUserName_Password(username,passwd);
        loginPage.waitForLoginButton();
        homePage=loginPage.clickLoginButton();
        Assert.assertEquals(homePage.getLoginMessage(), login_message);

    }

/*
    @Test(dependsOnMethods = {"testLogin"})
    public void testlogOut()
    {

        //click Logout button
        logOutPage = logOutPage.clicklogOut();

        //Check for successful logout message
        String logout_message = "Signed out successfully.";
        Assert.assertEquals(logOutPage.getLogOutMessage(),logout_message);
    }*/


}
