import Suite.SuiteManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import testdata.loginCredentials;
import util.DriverManager;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestSearchProduct extends SuiteManager {

    String login_message = "Logged in successfully";

    @Test(description = "Login into spree website",dataProvider = "loginCredentials", dataProviderClass = loginCredentials.class)
    public void testLoginUser(String username, String passwd)
    {
        login(username,passwd);
        WebElement login_msg = DriverManager.driver.findElement(By.xpath("//div[contains(text(), 'Logged in successfully')]"));
        Assert.assertEquals(login_msg.getText(), login_message);

    }
    @Test(description = "Search Product")
    public void testSearchProduct(){
        //Click Search input box and enter search keyword
        WebElement searchBox = DriverManager.driver.findElement(By.xpath("//input[@name = 'keywords']"));
        searchBox.sendKeys("Bag");

        //Click search button
        WebElement search_button = DriverManager.driver.findElement(By.xpath("//input[@class = 'btn btn-success']"));
        search_button.click();

        //Check no of items matchig bag keyword
        List<WebElement> bag_items = DriverManager.driver.findElements(By.xpath("//span[@class = 'info mt-3 d-block' ]"));
        Assert.assertEquals(bag_items.size(), 2);

        //Now select the first item.
        bag_items.get(0).click();

        //In product descritpion page select
        //input quantity
        WebElement quantity_input = DriverManager.driver.findElement(By.xpath("//input[@name = 'quantity']"));
        quantity_input.clear();
        quantity_input.sendKeys("2");

        //click Add to cart
        WebElement addToCart = DriverManager.driver.findElement(By.id("add-to-cart-button"));
        addToCart.click();

        //check that the added items are there in the cart
        //String product_title = "Ruby on Rails Bag";
        WebElement product = DriverManager.driver.findElement(By.linkText("Ruby on Rails Bag"));
        Assert.assertTrue(product.isDisplayed());

        //Assert the item quantity in checkput page
        String value = DriverManager.driver.findElement(By.xpath("//input[@id = 'order_line_items_attributes_1_quantity']")).getAttribute("value");
        Assert.assertEquals(value,"2");
        //do checkout
        DriverManager.driver.findElement(By.xpath("//button[@name = 'checkout']")).click();
    }

}
