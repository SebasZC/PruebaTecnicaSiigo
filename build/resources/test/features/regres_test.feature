Feature: xx

@GET
  Scenario: Get a specific user and validate the response.
    When the developer get a user with id 2
    Then the status code should be 200
    And The service response must contain the fuchsia rose value in the path data.name

  Scenario: Register a New User
    When the developer POST a new user whit data
      | name      | job                 |
      | Sebastian | Automation Engineer |
    Then the status code should be 201
    And The service response must contain the Sebastian value in the path name
    And The service response must contain the Automation Engineer value in the path job

  Scenario: Update a User
    When the developer update the user with id 3 and the data
      | name      | job            |
      | Sebas put | Automation put |
    Then the status code should be 200
    And The service response must contain the Sebas put value in the path name
    And The service response must contain the Automation put value in the path job

    Scenario: Delete a user
      When the developer delete a user created with id 5
      Then the status code should be 204


