package com.alunoapi.controller

import com.alunoapi.model.Aluno
import com.alunoapi.service.AlunoService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/alunos")
class AlunoController(private val service: AlunoService) {

    @PostMapping
    fun criar(@RequestBody aluno: Aluno): Aluno = service.criar(aluno)

    @GetMapping
    fun listar(): List<Aluno> = service.listar()

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): Aluno = service.buscarPorId(id)

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody aluno: Aluno): Aluno =
        service.atualizar(id, aluno)

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long) = service.deletar(id)
}
