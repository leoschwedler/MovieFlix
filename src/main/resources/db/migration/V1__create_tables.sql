-- Criação da tabela de categorias
CREATE TABLE tb_category (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

-- Criação da tabela de filmes
CREATE TABLE tb_movie (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(100) NOT NULL
);

-- Criação da tabela de streamings
CREATE TABLE tb_streaming (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);