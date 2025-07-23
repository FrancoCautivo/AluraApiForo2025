package com.alura.alurachallengeforo2025.dto.respuesta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegistroRespuesta(
        @NotBlank String mensaje,
        @NotNull Long idTopico,
        @NotNull Long idAutor
) {}
