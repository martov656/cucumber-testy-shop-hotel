Feature: Hotel Tests - Account Manipulation

  Background: Create an account
    Given The user loaded the hotel main page
    When The user clicks Sign in button
      And The user fills in email and selects Create an account
      And The user fills in the registration form and press register
    Then The user should see the account created

  @regression
  Scenario: Add Address to the account
    Given The user loaded the hotel main page
      And The user logged out the hotel system
      And The user logged in the hotel system
     # And The user clicked on my addresses option in the profile
   # When The user press add a new address
    #  And The user fills in the new address details into the form
     # And The user saves the new address form
    #Then The user should see new address added to the list
