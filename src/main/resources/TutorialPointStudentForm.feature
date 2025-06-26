Feature: TutorialPointStudentForm

  Scenario: Student form - gender radiobutton check
    Given Uzivatel je na stranke tutorial point student form
    When Uzivatel zada svoje meno "Jozef"
    And Uzivatel zada svoj email "email@email.sk"
    And Uzivatel klikne na pohlavie "male"
    Then Radiobutton male je zasrtnuty
    When Uzivatel klikne na pohlavie "female"
    #Then Radiobutton male je odsktnuty

  Scenario: Student form - ukazka
    Given Uzivatel je na stranke tutorial point student form
    When Uzivatel zada svoje meno "Tereza"
    And Uzivatel klikne na pohlavie "female"

    Scenario Outline: Student form viacej dat
      Given Uzivatel je na stranke tutorial point student form
      When Uzivatel zada svoje meno "<meno>"
      And Uzivatel klikne na pohlavie "<pohlavie>"
      Examples:
      | meno  | pohlavie |
      | Petra | female   |
      | Ivan  | male     |
      | Jana  | female   |
      | Rasto | male     |
