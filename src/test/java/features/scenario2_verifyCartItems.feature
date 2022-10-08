@verifyItemsInTheCart
Feature: Verify the quantity of the products added to cart along with the product name, title, price and sub total

  @verifyItemQuantity @verifyItemPrice
  Scenario: Verification of the Items added to cart.
    Given User is on Amazon home page
    When User clicked on "today's deals" button
    And User clicked on second category 2 under categories section
    And User selected first item 1 in the category
    And User increased the quantity of the product count to "3"
    Then User clicked on Add to cart button
    And User navigated to cart section
    Then User verified the name of the product added
    And User verified the price, total and quantity of the product added
