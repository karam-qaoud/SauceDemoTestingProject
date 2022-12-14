package org.example;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class StepDefs {

    private static final int WAIT_TIME = 10;

    static WebDriver driver;

    private static HomePage homePage;

    static {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
    }

    @Given("the homepage is open")
    public void theHomepageIsOpen() {
        homePage.openPage();
    }

    // ===================================== Login Step Defs =====================================

    @Given("the Username is filled with {string}")
    public void theUsernameIsFilledWith(String arg0) {
        homePage.fillField(HomePage.USERNAME, arg0);
    }

    @And("the Password is filled with {string}")
    public void thePasswordIsFilledWith(String arg0) {
        homePage.fillField(HomePage.PASSWORD, arg0);
    }

    @When("the Login button is clicked")
    public void theLoginButtonIsClicked() {
        homePage.clickLoginButton();
    }

    @Then("an error message should appear {string}")
    public void anErrorMessageShouldAppear(String arg0) {
        Assert.assertEquals(arg0, homePage.getLoginErrorMessage());
    }

    @Then("the user should be directed to the products page with the {string} title")
    public void theUserShouldBeDirectedToTheProductsPageWithTheTitle(String arg0) {
        Assert.assertEquals(arg0, homePage.getLoginSuccessMessage());
    }

    // ===================================== Sorting Step Defs =====================================

    @When("the user sorts the products by {string}")
    public void theUserSortsTheProductsBy(String arg0) {
        if(arg0.equals("NAME (A TO Z)")) {
            homePage.clickSortAtoZOption();
        } else if (arg0.equals("NAME (Z TO A)")) {
            homePage.clickSortZtoAOption();
        } else if (arg0.equals("PRICE (LOW TO HIGH)")) {
            homePage.clickSortLowToHighOption();
        } else if (arg0.equals("PRICE (HIGH TO LOW)")) {
            homePage.clickSortHighToLowOption();
        }
    }

    @Then("the first product name should be {string}")
    public void theProductsNameShouldBe(String arg0) {
        Assert.assertEquals(arg0, homePage.getFirstProductName());
    }

    @Then("the first product price should be {string}")
    public void theProductsPriceShouldBe(String arg0) {
        Assert.assertEquals(arg0, homePage.getFirstProductPrice());
    }

    // ===================================== Shoping Cart Step Defs =====================================

    @Given("the {string} is added to the cart")
    public void theIsAddedToTheCart(String arg0) {
        if(arg0.equals("Sauce Labs Backpack")) {
            homePage.addBackPackToCart();
        } else if (arg0.equals("Sauce Labs Bike Light")) {
            homePage.addBikeLightToCart();
        } else if (arg0.equals("Sauce Labs Bolt T-Shirt")) {
            homePage.addTShirtToCart();
        } else if (arg0.equals("Sauce Labs Fleece Jacket")) {
            homePage.addFleeceToCart();
        } else if (arg0.equals("Sauce Labs Onesie")) {
            homePage.addOnesieToCart();
        }
    }

    @When("the cart icon is clicked")
    public void theCartIconIsClicked() {
        homePage.clickOnCart();
    }

    @Then("the last cart item should be {string}")
    public void theFirstCartItemShouldBe(String arg0) {
        Assert.assertEquals(arg0, homePage.getLastItemInCartName());
    }

    @When("the remove button is clicked for {string}")
    public void theRemoveButtonIsClickedFor(String arg0) {
        if(arg0.equals("Sauce Labs Backpack")) {
            homePage.removeBackPackFromCart();
        } else if (arg0.equals("Sauce Labs Bike Light")) {
            homePage.removeBikeLightFromCart();
        } else if (arg0.equals("Sauce Labs Bolt T-Shirt")) {
            homePage.removeTShirtFromCart();
        } else if (arg0.equals("Sauce Labs Fleece Jacket")) {
            homePage.removeFleeceFromCart();
        }
    }

    @Then("the number of items in the cart should be {string}")
    public void theNumberOfItemsInTheCartShouldBe(String arg0) {
        Assert.assertEquals(arg0, homePage.getNumberOfItemsInShopingCart());
    }

    // ===================================== Checkout form Step Defs =====================================
    @Given("the Sauce Labs Backpack is added to the cart")
    public void theSauceLabsBackpackIsAddedToTheCart() {
        homePage.addBackPackToCart();
    }

    @And("the checkout button is clicked")
    public void theCheckoutButtonIsClicked() {
        homePage.clickCheckoutButton();
    }

    @And("the First Name is filled with {string}")
    public void theFirstNameIsFilledWith(String arg0) {
        homePage.fillField(HomePage.FIRST_NAME, arg0);
    }

    @And("the Last Name is filled with {string}")
    public void theLastNameIsFilledWith(String arg0) {
        homePage.fillField(HomePage.LAST_NAME, arg0);
    }

    @And("the Zip Code is filled with {string}")
    public void theZipCodeIsFilledWith(String arg0) {
        homePage.fillField(HomePage.POSTAL_CODE, arg0);
    }

    @When("the Continue button is clicked")
    public void theContinueButtonIsClicked() {
        homePage.clickContinueButton();
    }

    @Then("This error message should be shown {string}")
    public void thisErrorMessageShouldBeShown(String arg0) {
        Assert.assertEquals(homePage.getErrorMessage(), arg0);
    }

    @Then("{string} should be shown")
    public void total$ShouldBeShown(String arg0) {
        Assert.assertEquals(homePage.getTotal(), arg0);
    }

    // ===================================== Logout form Step Defs =====================================
    @Given("the side menu icon is clicked")
    public void theSideMenuIconIsClicked() {
        homePage.clickSideMenuButton();
    }

    @When("the Logout button is clicked")
    public void theLogoutButtonIsClicked() {
        homePage.clickLogoutButton();
    }

    @Then("the user exits and the login form appears.")
    public void theUserExitsAndTheLoginFormAppears() {
        Assert.assertEquals(homePage.doesLoginFormExist(), true);
    }
}