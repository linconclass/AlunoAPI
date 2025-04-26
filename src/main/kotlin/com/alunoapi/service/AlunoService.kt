package com.alunoapi.service

import com.alunoapi.model.Aluno
import com.alunoapi.repository.AlunoRepository
import org.springframework.stereotype.Service

@Service
class AlunoService(private val repository: AlunoRepository) {

    fun criar(aluno: Aluno): Aluno = repository.save(aluno)

    fun listar(): List<Aluno> = repository.findAll()

    fun buscarPorId(id: Long): Aluno =
        repository.findById(id).orElseThrow { NoSuchElementException("Aluno com id $id não encontrado.") }

    fun atualizar(id: Long, alunoAtualizado: Aluno): Aluno {
        val alunoExistente = buscarPorId(id)
        val alunoComDadosAtualizados = alunoExistente.copy(
            nome = alunoAtualizado.nome,
            idade = alunoAtualizado.idade
        )
        return repository.save(alunoComDadosAtualizados)
    }

    fun deletar(id: Long) = repository.deleteById(id)
}
