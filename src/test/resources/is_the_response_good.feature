Feature: the response can be retrieved

  Scenario: client makes a GET call
    Given Client sends a GET request
    When Sends GET HTTP request
    Then Client receives a valid HTTP response code "200"


