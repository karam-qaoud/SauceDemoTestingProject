Feature: Shoping cart

  Background:
    Given the homepage is open
    And the Username is filled with 'standard_user'
    And the Password is filled with 'secret_sauce'
    And the Login button is clicked

  Scenario Outline: Shoping cart receives items
    Given the "<item>" is added to the cart
    When the cart icon is clicked
    Then the last cart item should be "<item>"
    Examples:
      | item |
      | Sauce Labs Backpack |
      | Sauce Labs Bike Light |
      | Sauce Labs Bolt T-Shirt |
      | Sauce Labs Fleece Jacket |
      | Sauce Labs Onesie |
