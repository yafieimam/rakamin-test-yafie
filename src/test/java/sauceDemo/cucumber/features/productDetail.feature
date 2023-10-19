Feature: Product Detail Page Sauce Demo App

  @RegressionProductDetail @PositiveProductDetail
  Scenario: User Access Product Detail Page Using Standard User
    Given Logged In Using Standard User for Product Detail
    When Click Product Title
    Then User Get Product Detail Correctly

  @RegressionProductDetail @NegativeProductDetail
  Scenario: User Access Product Detail Page Using Problem User
    Given Logged In Using Problem User for Product Detail
    When Click Product Title
    Then User Get Product Detail Incorrectly
