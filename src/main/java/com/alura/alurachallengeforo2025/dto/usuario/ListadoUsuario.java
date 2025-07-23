package com.alura.alurachallengeforo2025.dto.usuario;

import com.alura.alurachallengeforo2025.modelo.Tipo;

public record ListadoUsuario(
        Long id,
        String nombre,
        String email,
        Tipo tipo
) {}
