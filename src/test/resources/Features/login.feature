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

  @TC_LF_010
  Scenario: Validate E-Mail Address and Password text fields in the Login page have the place holder text
    And User is able to see Username and Password fields
    Then User should able to see the placeholder 'Username' and '******'

  Scenario: Validate Forgot password link is displayed
    And User is able to see Username and Password fields
    Then User should able to see the Forgot Password link

  Scenario: Validate Remember Me checkbox toggle functionality
    And User is able to see Checkbox along with text 'Remember me'
    Then User should be able to perform toggle actions on checkbox
