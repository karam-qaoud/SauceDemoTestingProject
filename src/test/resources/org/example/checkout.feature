Feature: Checkout form

  Background:
    Given the homepage is open
    And the Username is filled with 'standard_user'
    And the Password is filled with 'secret_sauce'
    And the Login button is clicked

  Scenario Outline: Invalid checkout
    Given the cart icon is clicked
    And the checkout button is clicked
    And the First Name is filled with "<firstName>"
    And the Last Name is filled with "<lastName>"
    And the Zip Code is filled with "<zipCode>"
    When the Continue button is clicked
    Then This error message should be shown "<error>"
    Examples:
      | firstName | lastName | zipCode | error |
      | | | | Error: First Name is required |
      | | lastName | zipCode | Error: First Name is required |
      | firstName | | zipCode | Error: Last Name is required |
      | firstName | lastName | | Error: Postal Code is required |


  Scenario: Valid checkout
    Given the cart icon is clicked
    And the checkout button is clicked
    And the First Name is filled with 'first'
    And the Last Name is filled with 'last'
    And the Zip Code is filled with '1234'
    When the Continue button is clicked
    Then 'Total: $8.63' should be shown