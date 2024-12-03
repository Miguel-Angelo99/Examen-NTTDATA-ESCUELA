@Airlines
Feature: API aerolíneas
  Como un usuario de la API de aerolíneas
  Quiero obtener la lista de todas las aerolíneas
  Para poder verificar los detalles de las aerolíneas disponibles

  @CP1
  Scenario: Obtener todas las aerolíneas exitosamente
    Given el actor establece el endpoint para obtener las aerolineas
    When el actor envia una solicitud GET
    Then el codigo de respuesta deberia ser 200

  @CP02
  Scenario Outline: Crear una aerolínea exitosamente
    Given el actor establece el endpoint POST para crear una aerolínea
    When envía una solicitud HTTP POST con los datos "<_id>", "<name>", "<country>", "<logo>", "<slogan>", "<head_quaters>", "<website>", "<established>"
    Then el codigo de respuesta deberia ser 200

    Examples:
      | _id | name            | country | logo      | slogan                    | head_quaters | website      | established |
      | 1   | Ramon Castilla  | Lima    | lima.png  | Miraflores ciudad amable | Miraflores   | flowers.com  | 1857        |
      | 3   | Alfredo Parodi  | Lima    | lima.png  | Centro financiero        | San Isidro   | isidro.pe    | 1931        |

  @CP03
  Scenario: Eliminar un pasajero exitosamente
    Given el actor establece el endpoint para eliminar un pasajero
    When el actor elimina el pasajero con ID "667ab79f7ad8fbf2544343d9"
    Then el codigo de respuesta deberia ser 200

  @CP04
Scenario: Actualizar el nombre de un pasajero exitosamente
    Given el actor establece el endpoint para actualizar un pasajero
    When el actor actualiza el nombre del pasajero con ID "667ab79f7ad8fbf2544343d9" a "Nuevo Nombre"
    Then el codigo de respuesta deberia ser 200