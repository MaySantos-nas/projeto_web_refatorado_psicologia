package dao;

import model.Psicologo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PsicologoDAO {

    // Método para salvar um psicólogo no banco
    public void salvar(Psicologo psicologo) {
        String sql = "INSERT INTO Psicologo (Nome, CRP, Especializacao, Telefone) VALUES (?, ?, ?, ?)";

        try (Connection conexao = ConexaoDAO.conectar();
             PreparedStatement ps = conexao.prepareStatement(sql)) {

            ps.setString(1, psicologo.getNome());
            ps.setString(2, psicologo.getCrp());
            ps.setString(3, psicologo.getEspecializacao());
            ps.setString(4, psicologo.getTelefone());

            ps.executeUpdate();
            System.out.println("✅ Psicólogo salvo com sucesso!");

        } catch (SQLException e) {
            System.out.println("❌ Erro ao salvar psicólogo: " + e.getMessage());
        }
    }

    // Método para listar todos os psicólogos
    public List<Psicologo> listar() {
        List<Psicologo> psicologos = new ArrayList<>();
        String sql = "SELECT * FROM Psicologo";

        try (Connection conexao = ConexaoDAO.conectar();
             PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Psicologo p = new Psicologo();
                p.setId(rs.getInt("ID_Psicologo"));
                p.setNome(rs.getString("Nome"));
                p.setCrp(rs.getString("CRP"));
                p.setEspecializacao(rs.getString("Especializacao"));
                p.setTelefone(rs.getString("Telefone"));
                psicologos.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return psicologos;
    }
}

