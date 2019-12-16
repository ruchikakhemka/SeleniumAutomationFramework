package Pages;

import Suite.SuiteManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.DriverManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HomePage extends SuiteManager {
    public HomePage()
    {
        PageFactory.initElements(DriverManager.driver, this);
    }
    @FindBy(xpath = "//input[@name = 'keywords']")
    private WebElement searchInputBox;

    @FindBy(xpath = "//input[@class = 'btn btn-success']")
    private WebElement searchButton;
    private String searchkeyword = getsearchString();

    @FindBy(xpath = "//div[@data-hook = 'products_list_item']")
    private WebElement productList;



    @FindBy(id = "add-to-cart-button")
    private WebElement cart;

    @FindBy(xpath = "//input[@name = 'quantity']")
    private WebElement productQty;

    @FindBy(xpath = "//button[@name = 'checkout']")
    private WebElement checkOut;

    @FindAll(@FindBy(xpath = "//span[@class = 'info mt-3 d-block']"))
    private List<WebElement> productnameList;

    public void enterSearchValue()
    {
        searchInputBox.clear();
        searchInputBox.sendKeys(searchkeyword);
    }
    public void clickSearchButton()
    {

        searchButton.click();
    }
    public List getsearchProductNames()
    {
        List<String> productNames = new ArrayList<String>();
        for (WebElement element: productnameList)
        {
            productNames.add(element.getText());
            //System.out.println(element.getText());
        }
        return productNames;
    }
    public void selectItem()
    {
        productList.click();
    }
    public void enterItemQty()
    {
        productQty.click();
        productQty.clear();
        productQty.sendKeys("2");
    }
    public void addToCart()
    {
        cart.click();
    }


    public String getProductTitle()
    {
        System.out.println(productList.getText());
        return productList.getText();
    }
    public void checkOut()
    {
        checkOut.click();
    }


}
