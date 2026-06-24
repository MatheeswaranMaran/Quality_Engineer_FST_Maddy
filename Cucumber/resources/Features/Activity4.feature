@activity4
Feature: Login Test

  @validLogin
  Scenario: Testing Login without Examples
    Given the user is on the login page
    When the user enters "admin" and "password"
    And clicks the submit button
    Then gets the confirmation message and verify it
