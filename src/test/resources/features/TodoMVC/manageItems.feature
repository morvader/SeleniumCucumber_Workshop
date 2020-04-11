Feature: Manage Todo Items

  Scenario: Al inciar el sistema la lista debe estar vacía
    Given entro en el sistema
    Then la lista de elementos está vacía

  Scenario: Al introducir un elemento, debe quedar añadido a la lista
    Given entro en el sistema
    When añado un elemento a lista
    Then la lista tiene 1 elemento
