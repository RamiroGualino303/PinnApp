@RemoveFromCart
Feature: Gestión de productos en el carrito de compras

  Rule: El usuario debe poder buscar, agregar y eliminar productos del carrito de manera exitosa

  Scenario: Agregar y eliminar productos del carrito
    Given que estoy en la página principal de OpenCart
    When busco el producto Iphone
    And agrego el iphone al carrito
    And busco el producto Laptop
    And agrego Laptops al carrito
    And verifico que ambos productos estén en el carrito
    And elimino uno de los productos del carrito
    Then el producto eliminado no debería estar en el carrito

