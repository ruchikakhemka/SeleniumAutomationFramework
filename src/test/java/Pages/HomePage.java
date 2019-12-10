package Pages;

import Suite.SuiteManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.DriverManager;

public class HomePage extends SuiteManager {
    public HomePage()
    {
        PageFactory.initElements(DriverManager.driver, this);
    }
    @FindBy(xpath = "//input[@name = 'keywords']")
    private WebElement searchInputBox;

    @FindBy(xpath = "//input[@class = 'btn btn-success']")
    private WebElement searchButton;
    private String searchkeyword = "Bags";



    public void enterSearchValue()
    {
        searchInputBox.clear();
        searchInputBox.sendKeys(searchkeyword);
    }
    public void clickSearchButton()
    {
        searchButton.click();
    }


}
