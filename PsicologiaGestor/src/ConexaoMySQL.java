import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
    // Configuração do banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/Gerenciador de Consultas Psicologicas;";
    private static final String USUARIO = "root";  // Alterar se necessário
    private static final String SENHA = "May2006*";        // Adicione sua senha do MySQL

    public static Connection conectar() {
        try {
            Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conexão bem-sucedida!");
            return conexao;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco: " + e.getMessage());
            return null;
        }
    }
}
