package tests;

import Pages.HomePage;
import Suite.SuiteManager;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestSearchProduct extends SuiteManager {


    String product_title = "Ruby on Rails Bag";
    List<String> productnames = new ArrayList<String>();
    HomePage homepage;
    List<String> searchStrings = new ArrayList<String>();
    boolean contains_string = false;
    @Test(description = "Search Product")
    public void testSearchProduct(){
        //Click Search input box and enter search keyword

        homepage = new HomePage();
        //Enter search keyword
        homepage.enterSearchValue();
        //click search button
        homepage.clickSearchButton();

        //Get product name list
        productnames = homepage.getsearchProductNames();
        //Check whether the product name contains the search keyword
        String[] keywords = getsearchString().split(" ");
        keywords[0].toLowerCase();
        keywords[1].toLowerCase();
        for(String name:productnames){
            /*if(s.contains(keywords[0])|| s.contains(keywords[1]))
                contains_string = true;
            else
                contains_string = false;*/

            Assert.assertTrue(name.toLowerCase().contains(keywords[0]) || name.toLowerCase().contains(keywords[1]));

        }




        //Now select the first item.
        homepage.selectItem();

        //In product descritpion page select
        //input quantity
        homepage.enterItemQty();

        //click Add to cart
        homepage.addToCart();

        //check that the added items are there in the cart
        Assert.assertEquals(homepage.getProductTitle(), product_title);

        //do checkout
        homepage.checkOut();
    }

}
