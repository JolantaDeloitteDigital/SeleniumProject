Feature: My Store TestLab
  Scenario Outline: Adding a new address
    Given Page "https://mystore-testlab.coderslab.pl/index.php" opened in browser
    When When Sign In button clicked
    And Logged in user details entered
    And Account details button is clicked
    And Addresses tab is clicked
    And Add new address button is clicked
    And New address details are filled in with given details "<addressAlias>", "<addressAddress>", "<addressCity>", "<addressZipCode>", "<addressPhone>"
    And New address is submitted
    Then New address details match added address details "<addressAlias>", "<addressAddress>", "<addressCity>", "<addressZipCode>", "<addressPhone>"
    Then Delete just added address
    Then Check if address was deleted
    Then Close browser

    Examples:
      |addressAlias      | addressAddress  | addressCity | addressZipCode | addressPhone |
      |Address 2         | Address 2       | Test City   | 1-101          | 0987654321   |
