package com.alura.alurachallengeforo2025.controller;

import com.alura.alurachallengeforo2025.dto.respuesta.*;
import com.alura.alurachallengeforo2025.modelo.*;
import com.alura.alurachallengeforo2025.repository.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/respuesta")
public class RespuestaController {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<RetornoRespuestaId> registrar(@RequestBody @Valid RegistroRespuesta datos) {
        Usuario autor = usuarioRepository.findById(datos.idAutor()).orElseThrow();
        Topico topico = topicoRepository.findById(datos.idTopico()).orElseThrow();

        Respuesta respuesta = Respuesta.builder()
                .mensaje(datos.mensaje())
                .fechaCreacion(LocalDateTime.now())
                .autor(autor)
                .topico(topico)
                .build();

        respuestaRepository.save(respuesta);
        return ResponseEntity.ok(new RetornoRespuestaId(respuesta.getId()));
    }

    @GetMapping
    public ResponseEntity<List<ListadoRespuesta>> listar() {
        var lista = respuestaRepository.findAll().stream()
                .map(r -> new ListadoRespuesta(r.getId(), r.getMensaje(), r.getAutor().getNombre(), r.getFechaCreacion()))
                .toList();
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizar(@PathVariable Long id, @RequestBody ActualizarRespuesta datos) {
        Respuesta respuesta = respuestaRepository.findById(id).orElseThrow();
        if (datos.mensaje() != null) respuesta.setMensaje(datos.mensaje());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        respuestaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
