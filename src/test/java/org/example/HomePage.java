package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private static final String PAGE_URL = "https://www.saucedemo.com/";

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

}
