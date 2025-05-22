package com.tech4me.aluno.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.tech4me.aluno.model.Aluno;

public interface AlunoRepository extends MongoRepository<Aluno, String> {
}
