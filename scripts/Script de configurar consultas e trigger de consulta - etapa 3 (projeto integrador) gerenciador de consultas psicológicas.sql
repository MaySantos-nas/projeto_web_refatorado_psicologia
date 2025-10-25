
-- Criação do trigger para verificar duplicidade de consultas
DELIMITER //
USE GerenciadorPsicologico;

CREATE TRIGGER VerificarConsultaDuplicada
BEFORE INSERT ON Consulta
FOR EACH ROW
BEGIN
    DECLARE consultaExistente INT;

    -- Verificar se já existe uma consulta no mesmo horário para o mesmo paciente e psicólogo
    SELECT COUNT(*) INTO consultaExistente
    FROM Consulta
    WHERE Data = NEW.Data AND Hora = NEW.Hora
    AND ID_Paciente = NEW.ID_Paciente AND ID_Psicólogo = NEW.ID_Psicólogo;

    -- Se uma consulta já existir, impedir a inserção
    IF consultaExistente > 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Já existe uma consulta agendada para o mesmo horário, paciente e psicólogo.';
    END IF;
END;
//

DELIMITER ;




















