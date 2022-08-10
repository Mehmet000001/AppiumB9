
Feature:  Testing ecommerce mobile application

  Scenario: Happy path login
    Given ecommerce app has launched
    When I login to shop in Afghanistan
    Then I should see list o items