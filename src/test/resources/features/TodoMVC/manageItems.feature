Feature: Manage Todo Items

  Background: Entros en el sistema
    Given entro en el sistema

  Scenario: Al inciar el sistema la lista debe estar vacía
    Then la lista de elementos está vacía

  Scenario: Al introducir un elemento, debe quedar añadido a la lista
    When añado un elemento a lista
    Then la lista tiene 1 elemento

  Scenario: Al introducir varios elementos seguidos la lista va creciendo
    When añado un elemento a lista
    And añado un elemento a lista
    Then la lista tiene 2 elemento

  Scenario: Cuando completo un elemento aparece en la lista de completados
    When añado un elemento a lista
    And marco el elemento 1 como completado
    Then el elemento 1 queda marcado como completado
    And aparece en la lista de completados