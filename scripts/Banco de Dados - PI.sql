-- Criação do banco de dados
CREATE DATABASE GerenciadorPsicologico;
USE GerenciadorPsicologico;

-- Criação das tabelas

CREATE TABLE Paciente (
    ID_Paciente INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(100) NOT NULL,
    Data_Nascimento DATE NOT NULL,
    Endereço VARCHAR(255),
    Telefone VARCHAR(15),
    Email VARCHAR(100),
    CPF CHAR(11) NOT NULL UNIQUE
);

CREATE TABLE Psicologo (
    ID_Psicologo INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(255) NOT NULL,
    CRP VARCHAR(50) NOT NULL,
    Especializacao VARCHAR(255),
    Telefone VARCHAR(20),
    Disponibilidade VARCHAR(100)
);

CREATE TABLE Consulta (
    ID_Consulta INT AUTO_INCREMENT PRIMARY KEY,
    Data DATE NOT NULL,
    Hora TIME NOT NULL,
    ID_Paciente INT,
    ID_Psicólogo INT,
    Valor DECIMAL(10,2),
    Receituário TEXT,
    FOREIGN KEY (ID_Paciente) REFERENCES Paciente(ID_Paciente),
    FOREIGN KEY (ID_psicologo) REFERENCES psicologo(ID_Psicólogo)
);

CREATE TABLE Internação (
    ID_Internação INT AUTO_INCREMENT PRIMARY KEY,
    Data_Entrada DATE NOT NULL,
    Data_Saída DATE,
    ID_Paciente INT,
    ID_Psicólogo INT,
    ID_Quarto INT,
    FOREIGN KEY (ID_Paciente) REFERENCES Paciente(ID_Paciente),
    FOREIGN KEY (ID_psicologo) REFERENCES psicologo(ID_psicologo),
    FOREIGN KEY (ID_Quarto) REFERENCES Quarto(ID_Quarto)
);

CREATE TABLE Quarto (
    ID_Quarto INT AUTO_INCREMENT PRIMARY KEY,
    Tipo VARCHAR(50),
    Valor_Diária DECIMAL(10,2)
);

CREATE TABLE Convênio (
    ID_Convênio INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(100),
    CNPJ CHAR(14) UNIQUE,
    Tempo_Carência INT
);



