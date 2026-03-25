CREATE TABLE Usuario (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL
);

CREATE TABLE Categoria (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE Status (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL
);

CREATE TABLE Projeto (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    usuarioId BIGINT,
    CONSTRAINT fk_projeto_usuario
        FOREIGN KEY (usuarioId)
        REFERENCES Usuario(id)
        ON DELETE CASCADE
);

CREATE TABLE Task (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nomeTask VARCHAR(150) NOT NULL,
    completa BOOLEAN DEFAULT FALSE,
    descricao TEXT,
    categoriaId BIGINT,
    statusId BIGINT,
    projetoId BIGINT,

    CONSTRAINT fk_task_categoria
        FOREIGN KEY (categoriaId)
        REFERENCES Categoria(id),

    CONSTRAINT fk_task_status
        FOREIGN KEY (statusId)
        REFERENCES Status(id),

    CONSTRAINT fk_task_projeto
        FOREIGN KEY (projetoId)
        REFERENCES Projeto(id)
        ON DELETE CASCADE
);