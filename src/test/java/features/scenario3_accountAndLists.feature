@navigateToUserAccountAndLists
Feature: Verify that user cannot see “Your Orders” and “Your Addresses” pages if user is not logged in whereas user can see “Your Lists” intro screen

  Background: Verify user navigates to the home page and hovers on the "Hello, sign in Account & Lists" section
    Given User is on Amazon home page
    When User hovered on Hello, sign in Account & Lists

  @verifyOrdersScreen
  Scenario: Verify user cannot see “Your Orders” page if user navigated to orders screen without sign in
    Given User selected Your orders from the sign in account & lists page
    Then User should be able to see the "Sign in" page
    And User verify the URL of the "orders" page contains "https://www.amazon.ae/ap/signin"
    And User verify the title of the "orders" page as "Amazon Sign In"


  @verifyAddressScreen
  Scenario: Verify user cannot see “Your Addresses” page if user navigated to address screen without sign in
    Given User selected Your Addresses from the sign in account & lists page
    Then User should be able to see the "Sign in" page
    And User verify the URL of the "address" page contains "https://www.amazon.ae/ap/signin"
    And User verify the title of the "address" page as "Amazon Sign In"


  @verifyListScreen
  Scenario: Verify user can see “Your Lists” page if user navigated to list screen without sign in
    Given User selected Your Lists from the sign in account & lists page
    Then User should be able to see the wishlist page containing text "Lists"
    And User verify the URL of the "wishlist" page as "https://www.amazon.ae/hz/wishlist/intro"
    And User verify the title of the "wishlist" page as "Your List"
