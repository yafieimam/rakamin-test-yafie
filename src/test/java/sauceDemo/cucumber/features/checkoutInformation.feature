Feature: Checkout Information Sauce Demo App

  @RegressionCheckoutInformation @PositiveCheckoutInformation
  Scenario: User Put Valid Information in Checkout Information Page
    Given Logged In Using Standard User for Checkout Information
    When Add Item to Cart for Checkout Information
    And Click Icon Cart for Checkout Information
    And Click Checkout Button for Checkout Information
    And Input First Name for Checkout Information
    And Input Last Name for Checkout Information
    And Input Postal Code for Checkout Information
    And Click Continue Button for Checkout Information
    Then User Get Checkout Information Detail

  @RegressionCheckoutInformation @NegativeCheckoutInformation
  Scenario: User Put Empty Information in Checkout Information Page
    Given Logged In Using Standard User for Checkout Information
    When Add Item to Cart for Checkout Information
    And Click Icon Cart for Checkout Information
    And Click Checkout Button for Checkout Information
    And Click Continue Button for Checkout Information
    Then User Get Error Message for Checkout Information
