import java.util.Scanner;

public class TrocaDeQuartos {
    public static void main(String[] args) {
        // Informações do primeiro cliente
        try (Scanner scanner = new Scanner(System.in)) {
            // Informações do primeiro cliente
            System.out.print("Informe o nome do cliente 1: ");
            String nome1 = scanner.nextLine();
            System.out.print("Informe a idade do cliente 1: ");
            int idade1 = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha
            
            // Informações do segundo cliente
            System.out.print("Informe o nome do cliente 2: ");
            String nome2 = scanner.nextLine();
            System.out.print("Informe a idade do cliente 2: ");
            int idade2 = scanner.nextInt();
            
            String quartoA;
            String quartoB;
            String desconto = "";
            
            if (idade1 < idade2) {
                quartoA = nome2;
                quartoB = nome1;
                if (idade2 >= 60) {
                    desconto = " com desconto de 40%";
                }
            } else {
                quartoA = nome1;
                quartoB = nome2;
                if (idade1 >= 60) {
                    desconto = " com desconto de 40%";
                }
            }
            
            System.out.println("Quarto A: " + quartoA + desconto + "; Quarto B: " + quartoB);
        }
    }
}

