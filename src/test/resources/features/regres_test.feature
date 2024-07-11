#Project name: Siigo Challenge
  #Author name: Sebastian Zapata C
  #Author email: zapatasebastian001@gmail.com

Feature: I as a User want to validate various user management operations via the API

  @TC_01 @get_user
  Scenario: Get a specific user and validate the response.
    When the developer get a user with id 2
    Then the status code should be 200
    And The service response must contain the fuchsia rose value in the path data.name

  @TC_02 @register_user
  Scenario: Register a New User with name and job and validate the response
    When the developer POST a new user whit data
      | name      | job                 |
      | Sebastian | Automation Engineer |
    Then the status code should be 201
    And The service response must contain the Sebastian value in the path name
    And The service response must contain the Automation Engineer value in the path job

  @TC_03 @update_user
  Scenario: Update a User and validate the response
    When the developer update the user with id 3 and the data
      | name      | job            |
      | Sebas put | Automation put |
    Then the status code should be 200
    And The service response must contain the Sebas put value in the path name
    And The service response must contain the Automation put value in the path job

  @TC_04 @delete_user
  Scenario: Delete a user
    When the developer delete a user created with id 5
    Then the status code should be 204

  @TC_05 @register_with_email
  Scenario: Register a New user with email and password
    When the developer POST a new register with data
      | email              | password |
      | eve.holt@reqres.in | pistol   |
    Then the status code should be 200