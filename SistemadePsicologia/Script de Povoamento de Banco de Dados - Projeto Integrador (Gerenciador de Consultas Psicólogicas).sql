-- Selecione o banco de dados onde você vai povoar as tabelas
USE GerenciadorPsicologico;

-- Povoamento das tabelas

-- Pacientes
INSERT INTO Paciente (Nome, Data_Nascimento, Endereço, Telefone, Email, CPF)
VALUES ('João Silva', '1985-06-15', 'Rua A, 123', '1234567890', 'joao.silva@email.com', '12345678900'),
       ('Maria Oliveira', '1990-11-22', 'Rua B, 456', '0987654321', 'maria.oliveira@email.com', '09876543211');

-- Psicólogos
INSERT INTO Psicologo (Nome, CRM, Telefone, Especializacao, Disponibilidade)
VALUES 
('Dr. Carlos Pereira', 'CRM1234', '1245612389', 'Psicologia Clínica', 'Segunda a Sexta - 9h às 17h'),
('Dra. Ana Souza', 'CRM5678', '9821242340', 'Psicologia Infantil', 'Segunda a Quarta - 10h às 16h');

-- Quartos
INSERT INTO Quarto (Tipo, Valor_Diaria)
VALUES 
('Enfermaria', 100.00),
('Apartamento', 200.00);

-- Convênios
INSERT INTO Convenio (Nome, CNPJ, Tempo_Carencia)
VALUES 
('Convênio Saúde', '12345678000195', 30),
('Plano Bem Estar', '98765432000198', 15);

-- Consultas
INSERT INTO Consulta (Data, Hora, ID_Paciente, ID_Psicologo, Valor, Receituario)
VALUES 
('2024-08-05', '14:00:00', 1, 1, 150.00, 'Receituário detalhado'),
('2024-08-07', '10:00:00', 2, 2, 180.00, 'Receituário detalhado');

-- Internações
INSERT INTO Internacao (Data_Entrada, Data_Saida, ID_Paciente, ID_Psicologo, ID_Quarto)
VALUES 
('2024-08-01', '2024-08-10', 1, 1, 1),
('2024-08-02', '2024-08-12', 2, 2, 2);




