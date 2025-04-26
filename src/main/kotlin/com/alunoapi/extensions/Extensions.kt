package com.alunoapi.extensions

import com.alunoapi.dto.request.AlunoCreateDTO
import com.alunoapi.dto.request.AlunoResponseDTO
import com.alunoapi.model.Aluno

class Extensions {
    // Extensions.kt
    fun AlunoCreateDTO.toEntity(): Aluno = Aluno(
        nome = this.nome,
        idade = this.idade,
        email = this.email
    )

    fun Aluno.toResponseDTO(): AlunoResponseDTO {
        val alunoResponseDTO = AlunoResponseDTO(
            id = this.id!!,
            nome = this.nome,
            idade = this.idade,
            email = this.email,
            status = this.status.toString()
        )
        return alunoResponseDTO
    }
}