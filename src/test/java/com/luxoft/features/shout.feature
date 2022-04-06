

Feature: Shout feature
  This Feature describes Lucy and Sean interaction
  in terms of free bagels

  Background:
    Given Sean shouts 'Background'

  Scenario: Listener is within range
  this scenario describes positive
  case
    Given Lucy is in 14 m from Sean
    When Sean shouts 'Free bagels!'
    Then Lucy hears Sean message

  Scenario: Listener is out of range
    Given Lucy is in 20 m from Sean
    When Sean shouts 'Free bagels!'
    Then Lucy not hear Sean message

  Scenario: Lucy is hungry
    Then Lucy is in 10 m from Sean
    Given Kate is hungry
    When Sean shouts 'abrakadabra'
    But Lucy hears Sean message

  Scenario: bullet time
    * Lucy is in 7 m from Sean
    But Lucy is not hungry
    * Sean shouts 'Free coffee!'
    * Lucy hears Sean message

    Scenario Outline: outline example
      Given Lucy is in <dist> m from Sean
      And Alice is hungry
      When Sean shouts '<message>'
      Then Lucy hears Sean message

      Examples:
        | dist | message     |
        | 7    | Free bagels |
        | 10   | Free coffee |
        #negative
        |30    | Free bagels |

  Scenario: Lucy is hungry 1
    Then Lucy is .* 5 m from Sean
    Given Lucy is hungry
    When Sean shouts 'Free bagels!'
    But Lucy hears Sean message