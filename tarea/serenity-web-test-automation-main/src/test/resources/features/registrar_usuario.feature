Feature: Registrar un usuario

  @RegistrarUsuario @HappyPath
  Scenario Outline: Registrar de manera existosa a un usuario con credenciales validas
    Given el usuario esta en la pagina de inicio
    And selecciona el boton de registro
    And ingresa un nombre de usuario "<username>" y contrasenia "<password>"
    When selecciona el boton registrar
    Then se realiza el registro de manera exitosa

    Examples:
      | username    | password |
      | bhunji      | pass123  |


  @Login @AgregarAlCarrito
  Scenario Outline: Iniciar sesión, seleccionar un producto y agregarlo al carrito
    Given el usuario esta en la pagina de inicio
    And selecciona el boton de login
    And el usuario inicia sesión con nombre de usuario "<username>" y contraseña "<password>"
    When selecciona el boton login
    Then se realiza el registro de manera exitosa

    Examples:
      | username    | password |
      | bhunji      | pass123  |

  Scenario Outline: Seleccionar un producto y agregarlo al carrito
    Given el usuario esta en la pagina de inicio
    When selecciona el producto y lo agrega al carrito "<productName>"
    Then se confirma que el producto fue agregado al carrito

    Examples:
      | productName   |
      | Sony vaio i5  |


