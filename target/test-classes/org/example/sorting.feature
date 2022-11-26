Feature: Sorting Products

  Background:
    Given the homepage is open
    And the Username is filled with "standard_user"
    And the Password is filled with "secret_sauce"
    And the Login button is clicked

  Scenario Outline: Sort Products
    When the user sorts the products by "<filter>"
    Then the first product name should be "<productName>"

    Examples:
      | filter | productName |
      | NAME (A TO Z) | Sauce Labs Backpack |
      | NAME (Z TO A) | Test.allTheThings() T-Shirt (Red) |


  Scenario Outline: Sort Products
    When the user sorts the products by "<filter>"
    Then the first product price should be "<price>"

    Examples:
      | filter | price |
      | PRICE (LOW TO HIGH) | $7.99 |
      | PRICE (HIGH TO LOW) | $49.99 |


