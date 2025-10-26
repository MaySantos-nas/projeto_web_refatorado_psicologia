import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LojaMVP {
    public static void main(String[] args) {
        // Criar a janela principal
        JFrame janela = new JFrame("Calculadora de Vendas");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(300, 150);
        janela.setLayout(new FlowLayout());

        // Criar campo de entrada de texto
        JLabel labelVenda = new JLabel("Valor da Venda:");
        JTextField campoVenda = new JTextField(10);
        JButton botaoCalcular = new JButton("Calcular");

        // Adicionar componentes à janela
        janela.add(labelVenda);
        janela.add(campoVenda);
        janela.add(botaoCalcular);

        // Ação do botão
        botaoCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Obter o valor informado pelo usuário
                    double valorVenda = Double.parseDouble(campoVenda.getText());

                    if (valorVenda > 500) {
                        // Janela de diálogo para desconto
                        String descontoStr = JOptionPane.showInputDialog(janela, "Informe o percentual de desconto:", "Desconto", JOptionPane.QUESTION_MESSAGE);
                        
                        if (descontoStr != null && !descontoStr.trim().isEmpty()) {
                            double desconto = Double.parseDouble(descontoStr);
                            if (desconto < 0 || desconto > 100) {
                                JOptionPane.showMessageDialog(janela, "Percentual de desconto inválido. Insira um valor entre 0 e 100.", "Erro", JOptionPane.ERROR_MESSAGE);
                            } else {
                                double valorFinal = valorVenda - (valorVenda * desconto / 100);
                                JOptionPane.showMessageDialog(janela, String.format("Valor final com desconto: R$ %.2f", valorFinal), "Resultado", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    } else {
                        // Valor sem desconto
                        JOptionPane.showMessageDialog(janela, String.format("Valor final sem desconto: R$ %.2f", valorVenda), "Resultado", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(janela, "Por favor, insira um valor numérico válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Tornar a janela visível
        janela.setVisible(true);
    }
}

