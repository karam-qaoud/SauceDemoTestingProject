package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private static final String PAGE_URL = "https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC";

    // ===================================== Login Locators =====================================

    public static final By USERNAME = By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input");
    public static final By PASSWORD = By.xpath("//*[@id=\"loginPanel\"]/form/div[2]/input");

    // ===================================== Register Locators =====================================
    public static final By FIRSTNAME = By.id("customer.firstName");
    public static final By LASTNAME = By.id("customer.lastName");
    public static final By ADDRESS = By.id("customer.address.street");
    public static final By CITY = By.id("customer.address.city");
    public static final By STATE = By.id("customer.address.state");
    public static final By ZIPCODE = By.id("customer.address.zipCode");
    public static final By PHONE_NUMBER = By.id("customer.phoneNumber");
    public static final By SSN = By.id("customer.ssn");
    public static final By REGISTER_USERNAME = By.id("customer.username");
    public static final By REGISTER_PASSWORD = By.id("customer.password");
    public static final By CONFIRM = By.id("repeatedPassword");

    public static final By FIRSTNAME_ERROR = By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[1]/td[3]");
    public static final By LASTNAME_ERROR = By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[2]/td[3]");
    public static final By ADDRESS_ERROR = By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[3]/td[3]");
    public static final By CITY_ERROR = By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[4]/td[3]");
    public static final By STATE_ERROR = By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[5]/td[3]");
    public static final By ZIPCODE_ERROR = By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[6]/td[3]");
    public static final By PHONE_NUMBER_ERROR = By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[7]/td[3]");
    public static final By SSN_ERROR = By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[8]/td[3]");
    public static final By REGISTER_USERNAME_ERROR = By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[10]/td[3]");
    public static final By REGISTER_PASSWORD_ERROR = By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[11]/td[3]");
    public static final By CONFIRM_ERROR = By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[12]/td[3]");
    public static final By SUCCESSFUL_REGISTRATION = By.xpath("/html/body/div[1]/div[3]/div[2]/p");




//    @FindBy(id = "user-name")
//    private WebElement username;
//
//    @FindBy(id = "password")
//    private WebElement password;

    // ===================================== Login Elements =====================================
    @FindBy(xpath = "//*[@id=\"loginPanel\"]/form/div[3]/input")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"loginPanel\"]/p[2]/a")
    private WebElement registerLink;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/p")
    private WebElement loginErrorMessage;

    @FindBy(xpath = "//*[@id=\"leftPanel\"]/p/b")
    private WebElement loginSuccessMessage;

    // ===================================== Register Elements =====================================
    @FindBy(xpath = "//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")
    private WebElement registerButton;


    @FindBy(xpath = "/html/body/div[1]/div[3]/div[1]/ul/li[8]/a")
    private WebElement logout;





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
    public void clickRegisterLink() {
        registerLink.click();
    }

    public String getLoginErrorMessage() {
        return loginErrorMessage.getText();
    }

    public String getLoginSuccessMessage() {
        return loginSuccessMessage.getText();
    }


    // ===================================== Registration form methods =====================================

    public void submitRegistrationForm() {
        registerButton.click();
    }

    public String getLabelText(By locator) {
        return getField(locator).getText();
    }

    public void clickLogoutButton() {
        logout.click();
    }
}
