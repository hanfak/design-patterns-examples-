Feature: Price of record

  Background:
    Given The movie record server exists

  Scenario: Test output of void method
    When Pricer asks for data for id "1" film name "Goonies" movie type "NEW" and amount 1
    Then The price stored in movie record server is 5.0