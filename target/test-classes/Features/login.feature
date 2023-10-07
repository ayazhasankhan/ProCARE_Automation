Feature: login into application with valid credentials 

  Scenario: Login should be success
    When User enter the username as "ps@deborah.org"
    And User enter the password as "BigC@ctus2020"
    And User click on the login button
    Then Login should be success
