package com.alunoapi.controller

import com.alunoapi.dto.request.AlunoCreateDTO
import com.alunoapi.dto.request.AlunoResponseDTO
import com.alunoapi.service.AlunoService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/alunos")
@Tag(name = "Alunos", description = "Operações relacionadas a alunos")
class AlunoController(private val service: AlunoService) {

    @Operation(
        summary = "Criar aluno",
        description = "Registra um novo aluno no sistema"
    )
    @ApiResponses(
        ApiResponse(
            responseCode = "201",
            description = "Aluno criado com sucesso",
            content = [Content(
                mediaType = "application/json",
                schema = Schema(implementation = AlunoResponseDTO::class)
            )]
        ),
        ApiResponse(
            responseCode = "400",
            description = "Dados inválidos"
        )
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun criar(
        @RequestBody
        @Valid
        @Schema(example = "{\"nome\":\"João Silva\",\"idade\":25,\"email\":\"joao@email.com\"}")
        dto: AlunoCreateDTO
    ): com.alunoapi.dto.response.AlunoResponseDTO {
        return service.criar(dto)
    }

    @Operation(summary = "Listar alunos", description = "Retorna todos os alunos cadastrados")
    @GetMapping
    fun listar(): List<com.alunoapi.dto.response.AlunoResponseDTO> = service.listar()

    @Operation(summary = "Buscar aluno", description = "Retorna um aluno específico pelo ID")
    @ApiResponses(
        ApiResponse(
            responseCode = "200",
            description = "Aluno encontrado"
        ),
        ApiResponse(
            responseCode = "404",
            description = "Aluno não encontrado"
        )
    )
    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): com.alunoapi.dto.response.AlunoResponseDTO {
        return service.buscarPorId(id)
    }

    @Operation(summary = "Atualizar aluno", description = "Atualiza os dados de um aluno existente")
    @PutMapping("/{id}")
    fun atualizar(
        @PathVariable id: Long,
        @RequestBody @Valid dto: AlunoCreateDTO
    ): com.alunoapi.dto.response.AlunoResponseDTO {
        return service.atualizar(id, dto)
    }

    @Operation(summary = "Excluir aluno", description = "Remove um aluno do sistema")
    @ApiResponse(responseCode = "204", description = "Aluno removido com sucesso")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}