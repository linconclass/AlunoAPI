package com.alunoapi.dto.response

import com.alunoapi.model.Aluno
import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime

@Schema(description = "DTO para representação detalhada de um aluno na resposta da API")
data class AlunoDetalhadoDTO(
    @Schema(description = "ID único do aluno", example = "1")
    val id: Long,

    @Schema(description = "Nome completo do aluno", example = "João Silva")
    val nome: String,

    @Schema(description = "Idade do aluno", example = "25")
    val idade: Int,

    @Schema(description = "E-mail do aluno", example = "joao@email.com")
    val email: String,

    @Schema(description = "Status atual do aluno", example = "ATIVO")
    val status: String,

    @Schema(description = "Data de matrícula", example = "2023-10-25T10:30:00")
    val dataMatricula: LocalDateTime,

    @Schema(description = "Última atualização", example = "2023-10-30T15:45:00")
    val ultimaAtualizacao: LocalDateTime?
) {
    companion object {
        fun fromEntity(aluno: Aluno): AlunoDetalhadoDTO {
            return AlunoDetalhadoDTO(
                id = aluno.id!!,
                nome = aluno.nome,
                idade = aluno.idade,
                email = aluno.email,
                status = aluno.status.toString(),
                dataMatricula = aluno.dataMatricula,
                ultimaAtualizacao = aluno.ultimaAtualizacao
            )
        }
    }
}