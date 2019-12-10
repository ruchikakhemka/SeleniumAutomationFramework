import Suite.SuiteManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import util.DriverManager;

public class LoginTest extends SuiteManager{

    private String username = "ruchikaahuja.asm@gmail.com";
    private String pwd = "abcd1234";
    @Test
    public void LoginTest()
    {
        WebElement login = DriverManager.driver.findElement(By.linkText("Login"));
        login.click();
        WebElement uname = DriverManager.driver.findElement(By.xpath("//input[@name = 'spree_user[email]']"));
        uname.sendKeys(username);
        WebElement  password = DriverManager.driver.findElement(By.id("spree_user_password"));
        password.sendKeys(pwd);
        //Click Login submit button
        WebElement submit = DriverManager.driver.findElement(By.xpath("//input[@value ='Login']"));
        submit.click();

    }


}
