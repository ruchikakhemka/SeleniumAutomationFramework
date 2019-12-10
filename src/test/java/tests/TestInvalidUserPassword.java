package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestInvalidUserPassword {
    @Test
    public void testInvalidUser(){
        // Initializing chrome driver
        WebDriver driver = null;
        String chrome_path = "/Applications/chromedriver";
        System.setProperty("webdriver.chrome.driver",chrome_path);
        //
        driver = new ChromeDriver();
        driver.get("https://spree-vapasi-prod.herokuapp.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement login_element = null;
        //Click on login
        login_element = driver.findElement(By.linkText("Login"));
        login_element.click();

        //Enter Invalid Email
        //Enter Email
        WebElement email = driver.findElement(By.id("spree_user_email"));
        email.sendKeys("invaliduser@gmail.com");

        //Enter Invalid Password
        WebElement password = driver.findElement(By.id("spree_user_password"));
        password.sendKeys("12345678");

        //WebElement submit = driver.findElement(By.xpath("//input[@value ='Login']"));
        WebElement submit = driver.findElement(By.xpath("//input[@value ='Login']"));
        submit.click();
        String inavlid_login = "Invalid email or password.";
        WebElement invalid_msg = driver.findElement(By.xpath("//div[contains(text(), 'Invalid email or password.')]"));
        Assert.assertEquals(invalid_msg.getText(),inavlid_login);

    }

}
