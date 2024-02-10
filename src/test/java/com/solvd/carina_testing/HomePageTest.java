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
    @Test(testName = "verify search line test")
    public void verifySearchLineTest() {
        String productName = "шампунь";
        SoftAssert sa =  new SoftAssert();
        HomePage homePage = new HomePage(getDriver());

        homePage.open();
        Assert.assertTrue(homePage.isPageOpened());

        SearchLineComponent searchLineComponent =  homePage.getHeader().getSearchLineComponent();
        Assert.assertTrue(searchLineComponent.getSearchButton().isElementPresent(2), "search button is not present");
        Assert.assertTrue(searchLineComponent.getSearchInput().isElementPresent(2),"Search input is not present");
        sa.assertEquals(searchLineComponent.getSearchInputPlaceholder(), "Введіть пошуковий запит або код товару",
                            "Search input has incorrect placeholder");
        searchLineComponent.typeSearchInputValue(productName);
        SearchPage searchPage = searchLineComponent.clickSearchButton();
        Assert.assertTrue(searchPage.isPageOpened());

        List<ProductCard> cards = searchPage.getCards();
        for(ProductCard card: cards){
            sa.assertTrue(card.getDescriptionText().contains(productName.toLowerCase()),
                    String.format("Product with name '%s' does not contain product name in his description", card.getDescriptionText()));
        }

        sa.assertAll();
    }

    @Test(testName = "verify search products by brand")
    public void verifySearchByBrandTest(){
        String brandName = "Gerber";
        SoftAssert sa = new SoftAssert();
        HomePage homePage =  new HomePage(getDriver());

        homePage.open();
        Assert.assertTrue(homePage.isPageOpened());

        PropositionLine propositionLine =  homePage.getHeader().getPropositionLine();
        Assert.assertTrue(propositionLine.getBrands().isElementPresent(),"brands are not present on the proposition line");
        PopUpWindowBrands popUpWindowBrands  = propositionLine.clickBrands();
        Assert.assertFalse(popUpWindowBrands.getBrandTitles().isEmpty(),"popup window with brands is not present");
        SearchPage searchPage = popUpWindowBrands.clickBrandTitle(brandName);
        Assert.assertTrue(searchPage.isPageOpened());

        List<ProductCard> cards =  searchPage.getCards();
        for(ProductCard card: cards){
            sa.assertTrue(card.getTitleText().contains(brandName),
                    String.format("Product with description '%s' does not contain brand name in his title", card.getDescriptionText()));
        }
        sa.assertAll();
    }

    @Test(testName = "verify adding product to the bag and creating order")
    public void verifyAddProductToTheBagAndCreateOrder(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened());

        PopUpWindowBag popUpWindowBag = homePage.addProductToBag(5);
        Assert.assertTrue(popUpWindowBag.getButtonCreateOrder().isElementPresent());
        CheckoutPage checkoutPage = popUpWindowBag.createOrder();
        Assert.assertTrue(checkoutPage.isPageOpened());
    }
}
