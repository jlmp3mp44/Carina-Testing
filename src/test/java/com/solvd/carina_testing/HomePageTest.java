package com.solvd.carina_testing;

import com.solvd.carina_testing.components.*;
import com.solvd.carina_testing.pages.*;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class HomePageTest extends AbstractTest {
    private static final String PRODUCT_TITLE = "Шампунь";
    private static final String BRAND_TITLE = "Lancome";
    private static final String ORDER_NUMBER = "21000";
    private static final String PROMOTION_TITLE = "Товари дня";

    @Test(testName = "Verify search line test")
    public void verifySearchLineTest() {
        SoftAssert softAssert =  new SoftAssert();
        HomePage homePage = new HomePage(getDriver());

        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn`t open!");

        Header header = homePage.getHeader();

        Assert.assertTrue(header.isSearchButtonPresent(), "Search button is not present!");
        Assert.assertTrue(header.isSearchInputPresent(),"Search input is not present!");
        softAssert.assertEquals(header.getSearchInputPlaceholder(), "Введіть пошуковий запит або код товару",
                            "Search input has incorrect placeholder!");
        header.typeSearchInputValue(PRODUCT_TITLE);
        SearchPage searchPage = header.clickSearchButton();
        Assert.assertTrue(searchPage.isPageOpened(), "Search page isn`t open!");

        List<ProductCard> cards = searchPage.getCards();
        for(ProductCard card: cards){
            softAssert.assertTrue(card.getDescriptionText().contains(PRODUCT_TITLE.toLowerCase()),
                    String.format("Product with description '%s' does not contain product name in his description", card.getDescriptionText()));
        }

        softAssert.assertAll();
    }

    @Test(testName = "Verify search products by brand")
    public void verifySearchByBrandTest(){
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage =  new HomePage(getDriver());

        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn`t open!");


        Header header = homePage.getHeader();
        Assert.assertTrue(header.isBrandButtonPresent(),"Brands are not present on the proposition line!");
        DropDownMenuBrands popUpWindowBrands  = header.clickBrands();
        SearchPage searchPage = popUpWindowBrands.clickBrandTitle(BRAND_TITLE);
        Assert.assertTrue(searchPage.isPageOpened(), "Search page isn`t open!");

        List<ProductCard> cards =  searchPage.getCards();
        for(ProductCard card: cards){
            softAssert.assertTrue(card.getTitleText().contains(BRAND_TITLE),
                    String.format("Product with description '%s' does not contain brand name in his title", card.getDescriptionText()));
        }
        softAssert.assertAll();
    }

    @Test(testName = "Verify adding product to the bag and creating order")
    public void verifyAddProductToTheBagAndCreateOrder(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn`t open!");

        PopUpWindowBag popUpWindowBag = homePage.addProductToBag(5);
        Assert.assertTrue(popUpWindowBag.isCreateOrderButtonPresent(), "Create order button isn`t present!");

        CheckoutPage checkoutPage = popUpWindowBag.createOrder();
        Assert.assertTrue(checkoutPage.isPageOpened(), "Checkout page isn`t open!");
    }

    @Test
    public void verifyCheckOrder(){
        HomePage homePage =  new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn`t open!");

        Assert.assertTrue(homePage.isTrackOrderButtonPresent(),"Track order button on the home page isn`t present!");
        TrackOrderPage trackOrderPage = homePage.clickButtonTrackOrder();
        Assert.assertTrue(trackOrderPage.isPageOpened(), "Track page isn`t open!");
        Assert.assertTrue(trackOrderPage.isInputOrderNumberlinePresent(), "input order number line isn`t present!");

        trackOrderPage.typeInputOrderNumber(ORDER_NUMBER);

        Assert.assertTrue(trackOrderPage.isTrackOrderButtonPresent(),
                "Track order button on the track order page isn`t present!");
        trackOrderPage.clickTrackOrderButton();

        Assert.assertTrue(trackOrderPage.isOrderDidntFoundTitlePresent(), "The title 'Order didn`t found' isn`t present!");
    }

    @Test
    public void verifyOpenPagePromotion(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn`t open!");

        AllPromotionsPage allPromotionsPage = homePage.clickAllPromotionsButton();
        Assert.assertTrue(allPromotionsPage.isPageOpened(), "All promotion page isn`t open!");

        PromotionPage promotionPage = allPromotionsPage.clickOnThePromotion(PROMOTION_TITLE);
        Assert.assertTrue(promotionPage.isPageOpened(), "Promotion page isn`t open");
    }


}
