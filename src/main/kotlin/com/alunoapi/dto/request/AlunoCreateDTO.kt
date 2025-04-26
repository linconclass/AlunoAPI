package com.alunoapi.dto.request

import com.alunoapi.model.StatusAluno
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank

data class AlunoCreateDTO(
    @field:NotBlank(message = "Nome é obrigatório")
    val nome: String,

    @field:Min(6) @field:Max(100)
    val idade: Int,

    @field:Email
    val email: String,

    val status: StatusAluno? = null  // Opcional
)
