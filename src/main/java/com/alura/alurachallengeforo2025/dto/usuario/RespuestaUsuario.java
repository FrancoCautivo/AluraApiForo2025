package com.alura.alurachallengeforo2025.dto.usuario;

import com.alura.alurachallengeforo2025.modelo.Tipo;

public record RespuestaUsuario(
        Long id,
        String nombre,
        String email,
        Tipo tipo
) {}
