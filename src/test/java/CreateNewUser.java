import Suite.SuiteManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import testdata.loginCredentials;
import util.DriverManager;

public class CreateNewUser extends SuiteManager {

    @Test(description = "Creating new user", dataProvider = "loginCredentials", dataProviderClass = loginCredentials.class)
    public void testCreateUser(String uname, String passwd)
    {
        WebElement login = DriverManager.driver.findElement(By.linkText("Login"));
        login.click();

        //Select Create Account
        DriverManager.driver.findElement(By.linkText("Create a new account")).click();
        //Enter Email
        WebElement email = DriverManager.driver.findElement(By.id("spree_user_email"));
        email.sendKeys(uname);

        //Enter Password
        WebElement password = DriverManager.driver.findElement(By.id("spree_user_password"));
        password.sendKeys(passwd);

        //Password confirmation field
        DriverManager.driver.findElement(By.id("spree_user_password_confirmation")).sendKeys("abcd1234");
        //Click create account button
        WebElement submit = DriverManager.driver.findElement(By.xpath("//input[@type='submit']"));
        submit.click();

        //Check for successful signup message
        String signup_message = "Welcome! You have signed up successfully.";
        WebElement signup_msg = DriverManager.driver.findElement(By.xpath("//div[contains(text(), 'Welcome! You have signed up successfully.')]"));
        Assert.assertEquals(signup_msg.getText(),signup_message);
    }
}
