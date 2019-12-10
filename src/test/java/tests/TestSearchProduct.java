package tests;

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
    String login_element = "//div[contains(text(), 'Logged in successfully')]";
    String add_to_cart_element = "add-to-cart-button";
    String add_product_qty = "//input[@name = 'quantity']";
    String product_title = "Ruby on Rails Bag";
    String checkout_button = "//button[@name = 'checkout']";
    String search_input_box = "//input[@name = 'keywords']";
    String search_button = "//input[@class = 'btn btn-success']";


    @Test(description = "Search Product")
    public void testSearchProduct(){
        //Click Search input box and enter search keyword
        WebElement searchBox = DriverManager.driver.findElement(By.xpath(search_input_box));
        searchBox.sendKeys("Bag");

        //Click search button
        WebElement search_btn = DriverManager.driver.findElement(By.xpath(search_button));
        search_btn.click();

        //Check no of items matchig bag keyword
        List<WebElement> bag_items = DriverManager.driver.findElements(By.xpath("//span[@class = 'info mt-3 d-block' ]"));
        Assert.assertEquals(bag_items.size(), 2);

        //Now select the first item.
        bag_items.get(0).click();

        //In product descritpion page select
        //input quantity
        WebElement quantity_input = DriverManager.driver.findElement(By.xpath(add_product_qty));
        quantity_input.clear();
        quantity_input.sendKeys("2");

        //click Add to cart
        WebElement addToCart = DriverManager.driver.findElement(By.id(add_to_cart_element));
        addToCart.click();

        //check that the added items are there in the cart
        //String product_title = "Ruby on Rails Bag";
        WebElement product = DriverManager.driver.findElement(By.linkText(product_title));
        Assert.assertTrue(product.isDisplayed());

        //Assert the item quantity in checkput page
        String value = DriverManager.driver.findElement(By.xpath("//input[@id = 'order_line_items_attributes_1_quantity']")).getAttribute("value");
        Assert.assertEquals(value,"2");
        //do checkout
        DriverManager.driver.findElement(By.xpath(checkout_button)).click();
    }

}
