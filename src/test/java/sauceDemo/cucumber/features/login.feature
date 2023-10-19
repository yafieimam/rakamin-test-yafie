Feature: Login Sauce Demo App

  @RegressionLogin @PositiveLogin
  Scenario: User Login with Valid Data
    Given Login Page Sauce Demo App
    When Input Username
    And Input Password
    And User Click Login Button
    Then User Redirect to Home Page

  @RegressionLogin @NegativeLogin
  Scenario: User Login with Invalid Data
    Given Login Page Sauce Demo App
    When Input Invalid Username
    And Input Invalid Password
    And User Click Login Button
    Then User Get Error Message
