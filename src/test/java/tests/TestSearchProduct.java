package tests;

import Pages.HomePage;
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


    String product_title = "Ruby on Rails Bag";

    HomePage homepage;

    @Test(description = "Search Product")
    public void testSearchProduct(){
        //Click Search input box and enter search keyword

        homepage = new HomePage();
        //Enter search keyword
        homepage.enterSearchValue();
        //click search button
        homepage.clickSearchButton();

        //Check no of items matchig bag keyword
        //List<WebElement> bag_items = DriverManager.driver.findElements(By.xpath("//span[@class = 'info mt-3 d-block' ]"));
        //Assert.assertEquals(bag_items.size(), 2);

        //Now select the first item.
        homepage.selectItem();

        //In product descritpion page select
        //input quantity
        homepage.enterItemQty();

        //click Add to cart
        homepage.addToCart();

        //check that the added items are there in the cart
        //String product_title = "Ruby on Rails Bag";
        Assert.assertEquals(homepage.getProductTitle(), product_title);

        //do checkout
        homepage.checkOut();
    }

}
