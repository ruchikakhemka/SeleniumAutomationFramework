package Pages;

import Suite.SuiteManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.DriverManager;

public class BasePage extends SuiteManager {
    public BasePage(){
        PageFactory.initElements(DriverManager.driver, this );
    }

    @FindBy(linkText = "Login")
    private WebElement loginButton;

    public LoginPage clickLoginButton()
    {
        loginButton.click();
        return new LoginPage();
    }
}
