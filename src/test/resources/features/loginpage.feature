Feature: Login Page Feature

  Background:
    Given user is on homepage
    When user clicks on sign in link

  @Smoke
  Scenario: Login Page Title
    When user gets the title of loginpage
    Then loginpage title should be "Customer Login"

  Scenario: Forgot Your Password Link
    Then forgot your password link should be displayed

  Scenario: Login With Correct Credentials
    When user enters username "test@account.com" and enters password "Test@123"
    And user clicks on Sign In button
    Then user gets the title of homepage
    And homepage title should be "Home Page"
