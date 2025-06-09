Feature: Hotel Tests - Account Creation

  @regression
  Scenario: Create account
    Given The user loaded the hotel main page
     When The user clicks Sign in button
      And The user fills in email and selects Create an account
      And The user fills in the registration form and press register
     Then The user should see the account created

  @regression
  Scenario Outline: Create accounts for multiple users
    Given The user loaded the hotel main page
    When The user clicks Sign in button
      And The user fills in email and selects Create an account
      And The user fills in first name "<firstName>" and surname "<surname>" with password "<password>"
    Then The user should see the account created

    Examples:
      | firstName | surname | password |
      | TestA     | UserA   | Pass123  |
      | TestB     | UserB   | Pass456  |
      | TestC     | UserC   | Pass789  |