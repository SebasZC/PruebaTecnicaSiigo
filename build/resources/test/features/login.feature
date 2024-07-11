#Auhtor: Sebastian Zapata
  #Email: zapatasebastian001@gmail.com

Feature: I as a User I want to validate the login page

  @Test
  Scenario: Validate basic login flow
    Given the user is on the main page
    And the user cliks on login button
    When the user login with credentials
      | user                         | password  |
      | zapatasebastian001@gmail.com | s3b4st!aN |
    And the user cliks on login send button
    Then the user can see the message Welcome zapatasebastian001@gmail.com

