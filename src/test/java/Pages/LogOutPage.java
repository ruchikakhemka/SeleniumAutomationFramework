package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.DriverManager;

public class LogOutPage {


    public LogOutPage()
    {
        PageFactory.initElements(DriverManager.driver, this );
    }
    @FindBy(xpath = "//a[text() ='Logout']")
    private WebElement logoutButton;

    @FindBy(xpath = "//div[contains(text(), 'Signed out successfully.')]")
    private WebElement logoutMsg;

    public LogOutPage clicklogOut()
    {
        logoutButton.click();
       return new LogOutPage();
    }
    public String getLogOutMessage()
    {
        return logoutMsg.getText();
    }

}
