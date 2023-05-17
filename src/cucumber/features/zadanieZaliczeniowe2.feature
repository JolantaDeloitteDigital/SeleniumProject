Feature: My Store TestLab
  Scenario: Adding a new address
    Given Page "https://mystore-testlab.coderslab.pl/index.php" opened in browser
    When When Sign In button clicked
    And Logged in user details entered
    And Search for "Hummingbird Printed Sweater"
    And Click in search results
    And Select size "M"
    And Select quantity "5"
    And Add to cart
    And Proceed to cart
    And Proceed to checkout
    And Confirm address
    And Select pick up in store shipping option
    And Confirm shipping
    And Select pay by check payment option
    And Agree to terms and conditions
    And Confirm order
    Then Save Screenshot
    Then Close browser
