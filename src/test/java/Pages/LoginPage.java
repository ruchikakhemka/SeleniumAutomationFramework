package Pages;
import Suite.SuiteManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.DriverManager;


public class LoginPage extends SuiteManager {
    public LoginPage(){
        PageFactory.initElements(DriverManager.driver, this );


    }

    @FindBy(id = "spree_user_email")
    private WebElement useremail;

    @FindBy(id = "spree_user_password")
    private WebElement passwd;

    @FindBy(xpath = "//input[@value ='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(text(), 'Logged in successfully')]")
    private WebElement loginMsg;

    public void sendUserName_Password(String username, String password)
    {
        useremail.sendKeys(username);
        passwd.sendKeys(password);
    }
    public HomePage clickLoginButton()
    {

        loginButton.click();
        return new HomePage();
    }

    public String getLoginMessage()
    {
        return loginMsg.getText();
    }

}
