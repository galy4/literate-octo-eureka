
  Feature: Shout feature
    This Feature describes Lucy and Sean interaction
    in terms of free bagels

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
      Given Lucy is in 10 m from Sean
      And Lucy is hungry
      When Sean shouts 'Free bagels!'
      Then Lucy hears Sean message
