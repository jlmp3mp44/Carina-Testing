package com.solvd.carina_testing;

import com.solvd.carina_testing.components.*;
import com.solvd.carina_testing.pages.CheckoutPage;
import com.solvd.carina_testing.pages.HomePage;
import com.solvd.carina_testing.pages.SearchPage;
import com.zebrunner.carina.core.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class HomePageTest extends AbstractTest {
    String productName = "Шампунь";
    String brandName = "Gerber";

    @Test(testName = "Verify search line test")
    public void verifySearchLineTest() {
        SoftAssert softAssert =  new SoftAssert();
        HomePage homePage = new HomePage(getDriver());

        homePage.open();
        Assert.assertTrue(homePage.isPageOpened());

        Header header = homePage.getHeader();

        Assert.assertTrue(header.isSearchButtonPresent(), "Search button is not present");
        Assert.assertTrue(header.isSearchInputPresent(),"Search input is not present");
        softAssert.assertEquals(header.getSearchInputPlaceholder(), "Введіть пошуковий запит або код товару",
                            "Search input has incorrect placeholder");
        header.typeSearchInputValue(productName);
        SearchPage searchPage = header.clickSearchButton();
        Assert.assertTrue(searchPage.isPageOpened());

        List<ProductCard> cards = searchPage.getCards();
        for(ProductCard card: cards){
            softAssert.assertTrue(card.getDescriptionText().contains(productName.toLowerCase()),
                    String.format("Product with name '%s' does not contain product name in his description", card.getDescriptionText()));
        }

        softAssert.assertAll();
    }

    @Test(testName = "Verify search products by brand")
    public void verifySearchByBrandTest(){
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage =  new HomePage(getDriver());

        homePage.open();
        Assert.assertTrue(homePage.isPageOpened());


        Header header = homePage.getHeader();
        Assert.assertTrue(header.isBrandsPresent(),"Brands are not present on the proposition line");
        PopUpWindowBrands popUpWindowBrands  = header.clickBrands();
        SearchPage searchPage = popUpWindowBrands.clickBrandTitle(brandName);
        Assert.assertTrue(searchPage.isPageOpened());

        List<ProductCard> cards =  searchPage.getCards();
        for(ProductCard card: cards){
            softAssert.assertTrue(card.getTitleText().contains(brandName),
                    String.format("Product with description '%s' does not contain brand name in his title", card.getDescriptionText()));
        }
        softAssert.assertAll();
    }

    @Test(testName = "Verify adding product to the bag and creating order")
    public void verifyAddProductToTheBagAndCreateOrder(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened());

        PopUpWindowBag popUpWindowBag = homePage.addProductToBag(5);
        Assert.assertTrue(popUpWindowBag.isCreateOrderButtonPresent());
        CheckoutPage checkoutPage = popUpWindowBag.createOrder();
        Assert.assertTrue(checkoutPage.isPageOpened());
    }
}
