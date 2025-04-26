package com.alunoapi.service

import com.alunoapi.dto.request.AlunoCreateDTO
import com.alunoapi.dto.response.AlunoResponseDTO
import com.alunoapi.exception.NotFoundException
import com.alunoapi.extensions.toResponseDTO
import com.alunoapi.model.Aluno
import com.alunoapi.repository.AlunoRepository
import org.springframework.stereotype.Service

@Service
class AlunoService(private val repository: AlunoRepository) {

    fun criar(dto: AlunoCreateDTO): AlunoResponseDTO {
        val aluno = Aluno(
            nome = dto.nome,
            idade = dto.idade,
            email = dto.email
        )
        return repository.save(aluno).toResponseDTO()
    }

    fun listar(): List<AlunoResponseDTO> {
        return repository.findAll().map { aluno ->
            AlunoResponseDTO(
                id = aluno.id!!,
                nome = aluno.nome,
                idade = aluno.idade,
                email = aluno.email,
                status = aluno.status.toString()
            )
        }
    }

    fun buscarPorId(id: Long): AlunoResponseDTO {
        val aluno = repository.findById(id)
            .orElseThrow { NotFoundException("Aluno com id $id não encontrado.") }

        return AlunoResponseDTO(
            id = aluno.id!!,
            nome = aluno.nome,
            idade = aluno.idade,
            email = aluno.email,
            status = aluno.status.toString()
        )
    }

    fun atualizar(id: Long, dto: AlunoCreateDTO): AlunoResponseDTO {
        val alunoExistente = repository.findById(id)
            .orElseThrow { NotFoundException("Aluno com id $id não encontrado.") }

        val alunoAtualizado = alunoExistente.copy(
            nome = dto.nome,
            idade = dto.idade,
            email = dto.email
            // Não inclua o status aqui a menos que você queira permitir sua atualização
        )

        val alunoSalvo = repository.save(alunoAtualizado).toResponseDTO()
        return AlunoResponseDTO(
            id = alunoSalvo.id!!,
            nome = alunoSalvo.nome,
            idade = alunoSalvo.idade,
            email = alunoSalvo.email,
            status = alunoSalvo.status.toString()
        )
    }

    fun deletar(id: Long) {
        if (!repository.existsById(id)) {
            throw NotFoundException("Aluno com id $id não encontrado.")
        }
        repository.deleteById(id)
    }
}