package com.alura.alurachallengeforo2025.controller;

import com.alura.alurachallengeforo2025.dto.security.DatosJWTToken;
import com.alura.alurachallengeforo2025.dto.usuario.AutenticacionUsuario;
import com.alura.alurachallengeforo2025.modelo.Usuario;
import com.alura.alurachallengeforo2025.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<DatosJWTToken> autenticar(@RequestBody @Valid AutenticacionUsuario datos) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(datos.email(), datos.contrasena());
        Authentication autenticado = authenticationManager.authenticate(authToken);

        Usuario usuario = (Usuario) autenticado.getPrincipal();
        String jwt = tokenService.generarToken(usuario);

        return ResponseEntity.ok(new DatosJWTToken(jwt));
    }
}
