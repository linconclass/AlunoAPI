package com.alunoapi.dto.request

data class AlunoResponseDTO(
    val id: Long,
    val nome: String,
    val idade: Int,
    val email: String,
    val status: String
)