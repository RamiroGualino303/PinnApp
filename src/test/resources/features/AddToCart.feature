@AddToCart
Feature: Buscar y agregar un producto al carrito

  Rule: El usuario debe poder buscar y agregar un producto al carrito exitosamente

  Scenario: Buscar un producto y agregarlo al carrito exitosamente
    Given navego a la página de OpenCart
    When busco el producto iPhone
    And  Selecciono el producto
    And agrego el producto al carrito
    Then el producto debería aparecer en el carrito
