import Suite.SuiteManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import testdata.loginCredentials;
import util.DriverManager;

import java.util.List;

public class LoginTest extends SuiteManager{

    String login_message = "Logged in successfully";

    @Test(description = "Login into spree website",dataProvider = "loginCredentials", dataProviderClass = loginCredentials.class)
    public void testLogin(String username, String passwd)
    {
        /*WebElement login = DriverManager.driver.findElement(By.linkText("Login"));
        login.click();
        WebElement uname = DriverManager.driver.findElement(By.xpath("//input[@name = 'spree_user[email]']"));
        uname.sendKeys(username);
        WebElement  password = DriverManager.driver.findElement(By.id("spree_user_password"));
        password.sendKeys(passwd);
        //Click Login submit button
        WebElement submit = DriverManager.driver.findElement(By.xpath("//input[@value ='Login']"));
        submit.click();*/
        login(username,passwd);
        WebElement login_msg = DriverManager.driver.findElement(By.xpath("//div[contains(text(), 'Logged in successfully')]"));
        Assert.assertEquals(login_msg.getText(), login_message);

    }


    @Test(dependsOnMethods = {"testLogin"})
    public void testlogOut()
    {
        //click Logout button
        WebElement logout = DriverManager.driver.findElement(By.xpath("//a[text() ='Logout']"));
        logout.click();
        //Check for successful logout message
        String logout_message = "Signed out successfully.";
        WebElement logout_msg = DriverManager.driver.findElement(By.xpath("//div[contains(text(), 'Signed out successfully.')]"));
        Assert.assertEquals(logout_msg.getText(),logout_message);
    }


}
