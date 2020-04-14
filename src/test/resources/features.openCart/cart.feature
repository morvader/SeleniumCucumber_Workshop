Feature: Añadir elementos al carrito de compra

  Background:
    Given Estoy en la pagina principal

  Scenario: Cuando busco un elemento y lo añado al carrito debe visualizarse en la vista de carrito
    When busco el elemento "iPhone"
    And añado el elemento "iPhone" al carrito
    Then el elemento "iPhone" se visualiza en la página resumen de carrito