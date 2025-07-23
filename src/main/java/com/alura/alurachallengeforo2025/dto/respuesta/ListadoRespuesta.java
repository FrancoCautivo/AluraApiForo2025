package com.alura.alurachallengeforo2025.dto.respuesta;

import java.time.LocalDateTime;

public record ListadoRespuesta(
        Long id,
        String mensaje,
        String nombreAutor,
        LocalDateTime fechaCreacion
) {}
