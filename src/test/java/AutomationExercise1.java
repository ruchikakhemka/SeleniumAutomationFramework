import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutomationExercise1 {



    public static void main(String[] args){
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

        //Select Create Account
        driver.findElement(By.linkText("Create a new account")).click();
        //Enter Email
        WebElement email = driver.findElement(By.id("spree_user_email"));
        email.sendKeys("testnewuser@gmail.com");

        //Enter Password
        WebElement password = driver.findElement(By.id("spree_user_password"));
        password.sendKeys("abcd1234");

        //Password confirmation field
        driver.findElement(By.id("spree_user_password_confirmation")).sendKeys("abcd1234");
        //Click create account button
        WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
        submit.click();

        //Check for successful signup message
        String signup_message = "Welcome! You have signed up successfully.";
        WebElement signup_msg = driver.findElement(By.xpath("//div[contains(text(), 'Welcome! You have signed up successfully.')]"));
        if(signup_msg.isDisplayed())
            System.out.println("User created successfully");

        // Logout user
        //String signout_message = "Signed out successfully.";
        //WebElement signout = driver.findElement(By.xpath(""));

        //Existing user Login into the website
        /*driver.navigate().refresh();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys("testuser@gmail.com");
        driver.findElement(By.id("spree_user_password")).sendKeys("abcd1234");
        driver.findElement(By.xpath("//input[@type='submit']")).click();*/
        // Find a product.

        //Select Prod


    }


}
