# 📚 Sistema de Gerenciamento de Biblioteca Digital

## Descrição

Sistema desenvolvido em Java para gerenciar uma biblioteca digital, permitindo cadastrar livros e usuários, realizar empréstimos e devoluções, além de salvar os dados em arquivos para manter as informações entre as execuções do programa.

## Funcionalidades

* Cadastro de livros
* Cadastro de usuários
* Listagem de livros e usuários
* Busca de livros por título (ignorando maiúsculas e minúsculas)
* Busca de usuários por e-mail
* Empréstimo de livros
* Devolução de livros
* Remoção de livros
* Listagem de livros disponíveis
* Listagem de livros emprestados
* Ordenação de livros por título
* Ordenação de livros por ano de publicação
* Filtro de livros por autor
* Agrupamento de livros por autor
* Persistência dos dados em arquivos `.dat`

## Conceitos aplicados

* Programação Orientada a Objetos (POO)
* Encapsulamento
* Collections (`List`)
* Generics
* Streams API
* Expressões Lambda
* `Optional`
* `Comparable`
* `Comparator`
* Exceções personalizadas
* Serialização de objetos
* Manipulação de arquivos
* Tratamento de exceções com `try`, `catch` e `finally`

## Estrutura do Projeto

```text
BibliotecaDigital/
│
├── Main.java
├── Biblioteca.java
├── Livro.java
├── Usuario.java
├── Persistencia.java
└── LivroIndisponivelException.java
```

## Como executar

1. Compile todos os arquivos `.java`.
2. Execute a classe `Main`.
3. Utilize o menu para acessar as funcionalidades da biblioteca.

## Autor

Projeto desenvolvido como atividade prática para aplicar conceitos fundamentais da linguagem Java, incluindo Programação Orientada a Objetos, Streams, Serialização e Tratamento de Exceções.
