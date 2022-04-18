
  @webweb
  Feature: Selenium test example

    Scenario: verify main menu items 1
      Given "home page" page is opened
      Then main menu contain
        | HOME       |
        | SERVICES   |
        | INDUSTRIES |
        | CAREERS    |
        | CONTACT US |

    Scenario: verify main menu items 2
      Given "home page" page is opened
      Then main menu contain
        | HOME       |
        | SERVICES   |
        | INDUSTRIES |
        | CAREERS    |
        | CONTACT US |