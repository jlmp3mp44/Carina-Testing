package com.solvd.carina_testing;

import com.solvd.carina_testing.components.ProductCard;
import com.solvd.carina_testing.components.SearchLineComponent;
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
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);

        homePage.open();

        SearchLineComponent searchLineComponent =  homePage.getHeader().getSearchLineComponent();
        Assert.assertTrue(searchLineComponent.getSearchButton().isElementPresent(2), "search button is not present");
        Assert.assertTrue(searchLineComponent.getSearchInput().isElementPresent(2),"Search input is not present");
        sa.assertEquals(searchLineComponent.getSearchInputPlaceholder(), "Введіть пошуковий запит або код товару",
                            "Search input has incorrect placeholder");
        searchLineComponent.typeSearchInputValue(productName);
        SearchPage searchPage = searchLineComponent.clickSearchButton();

        List<ProductCard> cards = searchPage.getCards();
        for(ProductCard card: cards){
            sa.assertTrue(card.getDescriptionText().contains(productName.toLowerCase()),
                    String.format("Product with name '%s' does not contain product name in his description", card.getDescriptionText()));
        }

        sa.assertAll();
    }
}
