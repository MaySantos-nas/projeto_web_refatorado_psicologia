-- Criar usuário para funcionários
CREATE USER 'funcionario_user'@'localhost' IDENTIFIED BY 'senha_funcionario';
GRANT SELECT, INSERT, UPDATE ON GerenciadorPsicologico.Paciente TO 'funcionario_user'@'localhost';
GRANT SELECT, INSERT, UPDATE ON GerenciadorPsicologico.Consulta TO 'funcionario_user'@'localhost';
GRANT SELECT, INSERT, UPDATE ON GerenciadorPsicologico.Internação TO 'funcionario_user'@'localhost';
GRANT SELECT ON GerenciadorPsicologico.Quarto TO 'funcionario_user'@'localhost';

-- Criar usuário para psicólogos
CREATE USER 'psicologo_user'@'localhost' IDENTIFIED BY 'senha_psicologo';
GRANT SELECT, UPDATE ON GerenciadorPsicologico.Paciente TO 'psicologo_user'@'localhost';
GRANT SELECT, UPDATE ON GerenciadorPsicologico.Consulta TO 'psicologo_user'@'localhost';

-- Criar usuário administrador com todas as permissões
CREATE USER 'admin_user'@'localhost' IDENTIFIED BY 'senha_admin';
GRANT ALL PRIVILEGES ON GerenciadorPsicologico.* TO 'admin_user'@'localhost';

-- Criar usuário para o tutor (admin) com email e senha especificados
CREATE USER 'admin@email.com'@'localhost' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON GerenciadorPsicologico.* TO 'admin@email.com'@'localhost';

-- Aplicar mudanças de permissões
FLUSH PRIVILEGES;
