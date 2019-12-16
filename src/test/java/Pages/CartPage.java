package Pages;

import Suite.SuiteManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.DriverManager;

public class CartPage extends SuiteManager {

    @FindBy(xpath = "//button[@name = 'checkout']")
    private WebElement checkOut;
    public CartPage(){
        PageFactory.initElements(DriverManager.driver, this);
    }
    @FindBy(linkText = "Ruby on Rails Bag")
    private WebElement productList;

    public String getProductTitle()
    {
        return productList.getText();
    }
    public CheckoutPage checkOut()
    {
        checkOut.click();
        return new CheckoutPage();
    }
}
