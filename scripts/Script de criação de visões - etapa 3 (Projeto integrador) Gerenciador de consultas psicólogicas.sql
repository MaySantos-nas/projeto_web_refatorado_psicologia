-- Visão para visualizar pacientes e suas últimas consultas
CREATE VIEW vw_paciente_consulta AS
SELECT 
    p.ID_Paciente,
    p.Nome AS Nome_Paciente,
    c.ID_Consulta,
    c.Data AS Data_Consulta,
    c.Hora AS Hora_Consulta,
    c.Valor AS Valor_Consulta
FROM 
    paciente p
JOIN 
    consulta c ON p.ID_Paciente = c.ID_Paciente
WHERE
    c.Data = (
        SELECT MAX(c2.Data)
        FROM consulta c2
        WHERE c2.ID_Paciente = p.ID_Paciente
    );
-- Exemplo de visão para consultar todas as consultas agendadas
CREATE VIEW Visao_Consultas AS
SELECT Data, Hora, Nome AS Paciente, Nome AS Psicólogo, Valor
FROM Consulta
JOIN Paciente ON Consulta.ID_Paciente = Paciente.ID_Paciente
JOIN Psicólogo ON Consulta.ID_Psicólogo = Psicólogo.ID_Psicólogo;
