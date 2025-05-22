package com.tech4me.aluno.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech4me.aluno.model.Aluno;
import com.tech4me.aluno.repository.AlunoRepository;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repo;

    public List<Aluno> obterTodos() {
        return repo.findAll();
    }

    public Optional<Aluno> obterPorId(String id) {
        return repo.findById(id);
    }

    public Aluno cadastrar(Aluno aluno) {
        return repo.save(aluno);
    }

    public Optional<Aluno> atualizar(String id, Aluno aluno) {
        return repo.findById(id).map(a -> {
            a.setNome(aluno.getNome());
            a.setNota(aluno.getNota());
            return repo.save(a);
        });
    }

    public void excluir(String id) {
        repo.deleteById(id);
    }
}
