package com.alunoapi.extensions

import com.alunoapi.dto.response.AlunoResponseDTO
import com.alunoapi.model.Aluno

fun Aluno.toResponseDTO(): AlunoResponseDTO = AlunoResponseDTO(
    id = this.id!!,
    nome = this.nome,
    idade = this.idade,
    email = this.email,
    status = this.status.toString()
)