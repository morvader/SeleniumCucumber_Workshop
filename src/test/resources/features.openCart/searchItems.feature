Feature: Buscar elementos en la página principal

  Background:
    Given Estoy en la pagina principal

  Scenario Outline: Cuando busco un elemento debe mostrarte la lista de elementos que cumplen los criterios
    When busco el elemento "<item>"
    Then el elemento "<item>" aparece en los resultados con el precio "<precio>"
    Examples:
      | item        | precio    |
      | iPhone      | $123.20   |
      | MacBook Pro | $2,000.00 |