package com.alunoapi.dto.response

import com.alunoapi.model.Aluno
import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "DTO para representação básica de um aluno na resposta da API")
data class AlunoResponseDTO(
    @Schema(description = "ID único do aluno", example = "1")
    val id: Long,

    @Schema(description = "Nome completo do aluno", example = "João Silva")
    val nome: String,

    @Schema(description = "Idade do aluno", example = "25")
    val idade: Int,

    @Schema(description = "E-mail do aluno", example = "joao@email.com")
    val email: String,

    @Schema(description = "Status atual do aluno", example = "ATIVO")
    val status: String
) {
    companion object {
        fun fromEntity(aluno: Aluno): AlunoResponseDTO {
            return AlunoResponseDTO(
                id = aluno.id!!,
                nome = aluno.nome,
                idade = aluno.idade,
                email = aluno.email,
                status = aluno.status.toString()
            )
        }
    }
}