-- Se o banco já existir, opcionalmente você pode dropar:
-- DROP DATABASE IF EXISTS GerenciadorPsicologico;

-- Criação do banco de dados (vai ignorar se já existir)
CREATE DATABASE IF NOT EXISTS GerenciadorPsicologico;
USE GerenciadorPsicologico;

-- Tabela de Pacientes
CREATE TABLE Paciente (
    ID_Paciente INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(100) NOT NULL,
    Data_Nascimento DATE NOT NULL,
    Endereco VARCHAR(200),
    Telefone VARCHAR(15),
    Email VARCHAR(100),
    CPF VARCHAR(14) UNIQUE
);

-- Tabela de Psicologos 
CREATE TABLE Psicologo (
    ID_Psicologo INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(255) NOT NULL,
	Data_Nascimento DATE NOT NULL,
    CRP VARCHAR(50) NOT NULL,
    Especializacao VARCHAR(255),
    Telefone VARCHAR(20),
    Disponibilidade VARCHAR(100)
);

-- Tabela de Quartos
CREATE TABLE Quarto (
    ID_Quarto INT AUTO_INCREMENT PRIMARY KEY,
    Tipo VARCHAR(50) NOT NULL,
    Valor_Diaria DECIMAL(10,2) NOT NULL
);

-- Tabela de Consultas
CREATE TABLE Consulta (
    ID_Consulta INT AUTO_INCREMENT PRIMARY KEY,
    Data DATE NOT NULL,
    Hora TIME NOT NULL,
    ID_Paciente INT,
    ID_Psicologo INT,
    Valor DECIMAL(10,2),
    Receituario TEXT,
    FOREIGN KEY (ID_Paciente) REFERENCES Paciente(ID_Paciente),
    FOREIGN KEY (ID_Psicologo) REFERENCES Psicologo(ID_Psicologo)
);

-- Tabela de Internações
CREATE TABLE Internacao (
    ID_Internacao INT AUTO_INCREMENT PRIMARY KEY,
    Data_Entrada DATE NOT NULL,
    Data_Saida DATE,
    ID_Paciente INT NOT NULL,
    ID_Psicologo INT NOT NULL,
    ID_Quarto INT NOT NULL,
    FOREIGN KEY (ID_Paciente) REFERENCES Paciente(ID_Paciente),
    FOREIGN KEY (ID_Psicologo) REFERENCES Psicologo(ID_Psicologo),
    FOREIGN KEY (ID_Quarto) REFERENCES Quarto(ID_Quarto)
);

-- Tabela de Convênios
CREATE TABLE Convenio (
    ID_Convenio INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(100),
    CNPJ CHAR(14) UNIQUE,
    Tempo_Carencia INT
);

CREATE TABLE agendamentos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    paciente VARCHAR(255) NOT NULL,
    psicologo VARCHAR(255) NOT NULL,
    data DATE NOT NULL,
    hora TIME NOT NULL
);

CREATE TABLE Relatorios (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Periodo VARCHAR(255),
    Psicologo VARCHAR(255),
    TipoConsulta VARCHAR(255),
    Documento LONGBLOB
);
