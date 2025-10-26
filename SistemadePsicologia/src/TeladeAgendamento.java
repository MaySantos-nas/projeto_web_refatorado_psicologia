import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.*;

public class TeladeAgendamento extends JFrame {

    private JComboBox<String> comboPaciente;
    private JComboBox<String> comboPsicologo;
    private JTextField campoData;
    private JTextField campoHora;
    private JButton botaoSalvar;
    private JButton botaoCancelar;

    // Conexão com o banco de dados
    private Connection conn;

    public TeladeAgendamento() {
        setTitle("Agendamento de Consulta");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);

        // Configuração dos componentes
        JLabel labelPaciente = new JLabel("Paciente:");
        labelPaciente.setBounds(30, 30, 80, 25);
        add(labelPaciente);

        comboPaciente = new JComboBox<>();
        comboPaciente.setBounds(120, 30, 220, 25);
        add(comboPaciente);

        JLabel labelPsicologo = new JLabel("Psicólogo:");
        labelPsicologo.setBounds(30, 70, 80, 25);
        add(labelPsicologo);

        comboPsicologo = new JComboBox<>();
        comboPsicologo.setBounds(120, 70, 220, 25);
        add(comboPsicologo);

        JLabel labelData = new JLabel("Data:");
        labelData.setBounds(30, 110, 80, 25);
        add(labelData);

        campoData = new JTextField("dd/mm/aaaa");
        campoData.setBounds(120, 110, 220, 25);
        add(campoData);

        JLabel labelHora = new JLabel("Hora:");
        labelHora.setBounds(30, 150, 80, 25);
        add(labelHora);

        campoHora = new JTextField("hh:mm");
        campoHora.setBounds(120, 150, 220, 25);
        add(campoHora);

        botaoSalvar = new JButton("Salvar");
        botaoSalvar.setBounds(80, 200, 100, 30);
        add(botaoSalvar);

        botaoCancelar = new JButton("Cancelar");
        botaoCancelar.setBounds(200, 200, 100, 30);
        add(botaoCancelar);

        // Conectar ao banco de dados
        conectarBanco();

        // Carregar pacientes e psicólogos ao abrir a tela
        carregarPacientes();
        carregarPsicologos();

        // Ação ao salvar
        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String paciente = (String) comboPaciente.getSelectedItem();
                String psicologo = (String) comboPsicologo.getSelectedItem();
                String data = campoData.getText();
                String hora = campoHora.getText();

                if (paciente.equals("Selecione...") || psicologo.equals("Selecione...") || data.isEmpty() || hora.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                } else {
                    // Extrair o ID do paciente e psicólogo a partir do item selecionado
                    String pacienteID = paciente.split(" - ")[0];
                    String psicologoID = psicologo.split(" - ")[0];

                    // Inserir no banco
                    TesteConexao.salvarConsulta(pacienteID, psicologoID, data, hora);
                    // Atualizar os combo boxes
                    carregarPacientes();
                    carregarPsicologos();
                    JOptionPane.showMessageDialog(null, "Consulta agendada com sucesso!");
                }
            }
        });

        // Ação ao cancelar
        botaoCancelar.addActionListener(e -> dispose());

        // Placeholder inteligente para campoData
        campoData.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (campoData.getText().equals("dd/mm/aaaa")) {
                    campoData.setText("");
                }
            }
            public void focusLost(FocusEvent e) {
                if (campoData.getText().isEmpty()) {
                    campoData.setText("dd/mm/aaaa");
                }
            }
        });

        // Placeholder inteligente para campoHora
        campoHora.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (campoHora.getText().equals("hh:mm")) {
                    campoHora.setText("");
                }
            }
            public void focusLost(FocusEvent e) {
                if (campoHora.getText().isEmpty()) {
                    campoHora.setText("hh:mm");
                }
            }
        });
    }

    // Método para conectar ao banco de dados
    private void conectarBanco() {
        try {
            // Substitua com suas credenciais de banco de dados
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/GerenciadorPsicologico", "root", "May2006*");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados.");
        }
    }

    // Carregar pacientes do banco de dados
    private void carregarPacientes() {
        try {
            String sql = "SELECT ID_Paciente, nome FROM paciente";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            comboPaciente.removeAllItems();
            comboPaciente.addItem("Selecione...");

            while (rs.next()) {
                String pacienteID = rs.getString("ID_Paciente");
                String nomePaciente = rs.getString("nome");
                comboPaciente.addItem(pacienteID + " - " + nomePaciente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao carregar pacientes.");
        }
    }

    // Carregar psicólogos do banco de dados
    private void carregarPsicologos() {
        try {
            String sql = "SELECT ID_Psicologo, nome FROM psicologo";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            comboPsicologo.removeAllItems();
            comboPsicologo.addItem("Selecione...");

            while (rs.next()) {
                String psicologoID = rs.getString("ID_Psicologo");
                String nomePsicologo = rs.getString("nome");
                comboPsicologo.addItem(psicologoID + " - " + nomePsicologo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao carregar psicólogos.");
        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("AGENDAMENTO");

        jLabel2.setText("PACIENTE:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setText("PSICOLOGO:");

        jLabel4.setText("DATA:");

        jTextField3.setText("/  /");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel5.setText("HORA:");

        jTextField4.setText("         :");

        button1.setLabel("SALVAR");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvar(evt);
            }
        });

        button2.setLabel("CANCELAR");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(39, 39, 39)
                                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
       
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void btnSalvar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvar
    
    }//GEN-LAST:event_btnSalvar

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
       
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void btnCancelar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar
   
    }//GEN-LAST:event_btnCancelar

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Button button2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
   public static void main(String[] args) {
        // Criar a tela de agendamento
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TeladeAgendamento().setVisible(true);
            }
        });
    }
}