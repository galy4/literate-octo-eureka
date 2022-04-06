Feature: datatable examples

  Scenario: ex1
    Given print some numbers
      | 17.213      |
      | 15.31       |
      | 10.2        |
      | 11.12546456 |


  Scenario: ex2
    Then y divides x
      | 10 | 5 |
      | 4  | 3 |
      | 6  | 3 |
      | 2  | 2 |

  Scenario: ex3
    Then y divides x map
      | 10 | 5 |
      | 6  | 3 |
      | 2  | 2 |

  Scenario: ex4
    Then y divides x title
      | x  | y |
      | 10 | 5 |
      | 6  | 3 |
      | 2  | 2 |

    Scenario: ex 5
      Then y divides x table
        | x  | y |
        | 10 | 5 |
        | 6  | 3 |
        | 2  | 2 |