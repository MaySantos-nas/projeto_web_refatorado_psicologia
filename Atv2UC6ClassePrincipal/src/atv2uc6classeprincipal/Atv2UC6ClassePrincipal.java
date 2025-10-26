import java.util.Scanner;

public class SistemaViagens {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Cadastro de Transporte
        System.out.print("Informe o tipo de transporte (aéreo, rodoviário, marítimo): ");
        String tipoTransporte = scanner.nextLine();
        System.out.print("Informe o valor do transporte: ");
        double valorTransporte = scanner.nextDouble();
        Transporte transporte = new Transporte(tipoTransporte, valorTransporte);

        // Cadastro de Hospedagem
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Informe a descrição da hospedagem: ");
        String descricaoHospedagem = scanner.nextLine();
        System.out.print("Informe o valor da diária da hospedagem: ");
        double valorDiaria = scanner.nextDouble();
        Hospedagem hospedagem = new Hospedagem(descricaoHospedagem, valorDiaria);

        // Cadastro de Pacote de Viagem
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Informe o destino: ");
        String destino = scanner.nextLine();
        System.out.print("Informe a quantidade de dias: ");
        int quantidadeDias = scanner.nextInt();
        PacoteViagem pacote = new PacoteViagem(transporte, hospedagem, destino, quantidadeDias);

        // Cálculo de margem de lucro e taxas adicionais
        System.out.print("Informe a margem de lucro (em porcentagem): ");
        double margemLucro = scanner.nextDouble();
        System.out.print("Informe o valor das taxas adicionais: ");
        double taxasAdicionais = scanner.nextDouble();

        // Mostrando o valor total do pacote
        double totalPacote = pacote.calcularTotalPacote(margemLucro, taxasAdicionais);
        System.out.println("Valor total do pacote (em dólares): " + totalPacote);

        // Cadastro da Venda
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Informe o nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("Informe a forma de pagamento: ");
        String formaPagamento = scanner.nextLine();
        Venda venda = new Venda(nomeCliente, formaPagamento, pacote);

        // Informando a cotação do dólar
        System.out.print("Informe a cotação do dólar: ");
        double cotacaoDolar = scanner.nextDouble();

        // Mostrando as informações da venda
        venda.mostrarInformacoesVenda(cotacaoDolar);

        scanner.close();
    }
}

