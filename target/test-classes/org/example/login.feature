Feature: Log in to Sauce Demo
  Background:
    Given the homepage is open

  Scenario Outline: Unsuccessful login
    Given the Username is filled with "<username>"
    And the Password is filled with "<password>"
    When the Login button is clicked
    Then an error message should appear "<error message>"

    Examples:
    | username | password | error message |
    | | | Epic sadface: Username is required |
    | | password | Epic sadface: Username is required |
    | user | | Epic sadface: Password is required |
    | user | password | Epic sadface: Username and password do not match any user in this service |
    | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out. |


  Scenario Outline: Successful login
    Given the Username is filled with "<username>"
    And the Password is filled with "secret_sauce"
    When the Login button is clicked
    Then the user should be directed to the products page with the "PRODUCTS" title
    Examples:
      | username |
      | standard_user |
      | problem_user |
      | performance_glitch_user |

