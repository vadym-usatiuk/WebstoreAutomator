package org.example.webstore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebStoreMainPage {

    @FindBy(id = "searchval")
    public WebElement searchBar;

    @FindBy(xpath = "//span[@data-testid='itemDescription']")
    public List<WebElement> searchResult;

    @FindBy(name = "addToCartButton")
    public List<WebElement> addToCart;

    @FindBy(linkText = "Empty Cart")
    public WebElement emptyCartButton;

    public WebStoreMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}