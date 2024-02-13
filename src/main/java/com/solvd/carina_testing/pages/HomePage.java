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

    @FindBy(xpath = "//span[contains(text(), 'Відстежити замовлення')]")
    private ExtendedWebElement trackOrderButton;

    @FindBy(xpath = "(//button[contains(text(), 'Всі акції')])[1]")
    private ExtendedWebElement allPromotionsButton;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(categoriesLine);
    }

    public Header getHeader() {
        return header;
    }

    public PopUpWindowBag addProductToBag(int index){
        productCards.get(index).addProductToBag();
        return popUpWindowBag;
    }

    public boolean isTrackOrderButtonPresent(){
        return trackOrderButton.isElementPresent();
    }
    public TrackOrderPage clickButtonTrackOrder(){
        trackOrderButton.click();
        return new TrackOrderPage(getDriver());
    }

    public AllPromotionsPage clickAllPromotionsButton(){
        allPromotionsButton.click();
        return new AllPromotionsPage(getDriver());
    }

}
