package Suite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import util.ConfigFileReader;
import util.DriverManager;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class SuiteManager {
    DriverManager driverManager;
    private static ConfigFileReader configFileReader = new ConfigFileReader();
    private static String username;
    private static String passwd;
    @BeforeSuite(alwaysRun = true )
    public void startDriver()throws MalformedURLException
    {
        driverManager = new DriverManager();
    }

    @AfterSuite(alwaysRun = true)
    public void closeDriver()
    {
        DriverManager.driver.quit();
    }

    @BeforeClass
    public void launchUrl()
    {
        DriverManager.driver.manage().window().maximize();
        String baseurl = configFileReader.getProperty("baseurl");

        DriverManager.driver.get(baseurl);
    }
    @BeforeTest
    public void setLoginCredentials()
    {
        username = configFileReader.getProperty("username");
        passwd = configFileReader.getProperty("pswd");

    }

    public void login(String uname, String passwd)
    {
        WebElement login = DriverManager.driver.findElement(By.linkText("Login"));
        login.click();
        WebElement username = DriverManager.driver.findElement(By.xpath("//input[@name = 'spree_user[email]']"));
        username.sendKeys(uname);
        WebElement  password = DriverManager.driver.findElement(By.id("spree_user_password"));
        password.sendKeys(passwd);
        //Click Login submit button
        WebElement submit = DriverManager.driver.findElement(By.xpath("//input[@value ='Login']"));
        submit.click();

    }

}
