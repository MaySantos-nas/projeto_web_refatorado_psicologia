import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date; // Importando java.sql.Date
import java.sql.Time; // Importando java.sql.Time
import java.text.SimpleDateFormat; // Para formatar a data

public class TesteConexao {

    // Método para realizar a conexão com o banco de dados
    public static Connection conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/GerenciadorPsicologico";
        String usuario = "root";
        String senha = "May2006*";
        return DriverManager.getConnection(url, usuario, senha);
    }

    // Método para cadastrar um paciente
    public static boolean cadastrarPaciente(String nome, String dataNascimentoStr, String endereco, String telefone, String cpf) {
        String sql = "INSERT INTO Paciente (Nome, Data_Nascimento, Endereco, Telefone, CPF) VALUES (?, ?, ?, ?, ?)";

        try (Connection conexao = conectar(); PreparedStatement ps = conexao.prepareStatement(sql)) {
            // Converte String para java.sql.Date com formato ISO
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = formato.parse(dataNascimentoStr); // Converte de String para java.util.Date
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); // Converte de java.util.Date para java.sql.Date

            ps.setString(1, nome);
            ps.setDate(2, sqlDate); // Aqui estamos setando a data convertida
            ps.setString(3, endereco);
            ps.setString(4, telefone);
            ps.setString(5, cpf);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0; // Retorna true se inseriu com sucesso
        } catch (SQLException | java.text.ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para cadastrar um psicólogo
    public static boolean cadastrarPsicologo(String nome, String dataNascimentoStr, String especializacao, String crm, String disponibilidade, String telefone) {
        String sql = "INSERT INTO Psicologo (Nome, Data_Nascimento, Especializacao, CRM, Disponibilidade, Telefone) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conexao = conectar(); PreparedStatement ps = conexao.prepareStatement(sql)) {
            // Converte String para java.sql.Date
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); // Novo formato de data
            java.util.Date utilDate = formato.parse(dataNascimentoStr); // Converte de String para java.util.Date
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); // Converte de java.util.Date para java.sql.Date

            ps.setString(1, nome);
            ps.setDate(2, sqlDate); // Tipo correto
            ps.setString(3, especializacao);
            ps.setString(4, crm);
            ps.setString(5, disponibilidade);
            ps.setString(6, telefone);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException | java.text.ParseException e) { // Trata SQLException e ParseException separadamente
            e.printStackTrace();
            return false;
        }
    }

    // Método para salvar agendamento no banco
    public static boolean salvarConsulta(String pacienteID, String psicologoID, String dataStr, String horaStr) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Converte data e hora de String para java.sql.Date e java.sql.Time
            // Ajustando o formato da data para "dd/MM/yyyy"
            SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date utilDate = sdfData.parse(dataStr); // Converte de String para java.util.Date
            Date sqlDate = new Date(utilDate.getTime()); // Converte de java.util.Date para java.sql.Date

            // Formato para hora
            SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
            java.util.Date utilHora = sdfHora.parse(horaStr);
            Time sqlTime = new Time(utilHora.getTime());

            // Conexão com o banco
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/GerenciadorPsicologico", "root", "May2006*");

            // Insere dados na tabela
            String sql = "INSERT INTO Consulta (ID_Paciente, ID_Psicologo, Data, Hora) VALUES (?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);

            // Agora estamos passando os IDs dos pacientes e psicólogos
            stmt.setInt(1, Integer.parseInt(pacienteID));
            stmt.setInt(2, Integer.parseInt(psicologoID));
            stmt.setDate(3, sqlDate);
            stmt.setTime(4, sqlTime);

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
            try { if (conn != null) conn.close(); } catch (SQLException e) {}
        }
    }

    public static boolean inserirInternacao(String pacienteNome, String quarto) {
    String url = "jdbc:mysql://localhost:3306/GerenciadorPsicologico";
    String usuario = "root";
    String senha = "May2006*";

    String sqlPaciente = "SELECT ID_Paciente FROM Paciente WHERE Nome = ?";
    String sqlInternacao = "INSERT INTO Internacao (ID_Paciente, Quarto) VALUES (?, ?)";

    try (
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/GerenciadorPsicologico", "root", "May2006*");
        PreparedStatement stmtBusca = conn.prepareStatement(sqlPaciente)
    ) {
        stmtBusca.setString(1, pacienteNome);
        try (ResultSet rs = stmtBusca.executeQuery()) {
            if (rs.next()) {
                int idPaciente = rs.getInt("ID_Paciente");

                try (PreparedStatement stmtInsert = conn.prepareStatement(sqlInternacao)) {
                    stmtInsert.setInt(1, idPaciente);
                    stmtInsert.setString(2, quarto);
                    int linhasAfetadas = stmtInsert.executeUpdate();
                    return linhasAfetadas > 0;
                }

            } else {
                System.out.println("Paciente não encontrado.");
                return false;
            }
        }

    } catch (SQLException e) {
        System.out.println("Erro ao inserir internação: " + e.getMessage());
        return false;
    }
}
    
    public static boolean inserirRelatorio(String periodo, String psicologo, String tipoConsulta, String caminhoArquivo) {
    Connection conn = null;
    PreparedStatement stmt = null;

    try {
        // Conectar ao banco de dados
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/GerenciadorPsicologico", "root", "May2006*");

        // SQL para inserir o relatório com o caminho do arquivo
        String sql = "INSERT INTO Relatorios (Periodo, Psicologo, TipoConsulta, CaminhoArquivo) VALUES (?, ?, ?, ?)";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, periodo);
        stmt.setString(2, psicologo);
        stmt.setString(3, tipoConsulta);
        stmt.setString(4, caminhoArquivo);

        // Executar a inserção
        int linhasAfetadas = stmt.executeUpdate();
        return linhasAfetadas > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    } finally {
        try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
        try { if (conn != null) conn.close(); } catch (SQLException e) {}
    }
}


    // Método para verificar o login
    public static boolean realizarLogin(String email, String senha) {
        String[] tabelas = {"Funcionario", "Psicologo", "Administrador"};

        for (String tabela : tabelas) {
            String sql = "SELECT * FROM " + tabela + " WHERE Email = ? AND Senha = ?";

            try (Connection conexao = conectar(); PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setString(1, email);
                ps.setString(2, senha);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return true; // Encontrou email e senha válidos
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false; // Não encontrou o login em nenhuma tabela
    }
}
