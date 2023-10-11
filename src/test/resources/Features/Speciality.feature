Feature: Verify speciality features

  Background: Launch ProCare
    Given Launch and Login ProCare application

  @TC_ORG_001
  Scenario: Validate if Admin navigate to speciality page
    When User able to see home page
    And User allow to mouse hover Organization Icon
    Then User is able to see speciality option under Organization list
    And User click on speciality button
    Then User should land on Specialty page

  @TC_ORG_002
  Scenario: Validate if Admin can create the speciality
    When User able to see home page
    And User allow to mouse hover Organization Icon
    Then User is able to see speciality option under Organization list
    And User click on speciality button
    Then User should land on Specialty page
    And Click on Add New Specialty
    Then User able to see Add New Specialty section
    And User allow to enter Specialty Name 'AutoSpeciality'
    And User allow to enter Description 'AutoDescription'
    And User allow to enter Region Name 'TestRegion'
    Then click on Save button under Add New Specialty section
    And User should be able to create new Speciality successfully

  @TC_ORG_003
  Scenario: Validate if Admin can create and delete the speciality
    When User able to see home page
    And User allow to mouse hover Organization Icon
    Then User is able to see speciality option under Organization list
    And User click on speciality button
    Then User should land on Specialty page
    And Click on Add New Specialty
    Then User able to see Add New Specialty section
    And User allow to enter Specialty Name 'AutoSpeciality'
    And User allow to enter Description 'AutoDescription'
    And User allow to enter Region Name 'TestRegion'
    Then click on Save button under Add New Specialty section
    And User should be able to create new Speciality successfully
    And User able to select row for newly created speciality
    And Click on Three dot menu
    Then User able to see Delete Selected Rows button
    And click on Delete Selected Rows button
    Then Delete confirmation box should be open along with text 'Are you sure you want to delete this record?'
    And click on Yes button
    Then newly created speciality should be delete successfully
    
    
  @TC_ORG_004
  Scenario: Validate if Admin can create and update the speciality
    When User able to see home page
    And User allow to mouse hover Organization Icon
    Then User is able to see speciality option under Organization list
    And User click on speciality button
    Then User should land on Specialty page
    And Click on Add New Specialty
    Then User able to see Add New Specialty section
    And User allow to enter Specialty Name 'AutoSpeciality'
    And User allow to enter Description 'AutoDescription'
    And User allow to enter Region Name 'TestRegion'
    Then click on Save button under Add New Specialty section
    And User should be able to create new Speciality successfully
    And User double click on newly created speciality
    And User allow to enter updated speciality 'UpdatedSpeciality'
    And User click on save button under section
    Then Speciality should be updated successfully
   	
