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

    @Then("the user should be logged in and a {string} message is displayed")
    public void theUserShouldBeLoggedInAndAMessageIsDisplayed(String arg0) {
        Assert.assertEquals(arg0, homePage.getLoginSuccessMessage());
        homePage.clickLogoutButton();

    }


    // ===================================== Register step defs =====================================

    @And("register link is clicked")
    public void registerLinkIsClicked() {
        homePage.clickRegisterLink();
    }

    @Given("the first name is filled with {string}")
    public void theFirstNameIsFilledWith(String arg0) {
        homePage.fillField(HomePage.FIRSTNAME, arg0);
    }

    @And("the Last Name is filled with {string}")
    public void theLastNameIsFilledWith(String arg0) {
        homePage.fillField(HomePage.LASTNAME, arg0);
    }

    @And("the Address is filled with {string}")
    public void theAddressIsFilledWith(String arg0) {
        homePage.fillField(HomePage.ADDRESS, arg0);
    }

    @And("the City is filled with {string}")
    public void theCityIsFilledWith(String arg0) {
        homePage.fillField(HomePage.CITY, arg0);
    }

    @And("the State is filled with {string}")
    public void theStateIsFilledWith(String arg0) {
        homePage.fillField(HomePage.STATE, arg0);
    }

    @And("the Zip Code is filled with {string}")
    public void theZipCodeIsFilledWith(String arg0) {
        homePage.fillField(HomePage.ZIPCODE, arg0);
    }

    @And("the Phone # is filled with {string}")
    public void thePhoneIsFilledWith(String arg0) {
        homePage.fillField(HomePage.PHONE_NUMBER, arg0);
    }

    @And("the SSN is filled with {string}")
    public void theSSNIsFilledWith(String arg0) {
        homePage.fillField(HomePage.SSN, arg0);
    }

    @And("the Register Username is filled with {string}")
    public void theRegisterUsernameIsFilledWith(String arg0) {
        homePage.fillField(HomePage.REGISTER_USERNAME, arg0);
    }

    @And("the Register Password is filled with {string}")
    public void theRegisterPasswordIsFilledWith(String arg0) {
        homePage.fillField(HomePage.REGISTER_PASSWORD, arg0);
    }
    @And("the Confirm is filled with {string}")
    public void theConfirmIsFilledWith(String arg0) {
        homePage.fillField(HomePage.CONFIRM, arg0);
    }

    @When("Register button is clicked")
    public void registerButtonIsClicked() {
        homePage.submitRegistrationForm();
    }

    @Then("the First Name error field should show {string}")
    public void theFirstNameErrorFieldShouldShow(String arg0) {
        Assert.assertEquals(arg0, homePage.getLabelText(HomePage.FIRSTNAME_ERROR));
    }

    @And("the Last Name error field should show {string}")
    public void theLastNameErrorFieldShouldShow(String arg0) {
        Assert.assertEquals(arg0, homePage.getLabelText(HomePage.LASTNAME_ERROR));
    }

    @And("the Address field should show {string}")
    public void theAddressFieldShouldShow(String arg0) {
        Assert.assertEquals(arg0, homePage.getLabelText(HomePage.ADDRESS_ERROR));
    }

    @And("the City error field should show {string}")
    public void theCityErrorFieldShouldShow(String arg0) {
        Assert.assertEquals(arg0, homePage.getLabelText(HomePage.CITY_ERROR));
    }

    @And("the State error field should show {string}")
    public void theStateErrorFieldShouldShow(String arg0) {
        Assert.assertEquals(arg0, homePage.getLabelText(HomePage.STATE_ERROR));
    }

    @And("the Zip Code error field should show {string}")
    public void theZipCodeErrorFieldShouldShow(String arg0) {
        Assert.assertEquals(arg0, homePage.getLabelText(HomePage.ZIPCODE_ERROR));
    }

    @And("the Phone # error field should show {string}")
    public void thePhoneErrorFieldShouldShow(String arg0) {
        Assert.assertEquals(arg0, homePage.getLabelText(HomePage.PHONE_NUMBER_ERROR));
    }

    @And("the SSN error field should show {string}")
    public void theSSNErrorFieldShouldShow(String arg0) {
        Assert.assertEquals(arg0, homePage.getLabelText(HomePage.SSN_ERROR));
    }

    @And("the Username error field should show {string}")
    public void theUsernameErrorFieldShouldShow(String arg0) {
        Assert.assertEquals(arg0, homePage.getLabelText(HomePage.REGISTER_USERNAME_ERROR));
    }

    @And("the Password error field should show {string}")
    public void thePasswordErrorFieldShouldShow(String arg0) {
        Assert.assertEquals(arg0, homePage.getLabelText(HomePage.REGISTER_PASSWORD_ERROR));
    }

    @And("the Confirm error field should show {string}")
    public void theConfirmErrorFieldShouldShow(String arg0) {
        Assert.assertEquals(arg0, homePage.getLabelText(HomePage.CONFIRM_ERROR));
    }

    @Then("the message {string} should be displayed")
    public void theMessageShouldBeDisplayed(String arg0) {
        Assert.assertEquals(arg0, homePage.getLabelText(HomePage.SUCCESSFUL_REGISTRATION));
    }
}