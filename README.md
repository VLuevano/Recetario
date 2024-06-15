# API Recetario

## Descripción del Proyecto

El proyecto Recetario es una aplicación desarrollada en Java utilizando Spring Boot que permite la gestión de recetas de cocina. La aplicación incluye funcionalidades para crear, leer, actualizar y eliminar recetas, así como manejar la validación y los errores asociados a estas operaciones. Además, se integra con una base de datos MongoDB para el almacenamiento de datos.

## Estructura del Proyecto

El proyecto está organizado en los siguientes paquetes:

- **`uv.mx.javc.Recetario.config`**: Configuración de la aplicación y manejo de excepciones.
- **`uv.mx.javc.Recetario.controller`**: Controladores REST para la gestión de recetas.
- **`uv.mx.javc.Recetario.dto`**: Clases de transferencia de datos (DTO) para las recetas y los errores.
- **`uv.mx.javc.Recetario.mapper`**: Interfaces para el mapeo de objetos entre DTOs y entidades.
- **`uv.mx.javc.Recetario.model`**: Entidades del modelo de datos.
- **`uv.mx.javc.Recetario.repository`**: Repositorios para el acceso a la base de datos.
- **`uv.mx.javc.Recetario.service`**: Servicios de negocio para la gestión de recetas.

## Clases Principales

A continuación se describen las clases principales del proyecto

## Configuración y Manejo de Excepciones

#### `ExceptionAdvice`
Maneja las excepciones de validación de argumentos no válidos en los controladores.

#### `WebConfig`
Configura el convertidor de mensajes HTTP para soportar XML.

## Controlador

#### `RecipeController`
Controlador REST para la gestión de recetas.

## DTOs (Data Transfer Objects)

#### `CreateRecipeDTO`
DTO para la creación de recetas con validaciones.

#### `RecipeDTO`
DTO para representar una receta.

#### `ErrorDTO`
DTO para representar errores.

## Mapper

#### `RecipeMapper`
Interface para mapear entre DTOs y entidades de recetas.

## Modelo y Repositorio

#### `Recipe`
Entidad que representa una receta en la base de datos.

#### `RecipeRepository`
Repositorio para el acceso a la base de datos MongoDB.

## Configuración de Base de Datos

### Archivo `.env`
Configuración de las credenciales y la base de datos MongoDB.

### Archivo `build.gradle`

Configuración de Gradle para el proyecto.
Incluye las dependencias necesarias para la construcción del proyecto.

## Ejecución de Pruebas

El proyecto incluye pruebas unitarias para el controlador `RecipeController` utilizando JUnit 5 y Mockito para simular el comportamiento del servicio `RecipeService`.

#### `RecipeControllerTest`

Este archivo de prueba valida el comportamiento del `RecipeController` en varias situaciones:

- **`testGetAll`**: Verifica que el método `getAll()` del controlador retorne la lista correcta de recetas.
  
- **`testSave`**: Asegura que el método `save()` del controlador guarde correctamente una nueva receta y devuelva los datos esperados.

- **`testUpdate`**: Confirma que el método `update()` del controlador actualice adecuadamente una receta existente y retorne los datos actualizados.

- **`testDelete`**: Comprueba que el método `delete()` del controlador elimine una receta de acuerdo a su identificador y devuelva el resultado esperado.

Las pruebas validan tanto el comportamiento correcto de los métodos del controlador como la interacción adecuada con el servicio subyacente, asegurando así el correcto funcionamiento de las operaciones CRUD para las recetas.
