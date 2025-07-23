package com.alura.alurachallengeforo2025.controller;

import com.alura.alurachallengeforo2025.dto.usuario.*;
import com.alura.alurachallengeforo2025.modelo.Usuario;
import com.alura.alurachallengeforo2025.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<RespuestaUsuarioId> registrar(@RequestBody @Valid RegistroUsuario datos) {
        String passCifrada = passwordEncoder.encode(datos.contrasena());
        Usuario usuario = Usuario.builder()
                .nombre(datos.nombre())
                .email(datos.email())
                .contrasena(passCifrada)
                .tipo(datos.tipo())
                .build();

        usuarioRepository.save(usuario);
        return ResponseEntity.ok(new RespuestaUsuarioId(usuario.getId()));
    }

    @GetMapping
    public ResponseEntity<List<ListadoUsuario>> listar() {
        var lista = usuarioRepository.findAll().stream()
                .map(u -> new ListadoUsuario(u.getId(), u.getNombre(), u.getEmail(), u.getTipo()))
                .toList();

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespuestaUsuario> detalle(@PathVariable Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(new RespuestaUsuario(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getTipo()
        ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizar(@PathVariable Long id, @RequestBody ActualizarUsuario datos) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();

        if (datos.nombre() != null) usuario.setNombre(datos.nombre());
        if (datos.contrasena() != null) usuario.setContrasena(passwordEncoder.encode(datos.contrasena()));
        if (datos.tipo() != null) usuario.setTipo(datos.tipo());

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
