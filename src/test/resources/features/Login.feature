@Login
Feature: Login
  User wants to log in to website sauce demo

  @TC1
  Scenario: User log in with valid credential
    Given User already on login page
    When User input "standard_user" as username
    And User input "secret_sauce" as password
    And User click button login
    Then User will be redirected to inventory page

  @TC2
  Scenario: User login with valid credential
    Given User has already on login page
    When User input "standard_user" as username and "secret_sauce" as password
    Then User will be redirected to inventory page

  @TC3
  Scenario Outline: User login with invalid credential
    Given User already on login page
    When User input "<userName>" as username and "<password>" as password
    Then User will see error message "<errorText>" on login page
    Examples:
      | userName      | password     | errorText                                                                 |
      |               | secret_sauce | Epic sadface: Username is required                                        |
      | standard_user |              | Epic sadface: Password is required                                        |
      | user123       | password123  | Epic sadface: Username and password do not match any user in this service |
      |               |              | Epic sadface: Username is required                                        |