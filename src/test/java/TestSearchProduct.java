import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestSearchProduct {

    @Test
    public void testSearchProduct()
    {
        WebDriver driver = null;
        String chrome_path = "/Applications/chromedriver";
        System.setProperty("webdriver.chrome.driver",chrome_path);

        driver = new ChromeDriver();
        driver.get("https://spree-vapasi-prod.herokuapp.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement login_element = null;

        //Click on login
        login_element = driver.findElement(By.linkText("Login"));
        login_element.click();

        //Enter Email
        WebElement email = driver.findElement(By.xpath("//input[@name = 'spree_user[email]']"));
        email.sendKeys("ruchikaahuja.asm@gmail.com");

        //Enter Password
        WebElement password = driver.findElement(By.id("spree_user_password"));
        password.sendKeys("abcd1234");

        //Click Login submit button
        WebElement submit = driver.findElement(By.xpath("//input[@value ='Login']"));
        submit.click();

        //Click Search input box and enter search keyword
        WebElement searchBox = driver.findElement(By.xpath("//input[@name = 'keywords']"));
        searchBox.sendKeys("Bag");

        //Click search button
        WebElement search_button = driver.findElement(By.xpath("//input[@class = 'btn btn-success']"));
        search_button.click();

        //Check no of items matchig bag keyword
        List<WebElement> bag_items = driver.findElements(By.xpath("//span[@class = 'info mt-3 d-block' ]"));
        Assert.assertEquals(bag_items.size(), 2);

        //Now select the first item.
        bag_items.get(0).click();

        //In product descritpion page select
        //input quantity
        WebElement quantity_input = driver.findElement(By.xpath("//input[@name = 'quantity']"));
        quantity_input.clear();
        quantity_input.sendKeys("2");

        //click Add to cart
        WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
        addToCart.click();

        //check that the added items are there in the cart
        //String product_title = "Ruby on Rails Bag";
        WebElement product = driver.findElement(By.linkText("Ruby on Rails Bag"));
        Assert.assertTrue(product.isDisplayed());

        //Checkout the cart

    }
}
