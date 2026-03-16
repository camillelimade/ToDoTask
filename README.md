# ToDoTask

Este repositório contém a implementação de um sistema simples de gerenciamento de tarefas desenvolvido em **Java**. O objetivo do projeto é aplicar conceitos fundamentais de **Programação Orientada a Objetos (POO)** por meio da criação de um sistema de **ToDo List executado via console**.

O _ToDoTask_ permite que usuários cadastrem e gerenciem suas próprias tarefas de forma prática e organizada.

## Funcionalidades

- Cadastro de usuário
- Criação de tarefas
- Edição de tarefas
- Exclusão de tarefas
- Marcação de tarefas como concluídas
- Listagem de todas as tarefas
- Associação entre **usuários e tarefas**

## Conceitos aplicados

Durante o desenvolvimento do projeto foram utilizados conceitos essenciais de Java
### Versão 1
- Classes
- Atributos
- Métodos
- Construtores
- Encapsulamento
- Relação entre entidades (Usuário → Tasks)

### Versão 2
- Herança
- Polimorfismo
- Interfaces
- Classes abstratas

## Versões

### V1
Primeira implementação do **ToDoTask**, consistindo em um sistema **CRUD executado via console**. Essa versão contém as funcionalidades básicas necessárias para a manipulação das tarefas registradas por cada usuário.

### V2
Na segunda versão foram aplicados conceitos avançados de POO, como Herança, Polimorfismo, Interfaces e Classes Abstratas.
Essa refatoração contribuiu para uma melhor organização e visualização da estrutura do sistema, incluindo a criação de novos pacotes que auxiliam na separação de responsabilidades dentro do projeto.

## Ferramentas e Tecnologias
- **Java 21 LTS** — linguagem principal utilizada no desenvolvimento
- **IntelliJ IDEA** — ambiente de desenvolvimento (IDE)
- **Git** — controle de versão
- **GitHub** — hospedagem do repositório e gerenciamento de versões

## Entidades do Sistema
### app
Responsável pela execução principal do sistema. Esse pacote foi utilizado inicialmente devido à ausência de uma interface gráfica. Em versões futuras, a ideia é que ele evolua para um pacote `view`, responsável pela interação com o usuário.
A aplicação está organizada em pacotes que separam responsabilidades dentro do sistema, facilitando a manutenção e evolução do projeto.

- **Main:** Classe responsável por iniciar a aplicação e servir como ponto de entrada do sistema. Atualmente funciona como uma interface básica via console, permitindo a interação direta com o usuário.

### controller
Responsável por coordenar a execução das funcionalidades do sistema, intermediando as ações entre a interface e as regras de negócio.

- **ToDoController:** Controla as operações principais relacionadas às tarefas, executando ações como criação, edição, exclusão, listagem e atualização de status.

### model
Pacote responsável pela modelagem das entidades principais do sistema. Essas classes representam os objetos centrais da aplicação e servem como base para a aplicação dos conceitos de Programação Orientada a Objetos.

- **Categoria:** Representa as categorias que podem ser atribuídas às tarefas. Nesta versão, a categoria passa a ser tratada como uma entidade própria, deixando de ser apenas um atributo simples.
- **Entidade:** Classe base criada para encapsular o controle de identificadores (IDs) das entidades do sistema, preparando a estrutura para futuras integrações com banco de dados.
- **Status:** Define o estado de uma tarefa, permitindo diferenciar tarefas pendentes, concluídas ou em andamento.
- **Task:** Representa a entidade principal do sistema, responsável por armazenar as informações relacionadas às tarefas criadas pelos usuários.
- **Usuario:** Define os atributos necessários para o cadastro e gerenciamento de usuários, permitindo que cada usuário possua suas próprias tarefas.

### service
Pacote responsável por concentrar a lógica relacionada à manipulação das entidades do sistema. Enquanto o `controller` coordena as ações, os serviços implementam as operações específicas de cada entidade.

- **CategoriaService:** Responsável pela criação, listagem e gerenciamento das categorias disponíveis no sistema.
- **TaskService:** Implementa as operações relacionadas às tarefas, como criação, edição, exclusão e atualização de status.
- **UsuarioService:** Responsável pelas operações relacionadas ao gerenciamento de usuários.
- **Completable (interface):** Define comportamentos relacionados à conclusão de tarefas, permitindo aplicar polimorfismo dentro da lógica do sistema.


## Evolução do Projeto

A estrutura atual do sistema foi pensada para facilitar futuras expansões, como:

- Integração com banco de dados
- Separação mais clara de camadas da aplicação
- Implementação de uma interface gráfica
- Expansão das regras de negócio do sistema

A organização em pacotes já prepara o projeto para evoluir de um sistema simples executado via console para uma aplicação mais robusta.