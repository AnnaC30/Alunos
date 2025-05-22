package com.tech4me.aluno.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.tech4me.aluno.dto.AlunoDTO;
import com.tech4me.aluno.model.Aluno;
import com.tech4me.aluno.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @GetMapping
    public ResponseEntity<List<AlunoDTO>> obterTodos() {
        var alunos = service.obterTodos()
                            .stream()
                            .map(AlunoDTO::new)
                            .collect(Collectors.toList());
        return ResponseEntity.ok(alunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDTO> obterPorId(@PathVariable String id) {
        Optional<Aluno> aluno = service.obterPorId(id);
        return aluno.map(a -> ResponseEntity.ok(new AlunoDTO(a)))
                    .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AlunoDTO> cadastrar(@Valid @RequestBody Aluno aluno) {
        var salvo = service.cadastrar(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(new AlunoDTO(salvo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoDTO> atualizar(@PathVariable String id, @Valid @RequestBody Aluno aluno) {
        var atualizado = service.atualizar(id, aluno);
        return atualizado.map(a -> ResponseEntity.ok(new AlunoDTO(a)))
                         .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable String id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
