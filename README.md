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

Durante o desenvolvimento do projeto foram utilizados conceitos essenciais de Java:

- Classes
- Atributos
- Métodos
- Construtores
- Encapsulamento
- Relação entre entidades (Usuário → Tasks)

## Versões

### V1
Primeira implementação do **ToDoTask**, consistindo em um sistema **CRUD executado via console**. Essa versão contém as funcionalidades básicas necessárias para a manipulação das tarefas registradas por cada usuário.

## Ferramentas e Tecnologias
- **Java 21 LTS** — linguagem principal utilizada no desenvolvimento
- **IntelliJ IDEA** — ambiente de desenvolvimento (IDE)
- **Git** — controle de versão
- **GitHub** — hospedagem do repositório e gerenciamento de versões

## Entidades do Sistema
### app
Carrega a execução principal do sistema desenvovido, usei ela em primeiro momento pela ausencia de interface estilizada, futuramente esse package será `view`.
- **Main:** Execução da aplicação e principal via de entrada do usuário, por enquanto o nível mais básico de interface.
- **ToDoController:** Executa as funções que o sistema gerencia e oferece aos usuários.
### model
Package responsável por conter as principais modelagens do sistema, criando a base das entidades
Esses modelos são fundamentais na aplicação de POO e na modelagem do banco de dados futuro de uma próxima versão do sistema.
- **Categoria:** Classe que modela os objetos categorias, nessa versão planejo abordar a disponibilização de três categorias base no sistema, e contar que categoria deixe de ser apenas um atributo "setável" e se torne uma entidade.
- **Entidade:** Inicialmente criada para aplicar o encapsulamento dos IDs das entidades, visando a segurança no armazenamento de informações que futuramente se encontrarão em um banco de dados.
- **Status:** Responsável por definir o estado de uma Task, futuramente pretendo integrar essa entidade com condicionais que expressem seus valores de forma visual ao usuário.
- **Task:** A responsável pela criação do sistema, seu molde rege toda a manipulação de entradas e articulação de funções do _ToDoController_ 
- **Usuario:** Classe que define os atributos que permitirão o cadastro e registro de usuários, possibilitando a separação de Task's por pessoa.
### service
Registra atualmente as funções atribuídas a uma entidade, ou seja, enquanto `controller` executa as funcionalidades, `service` cria e armazena esses método, promovendo organização para a prevenção de bugs e melhor visualização do sistema.
- **CategoriaService:**