Feature: Login

  Scenario: Test the login feature
    Given I provide username and password
    When I click on login button
    Then I should view the homepage