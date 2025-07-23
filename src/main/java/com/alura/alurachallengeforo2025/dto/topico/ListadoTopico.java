package com.alura.alurachallengeforo2025.dto.topico;

import java.time.LocalDateTime;

public record ListadoTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion
) {}
