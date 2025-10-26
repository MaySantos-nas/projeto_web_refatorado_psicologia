import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class TeladeInternaçoes extends JFrame {

    private JTable TabeladeInternações;
    private DefaultTableModel modeloTabela;
    private JButton btnInternações;

    public TeladeInternaçoes() {
        setTitle("Tela de Internações");
        setSize(500, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel titulo = new JLabel("Internações Atuais");
        titulo.setBounds(180, 10, 200, 25);
        add(titulo);

        modeloTabela = new DefaultTableModel(new Object[]{"Paciente", "Quarto"}, 0);
        TabeladeInternações = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(TabeladeInternações);
        scrollPane.setBounds(30, 50, 420, 180);
        add(scrollPane);

        btnInternações = new JButton("Nova Internação");
        btnInternações.setBounds(160, 250, 160, 30);
        add(btnInternações);

        exibirInternacoes();

        btnInternações.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnInternaçõesActionPerformed(evt);
            }
        });
    }

    private void adicionarInternacao(String paciente, String quarto) {
        modeloTabela.addRow(new Object[]{paciente, quarto});
    }

    private void exibirInternacoes() {
        try (
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/GerenciadorPsicologico", "root", "May2006*");
            PreparedStatement stmt = conn.prepareStatement("""
                SELECT p.Nome AS NomePaciente, q.Tipo AS TipoQuarto
                FROM Internacao i
                JOIN Paciente p ON i.ID_Paciente = p.ID_Paciente
                JOIN Quarto q ON i.ID_Quarto = q.ID_Quarto
                WHERE i.Data_Saida IS NULL
            """);
            ResultSet rs = stmt.executeQuery()
        ) {
            modeloTabela.setRowCount(0);

            while (rs.next()) {
                String nomePaciente = rs.getString("NomePaciente");
                String tipoQuarto = rs.getString("TipoQuarto");
                adicionarInternacao(nomePaciente, tipoQuarto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void btnInternaçõesActionPerformed(ActionEvent evt) {
        String pacienteNome = JOptionPane.showInputDialog(this, "Nome do paciente:");
        if (pacienteNome == null || pacienteNome.trim().isEmpty()) return;

        String tipoQuarto = JOptionPane.showInputDialog(this, "Tipo de quarto:");
        if (tipoQuarto == null || tipoQuarto.trim().isEmpty()) return;

        salvarInternacao(pacienteNome.trim(), tipoQuarto.trim());
    }

    private void salvarInternacao(String pacienteNome, String tipoQuarto) {
        try (
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/GerenciadorPsicologico", "root", "May2006*")
        ) {
            int idPaciente;
            int idQuarto;

            try (PreparedStatement stmt = conn.prepareStatement("SELECT ID_Paciente FROM Paciente WHERE Nome = ?")) {
                stmt.setString(1, pacienteNome);
                ResultSet rs = stmt.executeQuery();
                if (!rs.next()) {
                    JOptionPane.showMessageDialog(this, "Paciente não encontrado.");
                    return;
                }
                idPaciente = rs.getInt("ID_Paciente");
            }

            try (PreparedStatement stmt = conn.prepareStatement("SELECT ID_Quarto FROM Quarto WHERE Tipo = ?")) {
                stmt.setString(1, tipoQuarto);
                ResultSet rs = stmt.executeQuery();
                if (!rs.next()) {
                    JOptionPane.showMessageDialog(this, "Quarto não encontrado.");
                    return;
                }
                idQuarto = rs.getInt("ID_Quarto");
            }

            try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Internacao WHERE ID_Paciente = ? AND Data_Saida IS NULL")) {
                stmt.setInt(1, idPaciente);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "O paciente já está internado.");
                    return;
                }
            }

            try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO Internacao (Data_Entrada, ID_Paciente, ID_Psicologo, ID_Quarto) VALUES (CURDATE(), ?, 1, ?)")) {
                stmt.setInt(1, idPaciente);
                stmt.setInt(2, idQuarto);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Internação registrada com sucesso!");
                exibirInternacoes();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao registrar internação.");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jFrame1 = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        button1 = new java.awt.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabeladeInternações = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("INTERNAÇÕES");

        button1.setLabel("NOVAS INTERNAÇÕES");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInternações(evt);
            }
        });

        tabeladeInternações.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "PACIENTE", "QUARTO"
            }
        ));
        jScrollPane1.setViewportView(tabeladeInternações);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInternações(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInternações
       
    }//GEN-LAST:event_btnInternações

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabeladeInternações;
    // End of variables declaration//GEN-END:variables
public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TeladeInternaçoes().setVisible(true));
    }
}