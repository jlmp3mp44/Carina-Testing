package com.solvd.carina_testing.pages;

import com.solvd.carina_testing.components.Header;
import com.solvd.carina_testing.components.PopUpWindowBag;
import com.solvd.carina_testing.components.ProductCard;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//header")
    private Header header;

    @FindBy(xpath = "//body//div[contains(@class, 'category-list')]")
    private ExtendedWebElement categoriesLine;

    @FindBy(xpath = "//*[@class='product__details']")
    private List<ProductCard> productCards;

    @FindBy(xpath = "//*[@class='m-modal-microcart-list']")
    private PopUpWindowBag popUpWindowBag;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(categoriesLine);
    }

    public Header getHeader() {
        return header;
    }

    public boolean isCategoriesLinePresent() {
        return categoriesLine.isElementPresent();
    }

    public PopUpWindowBag addProductToBag(int index){
        ProductCard productCard = productCards.get(index);
        productCard.addProductToBag();
        return popUpWindowBag;
    }

    public List<ProductCard> getProductCards() {
        return productCards;
    }

    public PopUpWindowBag getPopUpWindowBag() {
        return popUpWindowBag;
    }
}
