package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private static final String PAGE_URL = "https://www.saucedemo.com/";

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // ===================================== Common methods =====================================
    public void fillField(By locator, String value) {
        getField(locator).sendKeys(value);
    }

    public void openPage() {
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public WebElement getField(By locator) {
        return driver.findElement(locator);
    }


    // ===================================== Login Locators =====================================

    public static final By USERNAME = By.id("user-name");
    public static final By PASSWORD = By.id("password");

    // ===================================== Login Elements =====================================
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
    private WebElement loginErrorMessage;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    private WebElement loginSuccessMessage;


    // ===================================== Login form methods =====================================

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getLoginErrorMessage() {
        return loginErrorMessage.getText();
    }

    public String getLoginSuccessMessage() {
        return loginSuccessMessage.getText();
    }

    // ===================================== Sort Elements =====================================

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[1]")
    private WebElement sortAtoZ;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[2]")
    private WebElement sortZtoA;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]")
    private WebElement sortLowToHigh;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[4]")
    private WebElement sortHighToLow;

    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[1]/a/div")
    private WebElement firstProductName;

    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div")
    private WebElement firstProductPrice;


    // ===================================== Sort form methods =====================================

    public void clickSortAtoZOption() {
        sortAtoZ.click();
    }
    public void clickSortZtoAOption() {
        sortZtoA.click();
    }
    public void clickSortLowToHighOption() {
        sortLowToHigh.click();
    }
    public void clickSortHighToLowOption() {
        sortHighToLow.click();
    }


    public String getFirstProductName() {
        return firstProductName.getText();
    }

    public String getFirstProductPrice() {
        return firstProductPrice.getText();
    }






    // ===================================== Shoping cart elements =====================================

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartLink;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addBackpackToCartButton;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement addSauceLabsBikeLightToCartButton;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement addSauceLAbsBoltTShirtToCartButton;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    private WebElement addSauceLabsFleeceJacketToCartButton;

    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    private WebElement addSauceLabsOnesieToCartButton;

    @FindBy(css = "#cart_contents_container > div > div.cart_list > div:last-child > div.cart_item_label > a > div")

    private WebElement lastItemInCart;
    // ===================================== Sort form methods =====================================
    public void addBackPackToCart() {
        addBackpackToCartButton.click();
    }

    public void addBikeLightToCart() {
        addSauceLabsBikeLightToCartButton.click();
    }

    public void addTShirtToCart() {
        addSauceLAbsBoltTShirtToCartButton.click();
    }

    public void addFleeceToCart() {
        addSauceLabsFleeceJacketToCartButton.click();
    }

    public void addOnesieToCart() {
        addSauceLabsOnesieToCartButton.click();
    }
    public void clickOnCart() {
        shoppingCartLink.click();
    }

    public String getLastItemInCartName() {
        return lastItemInCart.getText();
    }

}
