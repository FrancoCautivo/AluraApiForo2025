package com.alura.alurachallengeforo2025.controller;

import com.alura.alurachallengeforo2025.dto.topico.*;
import com.alura.alurachallengeforo2025.modelo.*;
import com.alura.alurachallengeforo2025.repository.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/topico")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public ResponseEntity<RespuestaTopicoId> registrar(@RequestBody @Valid RegistroTopico datos) {
        Usuario autor = usuarioRepository.findById(datos.idAutor()).orElseThrow();
        Curso curso = cursoRepository.findById(datos.idCurso()).orElseThrow();

        Topico topico = Topico.builder()
                .titulo(datos.titulo())
                .mensaje(datos.mensaje())
                .fechaCreacion(LocalDateTime.now())
                .estado(Estado.NO_RESPONDIDO)
                .autor(autor)
                .curso(curso)
                .build();

        topicoRepository.save(topico);
        return ResponseEntity.ok(new RespuestaTopicoId(topico.getId()));
    }

    @GetMapping
    public ResponseEntity<List<ListadoTopico>> listar() {
        var lista = topicoRepository.findAll().stream()
                .map(t -> new ListadoTopico(t.getId(), t.getTitulo(), t.getMensaje(), t.getFechaCreacion()))
                .toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespuestaTopico> detalle(@PathVariable Long id) {
        Topico topico = topicoRepository.findById(id).orElseThrow();

        return ResponseEntity.ok(new RespuestaTopico(
                topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getFechaCreacion(), topico.getEstado(),
                topico.getAutor().getNombre(), topico.getCurso().getNombre()
        ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RespuestaTopicoId> actualizar(@PathVariable Long id, @RequestBody ActualizarTopico datos) {
        Topico topico = topicoRepository.findById(id).orElseThrow();

        if (datos.titulo() != null) topico.setTitulo(datos.titulo());
        if (datos.mensaje() != null) topico.setMensaje(datos.mensaje());
        if (datos.estado() != null) topico.setEstado(datos.estado());

        return ResponseEntity.ok(new RespuestaTopicoId(topico.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
