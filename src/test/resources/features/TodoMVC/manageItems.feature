Feature: Manage Todo Items

  Background: Entros en el sistema
    Given entro en el sistema

  Scenario: Al inciar el sistema la lista debe estar vacía
    Then la lista de elementos está vacía

  Scenario: Al introducir un elemento, debe quedar añadido a la lista
    When añado el elemento "Nuevo elemento" a lista
    Then la lista tiene 1 elemento
    And la lista contiene el elemento "Nuevo elemento"

  Scenario: Al introducir varios elementos seguidos la lista va creciendo
    When añado el elemento "Nuevo elemento" a lista
    And añado el elemento "Otro elemento" a lista
    Then la lista tiene 2 elemento
    And la lista contiene el elemento "Nuevo elemento"
    And la lista contiene el elemento "Otro elemento"

  Scenario: Cuando completo un elemento aparece en la lista de completados
    Given añado el elemento "Nuevo elemento" a lista
    When marco el elemento 1 como completado
    Then el elemento 1 queda marcado como completado
    And aparece en la lista de completados

  Scenario: Cuando elimino un elemento deja de aparecer en las listas
    Given añado el elemento "Nuevo elemento" a lista
    When  elimino el elemento 1
    Then el elemento "Nuevo elemento" deja de aparecer en las listas
