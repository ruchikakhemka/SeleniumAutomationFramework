package Pages;
import Suite.SuiteManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    @FindBy(xpath = "//a[text() ='Logout']")
    private WebElement logoutButton;

    public void sendUserName_Password(String username, String password)
    {
        useremail.sendKeys(username);
        passwd.sendKeys(password);
    }
    public void waitForLoginButton()
    {
        WebDriverWait wait=new WebDriverWait(DriverManager.driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));

    }
    public HomePage clickLoginButton()
    {

        loginButton.click();
        return new HomePage();
    }
    public LogOutPage clicklogOut()
    {
        logoutButton.click();
        return new LogOutPage();
    }


}
