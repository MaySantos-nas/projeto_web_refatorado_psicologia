import java.util.Scanner;

public class OcupacaoQuartos {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean[][] quartos = new boolean[4][3]; // 4 andares, 3 quartos por andar
            
            while (true) {
                System.out.print("Informe Andar (1-4) e Quarto (1-3): ");
                int andar = scanner.nextInt() - 1;
                int quarto = scanner.nextInt() - 1;
                
                if (andar < 0 || andar > 3 || quarto < 0 || quarto > 2) {
                    System.out.println("Andar ou quarto inválido.");
                    continue;
                }
                
                quartos[andar][quarto] = true;
                
                System.out.print("Deseja informar outra ocupação? (S/N): ");
                char resposta = scanner.next().charAt(0);
                if (resposta == 'N' || resposta == 'n') {
                    break;
                }
            }
            
            System.out.println("Ocupação do hotel:");
            for (int i = 0; i < quartos.length; i++) {
                System.out.println((i + 1) + "º andar:");
                for (int j = 0; j < quartos[i].length; j++) {
                    if (quartos[i][j]) {
                        System.out.println("- quarto " + (j + 1) + " ocupado");
                    } else {
                        System.out.println("- quarto " + (j + 1) + " desocupado");
                    }
                }
            }
        } // 4 andares, 3 quartos por andar
    }
}

