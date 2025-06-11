  Feature: Hotel Tests - Order Flow

  @regression
  Scenario: Existing user searches for hotel
    Given The user loaded the hotel main page
      And The user clicked Sign in button
      And The user entered his email and password
  #    And The user went to main hotel page
  #  When The user enters hotel location "Krakow" and hotel name "The Hotel Prime"
  #    And The user enters checkIn and checkOut dates
  #    And The user clicks search for hotel
  #  Then The user should see found hotel offers

  #@regression
  #Scenario: Existing user books the selected hotel
  #  Given The user loaded the hotel main page
  #    And The user clicked Sign in button
  #    And The user entered his email and password
  #    And The user went to main hotel page
  #  When The user enters hotel location "Krakow" and hotel name "The Hotel Prime"
  #    And The user enters checkIn and checkOut dates
  #    And The user clicks search for hotel
  #    And The user selects book now the first hotel
  #    And The user confirms the hotel selection in shopping cart
  #    And The user opens the shopping cart
  #    And The user confirms the business terms and conditions
  #    And The user clicks payment by bank account
  #    And The user confirms the order
  #  Then The user should see the order confirmation title and alert displayed
