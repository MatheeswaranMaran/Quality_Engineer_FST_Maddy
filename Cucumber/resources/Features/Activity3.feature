@activity3
Feature: Testing with Tags

  Scenario: Testing with Simple Alert
    Given the user is on the alerts page
    When the user clicks the simple alert button
    And the user goes to the alert and accepts it
    Then checks the simple alert message

  Scenario: Testing with Confirm Alert
    Given the user is on the alerts page
    When the user clicks the confirm alert button
    And the user goes to the alert and accepts it
    Then checks the confirm alert message

  Scenario Outline: Testing with Prompt Alert
    Given the user is on the alerts page
    When the user clicks the prompt alert button
    And the user goes to the alert and gives "<Prompt>" and accepts it
    Then checks the "<Prompt>" alert message

    Examples:
      | Prompt   |
      | Hi Maddy |
      | Hi Abi   |
