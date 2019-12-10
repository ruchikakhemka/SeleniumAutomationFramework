package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.DriverManager;

import java.util.concurrent.TimeUnit;

public class TestForgotPassword {
    @Test
    public void testForgotPassword()
    {

        WebElement login_element = null;

        //Click on login
        login_element = DriverManager.driver.findElement(By.linkText("Login"));
        login_element.click();

        //Click on forgot password
        WebElement forgot_password = DriverManager.driver.findElement(By.linkText("Forgot Password?"));
        forgot_password.click();

        //Enter email-id
        WebElement email = DriverManager.driver.findElement(By.xpath("//input[@name = 'spree_user[email]']"));
        email.sendKeys("ruchikaahuja.asm@gmail.com");

        //click Reset password button
        WebElement password_reset = DriverManager.driver.findElement(By.xpath("//input[@value = 'Reset my password']"));
        password_reset.click();

        WebElement reset_msg = DriverManager.driver.findElement(By.xpath("//div[contains(text(), 'You will receive an email with instructions about how to reset your password in a few minutes.')]"));
        Assert.assertTrue(reset_msg.isDisplayed());
    }

}
