Feature: To test healthcare

  Scenario: sample test
    Given open browser
    When launch site "https://www.mayoclinic.org/"
    Then click on symptom checker
    Then select one symptom
    Then select related factors
   