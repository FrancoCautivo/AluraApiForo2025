-- Usuarios
INSERT INTO usuarios (nombre, email, contrasena, tipo) VALUES
('Admin', 'admin@mail.com', '$2a$10$Wz6skKlYrUVq9EN7n7i8X.nDPcf8uvLmHLWyPGd3koMaID6qUT3vK', 'ADMIN'),
('Usuario1', 'usuario1@mail.com', '$2a$10$Wz6skKlYrUVq9EN7n7i8X.nDPcf8uvLmHLWyPGd3koMaID6qUT3vK', 'USUARIO'),
('Usuario2', 'usuario2@mail.com', '$2a$10$Wz6skKlYrUVq9EN7n7i8X.nDPcf8uvLmHLWyPGd3koMaID6qUT3vK', 'USUARIO');

-- Cursos
INSERT INTO cursos (nombre, categoria) VALUES
('Java Spring Boot', 'Backend'),
('HTML y CSS', 'Frontend');

-- Tópicos
INSERT INTO topicos (titulo, mensaje, fecha_creacion, estado, autor_id, curso_id) VALUES
('Error al iniciar proyecto', 'No se conecta con la base de datos', NOW(), 'NO_RESPONDIDO', 2, 1),
('Duda sobre relaciones JPA', 'No me queda claro el uso de ManyToOne', NOW(), 'NO_RESPONDIDO', 3, 1);

-- Respuestas
INSERT INTO respuestas (mensaje, fecha_creacion, autor_id, topico_id) VALUES
('¿Revisaste la configuración de application.properties?', NOW(), 1, 1),
('Podrías revisar la documentación de JPA en relaciones bidireccionales', NOW(), 1, 2);