package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/GerenciadorPsicologico?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String SENHA = "May2006*";

    public static Connection conectar() throws SQLException {
        try {
            // Carrega explicitamente o driver JDBC (sem isso o erro "No suitable driver" aparece)
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver JDBC do MySQL não encontrado!", e);
        }

        // Tenta abrir a conexão
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
