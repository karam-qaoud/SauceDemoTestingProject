Feature: Registering an account in PARA BANK
  Background:
    Given the homepage is open
    And register link is clicked


  Scenario Outline: Unsuccessful registration
    Given the first name is filled with "<firstName>"
    And the Last Name is filled with "<lastName>"
    And the Address is filled with "<address>"
    And the City is filled with "<city>"
    And the State is filled with "<state>"
    And the Zip Code is filled with "<zipCode>"
    And the Phone # is filled with "<phoneNumber>"
    And the SSN is filled with "<ssn>"
    And the Register Username is filled with "<username>"
    And the Register Password is filled with "<password>"
    And the Confirm is filled with "<confirm>"
    When Register button is clicked
    Then the First Name error field should show "<firstNameErrorMessage>"
    And the Last Name error field should show "<lastNameErrorMessage>"
    And the Address field should show "<addressErrorMessage>"
    And the City error field should show "<cityErrorMessage>"
    And the State error field should show "<stateNameErrorMessage>"
    And the Zip Code error field should show "<zipCodeErrorMessage>"
    And the Phone # error field should show "<phoneNumberErrorMessage>"
    And the SSN error field should show "<ssnErrorMessage>"
    And the Username error field should show "<usernameErrorMessage>"
    And the Password error field should show "<passwordErrorMessage>"
    And the Confirm error field should show "<confirmErrorMessage>"
    Examples:
      | firstName | lastName | address | city | state | zipCode | phoneNumber | ssn | username | password | confirm | firstNameErrorMessage | lastNameErrorMessage | addressErrorMessage | cityErrorMessage | stateNameErrorMessage | zipCodeErrorMessage | phoneNumberErrorMessage | ssnErrorMessage | usernameErrorMessage | passwordErrorMessage | confirmErrorMessage |
      | TesterFirstName | TesterLastName | myAddress | myCity | myState | 1234 | 123456789 | 123 | newUserNameForTesting | newPassword | newPassword |  |                      |                     |                  |                       |                     |                         |                 |                      |                      |                     |
      |  |  |  |  |  |  |  |  |  |  | | First name is required. | Last name is required. | Address is required. | City is required. | State is required. | Zip Code is required. | | Social Security Number is required. | 	Username is required. | Password is required. | Password confirmation is required. |
      |  |  |  |  |  |  | 123456789 |  |  |  | | First name is required. | Last name is required. | Address is required. | City is required. | State is required. | Zip Code is required. | | Social Security Number is required. | 	Username is required. | Password is required. | Password confirmation is required. |
      | TesterFirstName | TesterLastName | myAddress | myCity | myState | 1234 | 123456789 | 123 | newUserNameForTesting | newPassword | newPassword |  |                      |                     |                  |                       |                     |                         |                 |	This username already exists. |                      |                     |
      | TesterFirstName | TesterLastName | myAddress | myCity | myState | 1234 | 123456789 | 123 | newUserNameForTesting7 | newPassword | password |  |                      |                     |                  |                       |                     |                         |                 |                      |                      | Passwords did not match. |

  Scenario: Successful registration
    Given the first name is filled with "TesterFirstName"
    And the Last Name is filled with "TesterLastName"
    And the Address is filled with "myAddress"
    And the City is filled with "myCity"
    And the State is filled with "myState"
    And the Zip Code is filled with "1234"
    And the Phone # is filled with "123456789"
    And the SSN is filled with "123"
    And the Username is filled with "registeredAccount123123123"
    And the Password is filled with "registeredAccount"
    And the Confirm is filled with "newPassword"
    When Register button is clicked
    Then the message "Your account was created successfully. You are now logged in." should be displayed
