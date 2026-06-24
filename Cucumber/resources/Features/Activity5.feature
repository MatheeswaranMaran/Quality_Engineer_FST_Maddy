@activity5
Feature: Login Test

@validLogin
Scenario Outline: Testing Login with Examples
	Given the user is on the login page
    When the user enters "<Username>" and "<Password>"
    And clicks the submit button
    Then gets the "Invalid credentials" and verify it
    
Examples:

	| Username | Password |
	| username | pwd	  |
	| uname    | password |
