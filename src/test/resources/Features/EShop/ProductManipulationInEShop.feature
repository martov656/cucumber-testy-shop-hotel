Feature: TestLab EShop Tests - Product Manipulation

    @regression
    Scenario: Perform purchase in the EShop
      Given The user loaded the eshop main page
        And The existing user Signed in to eshop
        And The user went to main page in eshop
      When The user selects a Hummingbird Printed Sweater for purchase in eshop
        And The user verifies the discount is 20% in eshop
        And The user chooses "M" size in eshop
        And The user enters "5" pieces in thee shop
        And The user adds the product to the cart in eshop
        And The user press checkout in eshop
        And The user confirms the address in eshop
        And The user selects the delivery method - PrestaShop `pick up in store` in eshop
        And The user selects the Pay by Check payment option in eshop
        And The user takes a screenshot of the order confirmation and the amount in the order in eshop
        And The user goes to the order history in eshop
      Then The user should see order in the list history in eshop
        And The user should see the status `Awaiting check payment` in eshop
        And The user should see the amount of the order matches with purchase in eshop

