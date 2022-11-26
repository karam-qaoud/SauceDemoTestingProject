Feature: Log in to PARA BANK
  Background:
    Given the homepage is open

  Scenario Outline: Unsuccessful login
    Given the Username is filled with "<username>"
    And the Password is filled with "<password>"
    When the Login button is clicked
    Then an error message should appear "<error message>"

    Examples:
    | username | password | error message |
    |karam_user | | Please enter a username and password. |
    | | karamPASSWORD | Please enter a username and password. |
    | | | Please enter a username and password. |


  Scenario: Registered user
    Given the Username is filled with "registeredAccount101"
    And the Password is filled with "newPassword"
    When the Login button is clicked
    Then the user should be logged in and a "Welcome" message is displayed

