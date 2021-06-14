Feature: is the city correct

  Scenario: Client makes a GET call to the server to retrieve info about hotels
    Given Client sends a GET request with a specified city
    When Sends HTTP GET request
    Then Client receives a correct output