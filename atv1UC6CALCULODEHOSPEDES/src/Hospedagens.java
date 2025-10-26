import java.util.Scanner;

public class Hospedagens {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Informe o valor padrão da diária: R$ ");
            double valorDiaria = scanner.nextDouble();
            scanner.nextLine(); // Consumir a nova linha
            
            int gratuidadeCount = 0;
            int meiaCount = 0;
            double total = 0;
            
            while (true) {
                System.out.print("Informe o nome do hóspede (ou digite 'PARE' para encerrar): ");
                String nome = scanner.nextLine();
                if (nome.equalsIgnoreCase("PARE")) {
                    break;
                }
                
                System.out.print("Informe a idade do hóspede: ");
                int idade = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha
                
                if (idade < 4) {
                    System.out.println(nome + " possui gratuidade.");
                    gratuidadeCount++;
                } else if (idade > 80) {
                    System.out.println(nome + " paga meia.");
                    meiaCount++;
                    total += valorDiaria / 2;
                } else {
                    total += valorDiaria;
                }
            }
            
            System.out.println("Total de hospedagens: R$ " + total + "; " + gratuidadeCount + " gratuidade(s); " + meiaCount + " meia(s)");
        }
    }
}

