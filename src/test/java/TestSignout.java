import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestSignout {
    @Test
    public void testLogout()
    {
        WebDriver driver = null;
        String chrome_path = "/Applications/chromedriver";
        System.setProperty("webdriver.chrome.driver",chrome_path);
        //


        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.get("https://spree-vapasi-prod.herokuapp.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement login_element = null;
        //Click on login
        login_element = driver.findElement(By.linkText("Login"));
        login_element.click();
        //Enter Email
        WebElement email = driver.findElement(By.xpath("//input[@name = 'spree_user[email]']"));
        email.sendKeys("ruchikaahuja.asm@gmail.com");

        //Enter Password
        WebElement password = driver.findElement(By.id("spree_user_password"));
        password.sendKeys("abcd1234");

        //Click Login submit button
        WebElement submit = driver.findElement(By.xpath("//input[@value ='Login']"));
        submit.click();

        //click Logout button
        WebElement logout = driver.findElement(By.xpath("//a[text() ='Logout']"));
        logout.click();
        //Check for successful login message
        String logout_message = "Signed out successfully.";
        WebElement logout_msg = driver.findElement(By.xpath("//div[contains(text(), 'Signed out successfully.')]"));
        Assert.assertEquals(logout_msg.getText(),logout_message);
    }
}
