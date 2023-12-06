CREATE TABLE marca (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    ativo BOOLEAN DEFAULT true
);

CREATE TABLE categoria (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    ativo BOOLEAN DEFAULT true
);

INSERT INTO marca (id, nome, ativo) VALUES
(1, 'Iphone', true),
(2, 'Naves Aviacao LTDA', true);

INSERT INTO categoria (id, nome, ativo) VALUES
(1, 'Eletronicos', true),
(2, 'Aviação', true);