
  @web
  Feature: Selenium test example

    Scenario: verify main menu items
      Given home page is opened
      Then main menu contain
        | HOME       |
        | SERVICES   |
        | INDUSTRIES |
        | CAREERS    |
        | CONTACT US |

    Scenario: verify main menu items
      Given home page is opened
      Then main menu contain
        | HOME       |
        | SERVICES   |
        | INDUSTRIES |
        | CAREERS    |
        | CONTACT US |