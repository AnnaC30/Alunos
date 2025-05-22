package com.tech4me.aluno.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.*;

@Document("alunos")
public class Aluno {
    @Id
    private String id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotNull(message = "Nota é obrigatória")
    @Min(value = 0, message = "Nota mínima é 0")
    @Max(value = 10, message = "Nota máxima é 10")
    private Double nota;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Double getNota() { return nota; }
    public void setNota(Double nota) { this.nota = nota; }
}
