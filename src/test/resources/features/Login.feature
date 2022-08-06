@login

Feature: WebDriver University - Login Page

  Background:
    Given I access the webdriver university login page
    When I enter a username "webdriver"

  Scenario: Validate Successful Login

    And I enter a password webdriver123
    And I click on the login button
    Then I should be presented with the successful login message


  Scenario: Validate Unsuccessful Login

    And I enter a password password123
    And I click on the login button
    Then I should be presented with the unsuccessful login message
