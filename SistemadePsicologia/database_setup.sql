-- Script de Criação do Banco de Dados - Casa Cultural API REST
-- Execute este script no MySQL para criar o banco de dados e as tabelas necessárias

-- Criar o banco de dados
CREATE DATABASE IF NOT EXISTS casa_cultural_filmes 
CHARACTER SET utf8mb4 
COLLATE utf8mb4_unicode_ci;

-- Usar o banco de dados
USE casa_cultural_filmes;

-- Criar tabela de filmes
CREATE TABLE IF NOT EXISTS filmes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    sinopse TEXT(2000) NOT NULL,
    genero VARCHAR(100) NOT NULL,
    ano_lancamento INT NOT NULL,
    data_cadastro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    
    -- Índices para melhor performance
    INDEX idx_titulo (titulo),
    INDEX idx_genero (genero),
    INDEX idx_ano_lancamento (ano_lancamento),
    INDEX idx_data_cadastro (data_cadastro),
    
    -- Constraints
    CONSTRAINT chk_ano_lancamento CHECK (ano_lancamento >= 1900 AND ano_lancamento <= 2030)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Criar tabela de análises
CREATE TABLE IF NOT EXISTS analises (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    filme_id BIGINT NOT NULL,
    analise_texto TEXT(2000) NOT NULL,
    nota DECIMAL(3,1) NOT NULL, -- Garante que a coluna é DECIMAL(3,1)
    data_analise DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    
    -- Chave estrangeira
    FOREIGN KEY (filme_id) REFERENCES filmes(id) ON DELETE CASCADE,
    
    -- Índices para melhor performance
    INDEX idx_filme_id (filme_id),
    INDEX idx_nota (nota),
    INDEX idx_data_analise (data_analise),
    
    -- Constraints
    CONSTRAINT chk_nota CHECK (nota >= 0.0 AND nota <= 10.0)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Inserir dados de exemplo para testes
INSERT INTO filmes (titulo, sinopse, genero, ano_lancamento, data_cadastro) VALUES
("O Poderoso Chefão", "A saga da família Corleone, uma das mais poderosas famílias da máfia italiana nos Estados Unidos.", "Drama", 1972, NOW()),
("Pulp Fiction: Tempo de Violência", "As vidas de dois assassinos da máfia, um boxeador, a esposa de um gângster e um par de assaltantes de restaurante se entrelaçam em quatro histórias de violência e redenção.", "Crime", 1994, NOW()),
("A Origem", "Um ladrão que rouba segredos corporativos através do uso de tecnologia de compartilhamento de sonhos é encarregado de plantar uma ideia na mente de um CEO.", "Ficção Científica", 2010, NOW());

-- Inserir análises de exemplo
INSERT INTO analises (filme_id, analise_texto, nota, data_analise) VALUES
(1, "Uma obra-prima atemporal. Atuações impecáveis e roteiro genial.", 9.8, NOW()),
(1, "Filme que marcou época, mas um pouco longo para o meu gosto.", 8.5, NOW()),
(2, "Diálogos fantásticos e uma narrativa não linear que prende do início ao fim.", 9.5, NOW());

-- Verificar os dados inseridos
SELECT "Filmes cadastrados:" as info;
SELECT id, titulo, genero, ano_lancamento FROM filmes ORDER BY data_cadastro;

SELECT "Análises cadastradas:" as info;
SELECT a.id, f.titulo as filme, a.nota, LEFT(a.analise_texto, 50) as analise_preview 
FROM analises a 
JOIN filmes f ON a.filme_id = f.id 
ORDER BY a.data_analise;
