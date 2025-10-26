import java.util.Scanner;

public class CadastroHospedes {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] hospedes = new String[15];
            int count = 0;
            
            OUTER:
            while (true) {
                System.out.print("Digite 1- cadastrar; 2- pesquisar; 3- sair: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {
                    case 1:
                        if (count >= 15) {
                            System.out.println("Máximo de cadastros atingido.");
                        } else {
                            System.out.print("Informe o nome do hóspede: ");
                            hospedes[count] = scanner.nextLine();
                            count++;
                        }   break;
                    case 2:
                        System.out.print("Informe o nome do hóspede a pesquisar: ");
                        String nomePesquisa = scanner.nextLine();
                        boolean encontrado = false;
                        for (int i = 0; i < count; i++) {
                            if (hospedes[i].equalsIgnoreCase(nomePesquisa)) {
                                System.out.println("Hóspede " + nomePesquisa + " foi encontrado no índice " + i);
                                encontrado = true;
                                break;
                            }
                        }   if (!encontrado) {
                            System.out.println("Hóspede não encontrado.");
                        }   break;
                    case 3:
                        break OUTER;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            }
        }
    }
}

