CREATE TABLE IF NOT EXISTS respuestas (
    id BIGINT AUTO_INCREMENT,
    mensaje VARCHAR(350) NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    autor_id BIGINT NOT NULL,
    topico_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (autor_id) REFERENCES usuarios(id),
    FOREIGN KEY (topico_id) REFERENCES topicos(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;