@activity2
Feature: Login Test

@validLogin
  Scenario: Testing Login
    Given the user is on the login page
    When the user enters username and password
    And clicks the submit button
    Then gets the confirmation message and verify it
