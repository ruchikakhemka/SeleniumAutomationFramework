package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Error_BlankEmail_ForgotPwd {

    @Test
    public void testError_EmailBlank_ForgotPwd()
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

        //click Reset password button
        WebElement password_reset = driver.findElement(By.xpath("//input[@value = 'Reset my password']"));
        password_reset.click();

        WebElement error_msg = driver.findElement(By.id("errorExplanation"));
        //System.out.println(error_msg.getText());
        Assert.assertTrue(error_msg.isDisplayed());

    }
}
