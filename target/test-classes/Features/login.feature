Feature: Verify Login Page

  Background: Launch ProCare
    Given Launch ProCare application

  @TC_LF_001
  Scenario: Validate logging into the Application using valid credentials
    When User allow to enter username
    And User allow to enter password
    And Click on sigin button
    Then User should land on home page successfully

  @TC_LF_002
  Scenario: Validate logging into the Application using invalid credentials (i.e. Invalid email address and Invalid Password)
    When User allow to enter 'test123' invalid username
    And User allow to enter 'pass2343' invalid password
    And Click on sigin button
    Then Warning message with the text 'Username not found' should be displayed

  @TC_LF_003
  Scenario: Validate logging into the Application using invalid email address and valid Password)
    When User allow to enter 'test123' invalid username
    And User allow to enter password
    And Click on sigin button
    Then Warning message with the text 'Username not found' should be displayed

  @TC_LF_005
  Scenario: Validate logging into the Application without providing any credentials
    And Click on sigin button
    Then Warning message with the text 'Please enter username' and 'Please enter password' should be displayed
