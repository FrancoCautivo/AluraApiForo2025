# Alura API Foro 2025

Proyecto de backend desarrollado en **Java con Spring Boot** como parte del programa de formación educativa de Alura Latam. Esta API REST simula un foro de discusión donde los usuarios pueden crear tópicos, agregar respuestas, y autenticar su identidad mediante JWT. Se trabajó siguiendo buenas prácticas de arquitectura, principios SOLID y patrones MVC.

---

## 🚀 Funcionalidades principales

- ✅ Registro y autenticación de usuarios mediante JWT
- ✅ CRUD completo de Tópicos
- ✅ CRUD completo de Respuestas
- ✅ Asociación de usuarios y cursos
- ✅ Seguridad con Spring Security + JWT
- ✅ Persistencia en MySQL usando Spring Data JPA
- ✅ Migraciones automáticas con Flyway
- ✅ Documentación Swagger UI disponible
- ✅ Estructura organizada en capas (`controller`, `dto`, `modelo`, `repository`, `security`, etc.)

---

## 🛠️ Tecnologías utilizadas

- Java 21  
- Spring Boot 3.5.x  
- Spring Security  
- Spring Data JPA  
- Spring Validation  
- Flyway  
- MySQL  
- Swagger (Springdoc OpenAPI)  
- JWT (Auth0 Java JWT)  
- Maven  

---

## 🗂️ Estructura del proyecto

```
alurachallengeforo2025/
├── src/
│   ├── main/
│   │   ├── java/com/alura/alurachallengeforo2025/
│   │   │   ├── controller/
│   │   │   │   ├── AutenticacionController.java
│   │   │   │   ├── RespuestaController.java
│   │   │   │   ├── TopicoController.java
│   │   │   │   └── UsuarioController.java
│   │   │   ├── dto/
│   │   │   │   ├── curso/
│   │   │   │   │   └── RespuestaCurso.java
│   │   │   │   ├── respuesta/
│   │   │   │   ├── security/
│   │   │   │   ├── topico/
│   │   │   │   └── usuario/
│   │   │   ├── errores/
│   │   │   │   └── TratadorDeErrores.java
│   │   │   ├── modelo/
│   │   │   │   ├── Curso.java
│   │   │   │   ├── Estado.java
│   │   │   │   ├── Respuesta.java
│   │   │   │   ├── Tipo.java
│   │   │   │   ├── Topico.java
│   │   │   │   └── Usuario.java
│   │   │   ├── repository/
│   │   │   │   ├── CursoRepository.java
│   │   │   │   ├── RespuestaRepository.java
│   │   │   │   ├── TopicoRepository.java
│   │   │   │   └── UsuarioRepository.java
│   │   │   ├── security/
│   │   │   │   ├── AutenticacionService.java
│   │   │   │   ├── SecurityConfigurations.java
│   │   │   │   ├── SecurityFilter.java
│   │   │   │   └── TokenService.java
│   │   │   └── Alurachallengeforo2025Application.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── db/migration/
│   │           ├── V1__create-table-usuarios.sql
│   │           ├── V2__create-table-cursos.sql
│   │           ├── V3__create-table-topicos.sql
│   │           ├── V4__create-table-respuestas.sql
│   │           └── V5__insert-datos.sql
```

## 🧪 Cómo probar los endpoints

### 📘 Swagger UI

Una vez el proyecto esté corriendo, visita:

```
http://localhost:8080/swagger-ui.html
```

Desde ahí puedes:
- Autenticarte usando JWT
- Probar todos los endpoints (crear, listar, editar, eliminar)
- Ver documentación en tiempo real

### 🧪 Insomnia / Postman

También puedes probar todos los endpoints usando herramientas como:
- [Insomnia](https://insomnia.rest)
- [Postman](https://www.postman.com/)

Incluye un archivo `.http` con ejemplos listos para importar.

⚠️ Recuerda autenticarte primero en `/auth/login` para obtener el token JWT y luego usarlo en los headers de las demás solicitudes:

```
Authorization: Bearer TU_TOKEN_AQUI
```

---

## 📚 Propósito del proyecto

Este proyecto fue creado con fines **educativos** y de **aprendizaje práctico** en el contexto del curso de backend con Java Spring en Alura Latam.  
Está disponible de forma abierta para ser **complementado, actualizado y ampliado libremente**.

---

## 👨‍💻 Autor

Francisco Cautivo  
📧 [francisco.cautivo@gmail.com](mailto:francisco.cautivo@gmail.com)  
🌐 [github.com/FrancoCautivo](https://github.com/FrancoCautivo)

---

