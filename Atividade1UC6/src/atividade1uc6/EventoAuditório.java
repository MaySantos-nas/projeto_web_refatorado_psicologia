package atividade1uc6;

import java.util.Scanner;

public class EventoAuditório {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Informe o número de convidados: ");
            int convidados = scanner.nextInt();
            
            if (convidados > 350 || convidados < 0) {
                System.out.println("Número de convidados inválido.");
            } else if (convidados <= 150) {
                System.out.println("Use o auditório Alfa");
            } else if (convidados <= 220) {
                System.out.println("Use o auditório Alfa");
                System.out.println("Inclua mais " + (convidados - 150) + " cadeiras");
            } else {
                System.out.println("Use o auditório Beta");
            }
        }
    }
}



