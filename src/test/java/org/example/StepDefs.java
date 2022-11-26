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
}