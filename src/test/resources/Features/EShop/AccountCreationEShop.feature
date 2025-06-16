Feature: TestLab Eshop Tests - Account Creation

    @regression
    Scenario: Create account
    Given The user loaded the eshop main page
    When The user clicks Sign in button in eshop
      And The user selects Create an account in eshop
      And The user fills in the registration form in eshop
      And The user press save in eshop
    Then The user should see the account logged in on eshop home page

    @regression
    Scenario Outline: Create account for multiple users
      Given The user loaded the eshop main page
      When The user clicks Sign in button in eshop
        And The user selects Create an account in eshop
        And The user fills in the registration form with first name "<firstName>" and surname "<surname>" in eshop
        And The user press save in eshop
      Then The user should see the account logged in on eshop home page
      Examples:
      | firstName | surname |
      | TestA     | UserA   |
      | TestB     | UserB   |
      | TestC     | UserC   |
