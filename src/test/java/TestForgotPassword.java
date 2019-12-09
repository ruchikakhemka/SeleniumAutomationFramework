import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestForgotPassword {
    @Test
    public void testForgotPassword()
    {
        WebDriver driver = null;
        String chrome_path = "/Applications/chromedriver";
        System.setProperty("webdriver.chrome.driver",chrome_path);

        driver = new ChromeDriver();
        driver.get("https://spree-vapasi-prod.herokuapp.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement login_element = null;

        //Click on login
        login_element = driver.findElement(By.linkText("Login"));
        login_element.click();

        //Click on forgot password
        WebElement forgot_password = driver.findElement(By.linkText("Forgot Password?"));
        forgot_password.click();

        //Enter email-id
        WebElement email = driver.findElement(By.xpath("//input[@name = 'spree_user[email]']"));
        email.sendKeys("ruchikaahuja.asm@gmail.com");

        //click Reset password button
        WebElement password_reset = driver.findElement(By.xpath("//input[@value = 'Reset my password']"));
        password_reset.click();

        WebElement reset_msg = driver.findElement(By.xpath("//div[contains(text(), 'You will receive an email with instructions about how to reset your password in a few minutes.')]"));
        Assert.assertTrue(reset_msg.isDisplayed());
    }

}
