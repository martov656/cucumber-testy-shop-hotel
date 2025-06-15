Feature: TestLab EShop Tests - Account Manipulation

  Rule: New consumer management

    Background: Create an account
      Given The user loaded the eshop main page
      When The user clicks Sign in button in eshop
        And The user selects Create an account in eshop
        And The user fills in the registration form in eshop
        And The user press save in eshop
      Then The user should see the account logged in on eshop home page

    @regression
    Scenario: Add Address to the account
      Given The user loaded the eshop main page
        #And The user Signed in to eshop
        And The user pressed username in the main page of the eshop
      When The user clicked on add first addresses option in the profile in eshop
        And The user fills in the new address details into the form in eshop
        And The user press save the new address form in eshop
      Then The user should see confirmation message address added in eshop
        And The user should see new address added to the list in eshop
        And The user should validate first address details entry in eshop

  Rule: Existing consumer management

    @regression
    Scenario: Add Address to the existing account
      Given The user loaded the eshop main page
        And The existing user Signed in to eshop
        And The user pressed username in the main page of the eshop
        And The user clicked on addresses option in the profile in eshop
        And The existing user had just one address in the profile in eshop
        And The user pressed username in the main page of the eshop
      When The user clicks on addresses option in the profile in eshop
        And The user clicks on create next addresses link in the profile in eshop
        And The user fills in the new address details into the form in eshop
        And The user press save the new address form in eshop
        And The user sees confirmation message address added in eshop
        And The user deletes the second address from the profile in eshop
      Then The user should see the confirmation message deleting the address in the profile in eshop
        And The user should see one address added to the list in eshop
