*Ejercicio técnico - API de Productos
- API REST desarrollada con Java y Java SpringBoot para administrar productos
- con una estructura basíca de un backend, persistencia de datos y validaciones para los endpoints.

* Tecnologías utilizadas
- Java
- Spring Boot
- Spring Data JPA
- Base de datos H2
- Maven

*¿Cómo ejecutar el proyecto?

1. Clona el repositorio
2. Abre el proyecto en tu IDE
3. Ejecuta la clase principal `ProductsApplication.java`
4. La API estará disponible en `http://localhost:8080`

*Endpoints GET, POST.
- POST Crear productos
http://localhost:8080/products

- Ejemplos
{
    "name": "PS5",
    "price": 9000
}
{ 
    "name": "XBOX ONE", 
    "price": 8500 
}
{ 
    "name": "Mando PS5", 
    "price": 1300 
}
{ 
    "name": "Auriculares", 
    "price": 300
}

- GET Obtener todos los productos
http://localhost:8080/products
- GET Obtener por id
http://localhost:8080/products/1
- GET Filtrar
http://localhost:8080/products/filter?maxPrice=1000

* Validaciones
`name` no puede estar vacío
`price` debe ser mayor a 0
`price` no puede ser mayor a 10,000