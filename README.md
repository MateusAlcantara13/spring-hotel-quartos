# Hotel — Controle de quartos

Gestão dos quartos de um hotel: cadastro, ocupação, liberação, manutenção e listagem dos quartos livres.

Projeto de estudo desenvolvido durante o curso de **Análise e Desenvolvimento de Sistemas** (SENAI-SP Vila Leopoldina), na disciplina de desenvolvimento web com Spring Boot.

## Stack

- Java 21
- Spring Boot (Spring Web + Thymeleaf)
- Bean Validation (Jakarta)
- Lombok
- Maven

Os dados ficam **em memória** (uma `List` dentro do repositório). Não há banco de dados — ao reiniciar a aplicação, os registros são perdidos.

## Como rodar

```bash
./mvnw spring-boot:run
```

Ou abra o projeto no IntelliJ e execute a classe `HotelApplication`.

Depois acesse: **http://localhost:8080/quartos**

## Rotas

| Método | Rota | O que faz |
|---|---|---|
| GET | `/quartos` | Lista todos os quartos |
| GET | `/quartos/novo` | Exibe o formulário de cadastro |
| POST | `/quartos` | Valida e salva o quarto |
| GET | `/quartos/{id}` | Detalhes de um quarto |
| GET | `/quartos/livres` | Lista os quartos livres e o total |
| POST | `/quartos/{id}/ocupar` | Marca o quarto como OCUPADO |
| POST | `/quartos/{id}/liberar` | Libera o quarto |
| POST | `/quartos/{id}/enviarManutencao` | Envia o quarto para MANUTENCAO |

## Estrutura

```
src/main/java/org/example/hotel/
├── model/Quarto.java
├── model/TipoQuarto.java     (enum)
├── model/StatusQuarto.java   (enum)
├── repository/QuartoRepository.java
└── controller/QuartoController.java
src/main/resources/templates/
├── quartos.html     (listagem)
├── form.html        (cadastro)
├── detalhes.html    (um quarto)
└── livres.html      (listagem filtrada + contador)
```

## O que esse projeto exercita

- `@Repository` com injeção de dependência via construtor
- Enums como opções de `<select>` e como máquina de estados
- Validação com mensagens personalizadas (`@NotBlank`, `@NotNull`, `@Size`, `@Positive`)
- Campo `double` em formulário
- Dois métodos de consulta: um que **filtra** (`listarLivres`) e um que **conta** (`contarLivres`)
- Tela separada alimentada por uma consulta própria
