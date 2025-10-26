package ATV4UC9_BloodPressure;

import javax.swing.*; // Componentes da interface grÃ¡fica (JButton, JTextField, etc.)
import javax.swing.table.DefaultTableModel; // Modelo de tabela para JTable
import java.awt.*; // Gerenciamento de layout e design da interface
import java.awt.event.*; // Eventos de clique, aÃ§Ãµes, etc.
import java.io.*; // ManipulaÃ§Ã£o de arquivos para salvar/ler dados

public class MainFrame extends JFrame {
    // 1. Atributos da classe
    private JTextField txtDate, txtTime, txtSystolic, txtDiastolic;
    private JCheckBox chkStress;
    private JButton btnSave;
    private JTable table;
    private DefaultTableModel tableModel;
    private static final String DATA_FILE = "blood_pressure_data.csv";

    // 2. Construtor da classe
    public MainFrame() {
        initComponents(); // Configurar a interface grÃ¡fica
        loadData();       // Carregar os dados do arquivo CSV (se existir)
    }

    // 3. Configurar os componentes da interface grÃ¡fica
    private void initComponents() {
        // Inicializar campos de texto, botÃµes, tabela e checkbox
        txtDate = new JTextField();
        txtTime = new JTextField();
        txtSystolic = new JTextField();
        txtDiastolic = new JTextField();
        chkStress = new JCheckBox("SituaÃ§Ã£o de Estresse");
        btnSave = new JButton("Salvar");

        // Configurar tabela
        String[] columnNames = {"Data", "Hora", "SistÃ³lica", "DiastÃ³lica", "Estresse"};
        tableModel = new DefaultTableModel(columnNames, 0); // Modelo da tabela
        table = new JTable(tableModel); // Tabela baseada no modelo

        // Adicionar aÃ§Ã£o ao botÃ£o "Salvar"
        btnSave.addActionListener(e -> saveData());

        // Layout (organizar a posiÃ§Ã£o dos componentes)
        setLayout(null); // Usar layout absoluto para personalizar as posiÃ§Ãµes
        txtDate.setBounds(20, 20, 150, 25);        // Campo Data
        txtTime.setBounds(20, 50, 150, 25);        // Campo Hora
        txtSystolic.setBounds(20, 80, 150, 25);    // Campo SistÃ³lica
        txtDiastolic.setBounds(20, 110, 150, 25);  // Campo DiastÃ³lica
        chkStress.setBounds(20, 140, 200, 25);     // Checkbox Estresse
        btnSave.setBounds(20, 170, 150, 30);       // BotÃ£o Salvar

        JScrollPane tableScroll = new JScrollPane(table); // Barra de rolagem para a tabela
        tableScroll.setBounds(20, 210, 400, 150);         // PosiÃ§Ã£o da tabela com rolagem

        // Adicionar componentes ao JFrame
        add(txtDate);
        add(txtTime);
        add(txtSystolic);
        add(txtDiastolic);
        add(chkStress);
        add(btnSave);
        add(tableScroll);

        // ConfiguraÃ§Ãµes da janela
        setTitle("Monitor de PressÃ£o Arterial");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centralizar a janela
    }

    // 4. LÃ³gica para salvar os dados (executada ao clicar no botÃ£o Salvar)
    private void saveData() {
        try {
            // Obter os valores digitados nos campos de texto
            String date = txtDate.getText();         // Data
            String time = txtTime.getText();         // Hora
            int systolic = Integer.parseInt(txtSystolic.getText()); // SistÃ³lica
            int diastolic = Integer.parseInt(txtDiastolic.getText()); // DiastÃ³lica
            boolean stress = chkStress.isSelected(); // SituaÃ§Ã£o de estresse

            // Adicionar os valores Ã  tabela
            tableModel.addRow(new Object[]{date, time, systolic, diastolic, stress ? "Sim" : "NÃ£o"});

            // Salvar os dados no arquivo CSV
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE, true))) {
                writer.write(date + "," + time + "," + systolic + "," + diastolic + "," + stress);
                writer.newLine(); // Nova linha
            }

            // Exibir mensagem de sucesso
            JOptionPane.showMessageDialog(this, "Dados salvos com sucesso!");
        } catch (Exception ex) {
            // Exibir mensagem de erro
            JOptionPane.showMessageDialog(this, "Erro ao salvar os dados: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // 5. LÃ³gica para carregar os dados do arquivo CSV ao iniciar o programa
    private void loadData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(","); // Dividir os dados separados por vÃ­rgula
                tableModel.addRow(parts);        // Adicionar Ã  tabela
            }
        } catch (IOException ex) {
            System.out.println("Arquivo ainda nÃ£o criado ou erro ao carregar: " + ex.getMessage());
        }
    }

    // 6. MÃ©todo principal para executar o programa
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true); // Tornar a janela visÃ­vel
        });
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
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Registro");

        jLabel2.setText("DATA (dd/mm/aaaa):");

        jLabel3.setText("HORA (hh:mm):");

        jLabel4.setText("PRESSÃO SISTÓLICA:");

        jLabel5.setText("PRESSÃO DIASTÓLICA:");

        jLabel6.setText("SITUAÇÃO DE ESTRESSE:");

        jCheckBox1.setText("ESTAVA EM ESTRESSE");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "DATA", "HORA", "SISTÓLICA", "DIASTÓLICA", "ESTRESSE"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("SALVAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField2)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField3)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField4)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jButton1))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed

    }//GEN-LAST:event_jCheckBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

