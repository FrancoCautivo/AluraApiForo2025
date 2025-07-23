package com.alura.alurachallengeforo2025.dto.topico;

import com.alura.alurachallengeforo2025.modelo.Estado;

import java.time.LocalDateTime;

public record RespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Estado estado,
        String nombreAutor,
        String nombreCurso
) {}
