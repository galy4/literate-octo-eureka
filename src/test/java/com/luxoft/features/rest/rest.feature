
  Feature: Rest example

    Background:
      Given I use 'https://jsonplaceholder.typicode.com' service

    Scenario: status test
      When I invoke get method at '/posts'
      Then status code is 200

    Scenario: status test dt
      Then status code is 200 at
        | /posts    |
        | /comments |
        | /albums   |
        | /users    |
      
    Scenario: body validation
      When I invoke get method at 'users' with id '1'
      Then street is 'Kulas Light'

    Scenario: body transform
      When I invoke get method at 'posts' with id '1'
      Then status code is 200
