DELIMITER //
CREATE PROCEDURE InserirConsulta(
    IN p_Data DATE,
    IN p_Hora TIME,
    IN p_ID_Paciente INT,
    IN p_ID_Psicólogo INT,
    IN p_Valor DECIMAL(10,2),
    IN p_Receituário TEXT
)
BEGIN
    INSERT INTO Consulta (Data, Hora, ID_Paciente, ID_Psicólogo, Valor, Receituário)
    VALUES (p_Data, p_Hora, p_ID_Paciente, p_ID_Psicólogo, p_Valor, p_Receituário);
END;
//
DELIMITER ;
