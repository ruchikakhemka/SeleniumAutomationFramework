package Pages;

import Suite.SuiteManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.DriverManager;

public class CheckoutPage extends SuiteManager {
    public CheckoutPage(){
        PageFactory.initElements(DriverManager.driver, this);
    }
    @FindBy(xpath = "//h1[@class = 'mb-0']")
    private WebElement checkoutTitle;
    public String checkoutPageTitle()
    {
        return checkoutTitle.getText();
    }
}
