Feature: Checkout Sauce Demo App

  @RegressionCheckout @PositiveCheckout
  Scenario: User Checkout with Several Items in Cart
    Given Logged In Using Standard User for Checkout
    When Add Item to Cart for Checkout
    And Click Icon Cart for Checkout
    And Click Checkout Button for Checkout
    And Input First Name for Checkout
    And Input Last Name for Checkout
    And Input Postal Code for Checkout
    And Click Continue Button for Checkout
    And Click Finish Button for Checkout
    Then User Get Checkout Information Finished

  @RegressionCheckout @NegativeCheckout
  Scenario: User Checkout with Several Items in Cart
    Given Logged In Using Standard User for Checkout
    When Click Icon Cart for Checkout
    And Click Checkout Button for Checkout
    Then User Get Error Message for Checkout
