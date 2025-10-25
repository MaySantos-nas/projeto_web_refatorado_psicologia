package dao;

import model.Paciente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

    public void salvar(Paciente paciente) {
        String sql = "INSERT INTO Paciente (Nome, Data_Nascimento, Endereco, Telefone, CPF) VALUES (?, ?, ?, ?, ?)";
        try (Connection conexao = ConexaoDAO.conectar();
             PreparedStatement ps = conexao.prepareStatement(sql)) {

            ps.setString(1, paciente.getNome());
            ps.setDate(2, new java.sql.Date(paciente.getDataNascimento().getTime()));
            ps.setString(3, paciente.getEndereco());
            ps.setString(4, paciente.getTelefone());
            ps.setString(5, paciente.getCpf());

            ps.executeUpdate();
            System.out.println("✅ Paciente salvo com sucesso!");

        } catch (SQLException e) {
            System.out.println("❌ Erro ao salvar paciente: " + e.getMessage());
        }
    }

    public List<Paciente> listar() {
        List<Paciente> pacientes = new ArrayList<>();
        String sql = "SELECT * FROM Paciente";

        try (Connection conexao = ConexaoDAO.conectar();
             PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Paciente p = new Paciente();
                p.setId(rs.getInt("ID_Paciente"));
                p.setNome(rs.getString("Nome"));
                p.setCpf(rs.getString("CPF"));
                pacientes.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pacientes;
    }
    public Paciente findByCpf(String cpf) {
    String sql = "SELECT * FROM Paciente WHERE CPF = ?";
    try (Connection conexao = ConexaoDAO.conectar();
         PreparedStatement ps = conexao.prepareStatement(sql)) {

        ps.setString(1, cpf);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                Paciente p = new Paciente();
                p.setId(rs.getInt("ID_Paciente"));
                p.setNome(rs.getString("Nome"));
                p.setCpf(rs.getString("CPF"));
                p.setEndereco(rs.getString("Endereco"));
                p.setTelefone(rs.getString("Telefone"));
                p.setDataNascimento(rs.getDate("Data_Nascimento"));
                return p;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}

}
