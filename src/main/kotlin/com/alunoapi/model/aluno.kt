package com.alunoapi.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Aluno(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    var nome: String,
    var idade: Int,

    @Column(unique = true)
    var email: String,

    var dataMatricula: LocalDateTime = LocalDateTime.now(),

    @Enumerated(EnumType.STRING)
    var status: StatusAluno = StatusAluno.ATIVO  // Adicione esta linha se não existir
) {
    val ultimaAtualizacao: LocalDateTime?
        get() {
            TODO()
        }
}

enum class StatusAluno {
    ATIVO, INATIVO, FORMADO, TRANCADO
}