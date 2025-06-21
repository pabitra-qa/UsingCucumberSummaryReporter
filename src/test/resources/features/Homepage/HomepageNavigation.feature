#Author: Pabitra Swain (pabitra.swain.work@gmail.com)
@reporter
Feature: Test Homepage Navigation

  Scenario: Test Feature Three Scenario 1
    Then Test Step One Feature Three

  Scenario: Test Feature Three Scenario 2
    Then Test Step Tow Feature Three

  Scenario Outline: Test Feature Three Scenario 3
    Then Test Step "<user>" Feature Three
    Examples:
      | user    |
      | pabitra |
      | swain   |