# Simulador de apis.

## Descripción.
El objetivo de este proyecto es implementar un simulador que permita obtener respuestas similares a las de una API externa, la cual aún no ha sido implementada o que ha sido creada por otro equipo. Este simulador tiene como objetivo facilitar las pruebas y la integración, proporcionando datos simulados para escenarios de desarrollo y testing.

El enfoque principal del proyecto es aplicar los principios de Clean Architecture para garantizar un diseño limpio, modular y escalable. Además, se integrará una funcionalidad de IA que facilitará la creación y personalización de datos simulados de manera automática, ayudando a los equipos a acelerar el proceso de integración y desarrollo.

## Objetivos
* Implementar Clean Architecture para asegurar un código escalable y mantenible.
* Incorporar IA para la generación automática de datos simulados.
* Desarrollar pruebas unitarias para garantizar la calidad y confiabilidad del código.
* Facilitar la integración de nuevos servicios y datos con un sistema modular.

## Estructura de la Aplicación
La aplicación está dividida en varios módulos siguiendo los principios de Clean Architecture. Cada módulo tiene una responsabilidad clara y se comunica solo a través de interfaces bien definidas.

### Diagrama de flujo de la arquitectura

```plaintext
          +------------------------------------------------------+
          |    Capa de Infraestructure (Entry points)            |
          |    (Controllers, APIs)                               |
          |                                                      |
          |                                                      |
          |    +--------------------------------------------+    |
          |    |    Capa de Casos de Uso                    |    |
          |    |    (Application)                           |    |
          |    |                                            |    |
          |    |                                            |    |
          |    |    +----------------------------------+    |    |
          |    |    |    Capa de Dominio               |    |    |
          |    |    |    (Entities, Business Logic)    |    |    |
          |    |    +----------------------------------+    |    |
          |    |                                            |    | 
          |    |                                            |    |
          |    +--------------------------------------------+    |
          |                                                      |
          |    (Persistence, APIs, Adapters. etc.)               |                            
          |                                                      |
          +------------------------------------------------------+
```

### Descripción de capas
1. **Boot:** El punto de entrada del proyecto, donde se configura y ejecuta la aplicación.
2. **Application:** Aquí se gestionan las reglas de negocio y orquestación. Se encargan de manejar las peticiones que provienen del usuario o de sistemas externos.
3. **Domain:** Contiene las entidades del dominio, las cuales son independientes de cualquier tecnología o detalle de implementación.
4. **Infrastructure:** Proporciona la implementación concreta de las interfaces definidas en la capa de dominio. Aquí se encuentran las integraciones con bases de datos, sistemas externos y otros servicios.


### Cómo Ejecutar el Proyecto

```
mvn clean install
mvn spring-boot:run
```
