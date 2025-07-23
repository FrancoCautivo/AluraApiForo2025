package com.alura.alurachallengeforo2025.dto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AutenticacionUsuario(
        @Email String email,
        @NotBlank String contrasena
) {}
