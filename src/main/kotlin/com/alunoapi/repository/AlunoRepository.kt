package com.alunoapi.repository

import com.alunoapi.model.Aluno
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AlunoRepository : JpaRepository<Aluno, Long>
