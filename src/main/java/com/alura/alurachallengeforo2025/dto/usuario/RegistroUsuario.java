package com.alura.alurachallengeforo2025.dto.usuario;

import com.alura.alurachallengeforo2025.modelo.Tipo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegistroUsuario(
        @NotBlank String nombre,
        @Email String email,
        @NotBlank String contrasena,
        Tipo tipo
) {}
