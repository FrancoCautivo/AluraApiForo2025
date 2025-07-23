package com.alura.alurachallengeforo2025.dto.usuario;

import com.alura.alurachallengeforo2025.modelo.Tipo;

public record ActualizarUsuario(
        String nombre,
        String contrasena,
        Tipo tipo
) {}
