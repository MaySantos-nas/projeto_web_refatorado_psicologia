import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class TelaCadastrodePaciente extends JFrame {

    // Componentes
    private JTextField campoNome;
    private JTextField campoCPF;
    private JFormattedTextField campoDataNascimento;
    private JTextField campoTelefone;
    private JButton botaoSalvar;

    public TelaCadastrodePaciente() {
        setTitle("Cadastro de Paciente");
        setSize(400, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel titulo = new JLabel("CADASTRO DE PACIENTE");
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        titulo.setBounds(100, 10, 250, 30);
        add(titulo);

        JLabel labelNome = new JLabel("NOME:");
        labelNome.setBounds(30, 60, 100, 25);
        add(labelNome);
        campoNome = new JTextField();
        campoNome.setBounds(140, 60, 200, 25);
        add(campoNome);

        JLabel labelCPF = new JLabel("CPF:");
        labelCPF.setBounds(30, 95, 100, 25);
        add(labelCPF);
        campoCPF = new JTextField();
        campoCPF.setBounds(140, 95, 200, 25);
        add(campoCPF);

        JLabel labelData = new JLabel("DATA DE NASCIMENTO:");
        labelData.setBounds(30, 130, 150, 25);
        add(labelData);

        // Usando MaskFormatter para formatar a data
        try {
            MaskFormatter dataMask = new MaskFormatter("##/##/####");
            dataMask.setPlaceholderCharacter('_');
            campoDataNascimento = new JFormattedTextField(dataMask);
        } catch (ParseException e) {
            campoDataNascimento = new JFormattedTextField();
        }
        campoDataNascimento.setBounds(180, 130, 160, 25);
        add(campoDataNascimento);

        JLabel labelTelefone = new JLabel("TELEFONE:");
        labelTelefone.setBounds(30, 165, 100, 25);
        add(labelTelefone);
        campoTelefone = new JTextField();
        campoTelefone.setBounds(140, 165, 200, 25);
        add(campoTelefone);

        botaoSalvar = new JButton("SALVAR");
        botaoSalvar.setBounds(250, 210, 90, 30);
        add(botaoSalvar);

        // Ação do botão Salvar
        botaoSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = campoNome.getText();
                String cpf = campoCPF.getText();
                String dataNascimento = campoDataNascimento.getText();
                String telefone = campoTelefone.getText();
                String endereco = ""; // Se quiser, pode adicionar outro campo para endereço depois

                // Verificar se os campos estão preenchidos corretamente
                if (nome.isEmpty() || cpf.isEmpty() || dataNascimento.contains("_") || telefone.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente!");
                    return;
                }

                // Converter a data para o formato desejado (yyyy-MM-dd)
                String dataNascimentoFormatada = converterData(dataNascimento);

                if (dataNascimentoFormatada == null) {
                    JOptionPane.showMessageDialog(null, "Data de nascimento inválida!");
                    return;
                }

                // Chama o método de cadastro
                boolean sucesso = TesteConexao.cadastrarPaciente(nome, dataNascimentoFormatada, endereco, telefone, cpf);

                if (sucesso) {
                    JOptionPane.showMessageDialog(null, "Paciente cadastrado com sucesso!");
                    limparCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar paciente.");
                }
            }
        });
    }

    // Método para limpar os campos após salvar
    private void limparCampos() {
        campoNome.setText("");
        campoCPF.setText("");
        campoDataNascimento.setText("");
        campoTelefone.setText("");
    }

    // Método para converter a data para o formato desejado (yyyy-MM-dd)
    private String converterData(String data) {
        try {
            // Verificar se a data está no formato correto (dd/MM/yyyy)
            SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");
            formatoEntrada.setLenient(false);  // Garantir que a data seja válida
            Date dataConvertida = formatoEntrada.parse(data);

            // Formatando a data para o formato necessário (yyyy-MM-dd)
            SimpleDateFormat formatoSaida = new SimpleDateFormat("yyyy-MM-dd");
            return formatoSaida.format(dataConvertida);
        } catch (ParseException e) {
            // Caso a data seja inválida, retornamos null
            return null;
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
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        SalvarPaciente = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("CADASTRO DE PACIENTE");

        jLabel2.setText("NOME:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setText("CPF:");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel4.setText("DATA DE NASCIMENTO:");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel5.setText("CONVÊNIO:");

        jLabel6.setText("TELEFONE:");

        SalvarPaciente.setLabel("SALVAR");
        SalvarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarPacienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4)
                    .addComponent(jLabel6)
                    .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(SalvarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SalvarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed

    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed

    }//GEN-LAST:event_jTextField3ActionPerformed

    private void SalvarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarPacienteActionPerformed

    }//GEN-LAST:event_SalvarPacienteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button SalvarPaciente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
   public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaCadastrodePaciente().setVisible(true);
        });
    }
}