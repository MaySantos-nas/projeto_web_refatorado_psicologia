import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeladeDashboard extends JFrame {

    // Variáveis de contagem
    private JLabel lblPacientes;
    private JLabel lblConsultasAgendadas;
    private JLabel lblInternacoesAtivas;

    public TeladeDashboard() {
        setTitle("Dashboard");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel Lateral (Menu)
        JPanel menuLateral = new JPanel();
        menuLateral.setLayout(new GridLayout(8, 1, 10, 10));
        menuLateral.setBackground(new Color(8, 94, 255)); // Azul

        JButton btnDashboard = new JButton("DASHBOARD");
        JButton btnPaciente = new JButton("CADASTRO DE PACIENTE");
        JButton btnAgendamento = new JButton("AGENDAMENTO");
        JButton btnInternacoes = new JButton("INTERNAÇÕES");
        JButton btnRelatorio = new JButton("RELATÓRIOS");
        JButton btnProntuario = new JButton("PRONTUÁRIO");
        JButton btnPsicologo = new JButton("CADASTRO DE PSICÓLOGO");
        JButton btnSair = new JButton("SAIR");

        menuLateral.add(btnDashboard);
        menuLateral.add(btnPaciente);
        menuLateral.add(btnAgendamento);
        menuLateral.add(btnInternacoes);
        menuLateral.add(btnRelatorio);
        menuLateral.add(btnProntuario);
        menuLateral.add(btnPsicologo);
        menuLateral.add(btnSair);

        add(menuLateral, BorderLayout.WEST);

        // Painel Central (resumo de dados)
        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new GridLayout(1, 3, 20, 10));
        painelCentral.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        // Inicializando os rótulos com valores obtidos da base de dados
        lblPacientes = new JLabel("Total de Pacientes: " + contarPacientes());
        lblConsultasAgendadas = new JLabel("Consultas Agendadas: " + contarConsultasAgendadas());
        lblInternacoesAtivas = new JLabel("Internações Ativas: " + contarInternacoesAtivas());

        // Criando painéis dinâmicos
        painelCentral.add(criarPainel(lblPacientes, new Color(52, 152, 219)));
        painelCentral.add(criarPainel(lblConsultasAgendadas, new Color(46, 204, 113)));
        painelCentral.add(criarPainel(lblInternacoesAtivas, new Color(231, 76, 60)));

        add(painelCentral, BorderLayout.CENTER);

        // Eventos
        btnPaciente.addActionListener(e -> {
            TelaCadastrodePaciente tela = new TelaCadastrodePaciente();
            tela.setVisible(true);
        });

        btnPsicologo.addActionListener(e -> {
            TelaCadastrodePsicologo tela = new TelaCadastrodePsicologo();
            tela.setVisible(true);
        });

        btnAgendamento.addActionListener(e -> {
            TeladeAgendamento tela = new TeladeAgendamento();
            tela.setVisible(true);
        });

        btnRelatorio.addActionListener(e -> {
            TeladeRelatorios tela = new TeladeRelatorios();
            tela.setVisible(true);
        });

        btnProntuario.addActionListener(e -> {
            TeladeProntuário tela = new TeladeProntuário();
            tela.setVisible(true);
        });

        btnInternacoes.addActionListener(e -> {
            TeladeInternaçoes tela = new TeladeInternaçoes();
            tela.setVisible(true);
        });

        btnSair.addActionListener(e -> {
            TelaLogin login = new TelaLogin();
            login.setVisible(true);
            dispose();
        });

        setVisible(true);
    }

    private JPanel criarPainel(JLabel lblValor, Color cor) {
        JPanel painel = new JPanel();
        painel.setBackground(cor);
        painel.setLayout(new BorderLayout());
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        lblValor.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblValor.setForeground(Color.WHITE);

        painel.add(lblValor, BorderLayout.CENTER);
        return painel;
    }

    // Métodos de contagem com base nos dados do banco
    public static int contarPacientes() {
        // Substitua esse método com a lógica real de contagem dos pacientes
        return 120; // Exemplo de valor fixo para testes
    }

    public static int contarConsultasAgendadas() {
        // Substitua esse método com a lógica real de contagem das consultas agendadas
        return 32; // Exemplo de valor fixo para testes
    }

    public static int contarInternacoesAtivas() {
        // Substitua esse método com a lógica real de contagem das internações ativas
        return 5; // Exemplo de valor fixo para testes
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        button1 = new java.awt.Button();
        button3 = new java.awt.Button();
        button4 = new java.awt.Button();
        button5 = new java.awt.Button();
        button6 = new java.awt.Button();
        button7 = new java.awt.Button();
        button8 = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Total de pacientes", "consultas agendadas", "Internações ativas"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        button1.setLabel("PACIENTE");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaciente(evt);
            }
        });

        button3.setLabel("AGENDAMENTO");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendamento(evt);
            }
        });

        button4.setLabel("RELATÓRIOS");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatórios(evt);
            }
        });

        button5.setLabel("PROTUÁRIO");
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProtuário(evt);
            }
        });

        button6.setLabel("SAIR");
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogin(evt);
            }
        });

        button7.setLabel("DASHBOARD");
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashboard(evt);
            }
        });

        button8.setLabel("PSICOLÓGOS");
        button8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrodePsicologo(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(button7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogin(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogin

    }//GEN-LAST:event_btnLogin

    private void btnProtuário(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProtuário

    }//GEN-LAST:event_btnProtuário

    private void btnAgendamento(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendamento
   
    }//GEN-LAST:event_btnAgendamento

    private void btnRelatórios(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatórios

    }//GEN-LAST:event_btnRelatórios

    private void btnPaciente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaciente

    }//GEN-LAST:event_btnPaciente

    private void btnDashboard(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboard
  
    }//GEN-LAST:event_btnDashboard

    private void btnCadastrodePsicologo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrodePsicologo

    }//GEN-LAST:event_btnCadastrodePsicologo

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Button button3;
    private java.awt.Button button4;
    private java.awt.Button button5;
    private java.awt.Button button6;
    private java.awt.Button button7;
    private java.awt.Button button8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
public static void main(String[] args) {
        new TeladeDashboard();
    }
}
