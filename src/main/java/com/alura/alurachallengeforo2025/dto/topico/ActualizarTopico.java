package com.alura.alurachallengeforo2025.dto.topico;

import com.alura.alurachallengeforo2025.modelo.Estado;

public record ActualizarTopico(
        String titulo,
        String mensaje,
        Estado estado
) {}
