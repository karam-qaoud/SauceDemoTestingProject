Feature: Shoping cart

  Background:
    Given the homepage is open
    And the Username is filled with 'standard_user'
    And the Password is filled with 'secret_sauce'
    And the Login button is clicked

  Scenario Outline: Adding items to cart
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

  Scenario Outline: Removing items from cart
    When the remove button is clicked for "<item>"
    Then the number of items in the cart should be "<count>"
    Examples:
      | item | count |
      | Sauce Labs Backpack | 4 |
      | Sauce Labs Bike Light | 3 |
      | Sauce Labs Bolt T-Shirt | 2 |
      | Sauce Labs Fleece Jacket | 1 |
