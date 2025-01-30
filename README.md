# Proyecto Factoría F5 🚀

Este es un proyecto desarrollado para la prueba técnica de Factoría F5. Se trata de una aplicación web construida con Java y Spring Boot que permite gestionar imágenes cargadas por los usuarios. Dichas imágenes se almacenan en un directorio local dentro del servidor y se cargan en la web para ser visualizadas. Además, pueden ser editadas y eliminadas, así como añadir nuevas imágenes.

## Alcance del proyecto

- Visualización de las imágenes junto a su título.
- Adición de nuevas imágenes, con su posterior visualización junto al resto.
- Edición del título y el archivo correspondiente a la imagen.
- Borrado de la imagen.

## Funcionalidades a añadir en el futuro

- Ampliación de las imágenes al hacer click sobre ellas mediante un modal.
- Opción de marcar imágenes como favoritas, añadiendo un campo nuevo a la base de datos y reflejándolo en el front mediante un emoticono.
- Implementación de seguridad y autenticación mediante Spring Security.

## Requisitos

- Java 21 o superior.
- Maven 3.6.0 o superior.
- MySQL para la base de datos (configurable en `application.properties`).

## Entornos recomendados

- Eclipse para leer el código y lanzar el proyecto.
- MySQL Workbench para gestionar la base de datos.

## Tecnologías

- **Spring Boot 3.x**
- **Spring Data JPA** para la gestión de la base de datos.
- **Spring Security** para la configuración de la seguridad.
- **Thymeleaf** como motor de plantillas.
- **MySQL** como base de datos relacional.
- **Lombok** para reducción de código repetitivo.
- **Spring Boot DevTools** para recarga automática en desarrollo.
- **Maven** para la gestión de dependencias y construcción del proyecto.
- **Apache Tomcat** como servidor embebido para el despliegue de la aplicación.
- **JUnit** para la ejecución de pruebas unitarias y de integración.

## Instalación

### 1. Clonar el repositorio

Ejecutar los siguientes comandos en la consola, en la ruta donde se desee situar el proyecto:

```sh
 git clone https://github.com/tu-usuario/jenniferDiez_factoriaF5.git
 cd jenniferDiez_factoriaF5
```

### 2. Importar el proyecto al IDE Eclipse

Ir a: `File > Import > General > Projects from Folder or Archive`

### 3. Configurar la base de datos en MySQL Workbench

Crear la base de datos con los datos especificados en `application.properties` o modificar este archivo para que coincida con los propios:

```properties
spring.datasource.url=jdbc:mysql://localhost/jenniferdiez_factoriaf5
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

Se debe crear un schema con nombre `jenniferdiez_factoriaf5`. Si se ha configurado correctamente, la base de datos se generará sola al lanzar el proyecto gracias a un pequeño script que inserta datos de prueba.

### 4. Lanzar el proyecto

1. Seleccionar `Project > Build Automatically` para la correcta sincronización de imágenes subidas.
2. En el explorador de archivos, acceder a `src/main/java > com.factoriaf5.jenniferDiez_factoriaF5`.
3. Click derecho sobre el archivo `JenniferDiezFactoriaF5Application.java` > `Run as… > Java Application`.

### 5. Acceder a la web

Abrir el navegador y acceder mediante la siguiente ruta:

```
http://localhost:3030/index
```

## Pruebas con JUnit

El proyecto ha sido desarrollado siguiendo un enfoque **TDD (Test-Driven Development)**, en el cual primero se han diseñado y escrito las pruebas unitarias antes de implementar la funcionalidad. Posteriormente, se han realizado revisiones y mejoras de código.

Los tests validan:

- Carga de imágenes.
- Edición y eliminación de imágenes.
- Conexión a la base de datos.

Para ejecutar los tests:

1. Click derecho sobre el archivo `JenniferDiezFactoriaF5Application.java`.
2. Seleccionar `Run as… > JUnit Test`.
