Feature: Log out of Sauce Demo

  Background:
    Given the homepage is open
    And the Username is filled with 'standard_user'
    And the Password is filled with 'secret_sauce'
    And the Login button is clicked

  Scenario: Logout
    Given the side menu icon is clicked
    When the Logout button is clicked
    Then the user exits and the login form appears.