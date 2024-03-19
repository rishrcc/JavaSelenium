Feature: Login

  Scenario: Test the login feature
    Given I provide username and password
    When I click on login button
    Then I should view the Dashboard

  Scenario Outline: Test the login feature with Examples
    Given I enter <username> and <password>
    When I click on login button
    Then I should view the Dashboard

    Examples:
    |username|password|
    |Admin   |admin123|
    |guest   |guest123|