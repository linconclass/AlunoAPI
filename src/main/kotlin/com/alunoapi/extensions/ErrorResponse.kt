package com.alunoapi.extensions

import java.time.LocalDateTime

data class ErrorResponse(
    val status: Int,
    val message: String?,
    val timestamp: LocalDateTime = LocalDateTime.now()
)