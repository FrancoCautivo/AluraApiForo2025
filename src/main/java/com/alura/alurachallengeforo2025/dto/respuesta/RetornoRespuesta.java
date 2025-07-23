package com.alura.alurachallengeforo2025.dto.respuesta;

import java.time.LocalDateTime;

public record RetornoRespuesta(
        Long id,
        String mensaje,
        String nombreAutor,
        Long idTopico,
        LocalDateTime fechaCreacion
) {}
