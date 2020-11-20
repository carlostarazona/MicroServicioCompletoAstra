Feature: Register a Hospital
  As a Hospital manager
  I want to register my Hospital
  To be able to see it in a future check

  Scenario: Hospitals were found
    Given a Manager in the Hospitals view
    When the Manager clicks the get button
    And make a get request to "/hospitals"
    Then the result received has a status code of 200


  Scenario: No Hospitals were found
    Given a Manager in the Hospitals view
    When the Manager clicks the get button
    And make a get request to "/hospitals"
    Then the result received has a status code of 405



