# AlunoAPI 🎓

API RESTful para gerenciamento de alunos desenvolvida com Spring Boot e Kotlin.

## 📋 Funcionalidades

- CRUD completo de alunos
- Banco de dados em memória H2
- API documentada com endpoints REST
- Validações básicas de dados

## 🛠️ Tecnologias

- **Linguagem**: Kotlin 1.9
- **Framework**: Spring Boot 3.2
- **Banco de Dados**: H2 (em memória)
- **Build**: Gradle (Kotlin DSL)

## ⚙️ Configuração Rápida

```bash
git clone https://github.com/seu-usuario/alunoapi.git
cd alunoapi
./gradlew bootRun
```

# 🌐 **Endpoints Principais**

Método	Endpoint	Descrição

POST	/alunos	Cria um novo aluno
GET	/alunos	Lista todos os alunos
GET	/alunos/{id}	Obtém um aluno específico
PUT	/alunos/{id}	Atualiza um aluno
DELETE	/alunos/{id}	Remove um aluno

# 🧭 **Navegação**

Acesse o console do H2 (JDBC URL: jdbc:h2:mem:alunodatabase, User: sa)

Documentação técnica detalhada (configurações do Spring Boot e Gradle)

# 📌 **Roadmap**

Validações avançadas

Tratamento global de erros

Documentação com Swagger