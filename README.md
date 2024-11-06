# API REST de Marcas y Modelos de Coches
## Descripción 
Esta API REST, desarrollada con Spring Boot, permite realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre marcas de coches y sus modelos asociados. Utiliza MySQL como base de datos y Swagger para generar una documentación interactiva de la API.

## Tecnologías Utilizadas
* **Spring Boot:** Framework Java para crear aplicaciones independientes.
* **Spring Data JPA:** Para interactuar con la base de datos MySQL.
* **MySQL:** Base de datos relacional.
* **Swagger:** Para generar documentación interactiva de la API.
* **Maven:** Gestor de dependencias.

## Funcionalidades
### Marcas:
* **Crear nuevas marcas.**
* **Listar todas las marcas.**
* **Obtener una marca por ID.**
* **Actualizar una marca.**
* **Eliminar una marca.**
### Modelos:
* **Crear nuevos modelos asociados a una marca.**
* **Listar todos los modelos de una marca.**
* **Obtener un modelo por ID.**
* **Actualizar un modelo.**
* **Eliminar un modelo.**

## Configuración
* **Base de datos:** Configura los detalles de conexión a MySQL en el archivo application.properties.
* **Entidades:** Define las entidades Marca y Modelo con sus atributos y relaciones.
* **Repositorios:** Crea repositorios para interactuar con la base de datos utilizando Spring Data JPA.
* **Servicios:** Implementa la lógica de negocio en servicios.
* **Controladores:** Exponen los endpoints REST utilizando anotaciones de Spring MVC.
* **Swagger:** Configura Swagger para generar la documentación interactiva de la API.

## Endpoints (Ejemplo)
```bash
# Marcas
GET api/v1/brand/findAll         # Obtener todas las marcas
POST api/v1/brand/save           # Crear una nueva marca
GET api/v1/brand/find/{id}       # Obtener una marca por ID
PUT api/v1/brand/update/{id}     # Actualizar una marca
DELETE api/v1/brand/delete/{id}  # Eliminar una marca

# Modelos
GET api/v1/model/findAll         # Obtener todos los modelos
POST api/v1/model/save           # Crear un nuevo modelo para una marca
GET api/v1/model/find/{id}       # Obtener un modelo por ID
PUT api/v1/model/update/{id}     # Actualizar un modelo
DELETE api/v1/model/delete/{id}  # Eliminar un modelo
```
## Documentación Swagger
* **Para acceder a la documentación interactiva de la API, abre tu navegador y ve a: http://localhost:8080/swagger-ui.html**
