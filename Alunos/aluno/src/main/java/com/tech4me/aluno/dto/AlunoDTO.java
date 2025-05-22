package com.tech4me.aluno.dto;

import com.tech4me.aluno.model.Aluno;

public class AlunoDTO {
    private String id;
    private String nome;
    private Double nota;

    public AlunoDTO(Aluno aluno) {
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.nota = aluno.getNota();
    }

    // Getters
    public String getId() { return id; }
    public String getNome() { return nome; }
    public Double getNota() { return nota; }
}
