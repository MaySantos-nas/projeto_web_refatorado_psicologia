public class PacoteViagem {
    private Transporte transporte;
    private Hospedagem hospedagem;
    private String destino;
    private int quantidadeDias;

    public PacoteViagem(Transporte transporte, Hospedagem hospedagem, String destino, int quantidadeDias) {
        this.transporte = transporte;
        this.hospedagem = hospedagem;
        this.destino = destino;
        this.quantidadeDias = quantidadeDias;
    }

    public double calcularTotalHospedagem() {
        return hospedagem.getValorDiaria() * quantidadeDias;
    }

    public double calcularValorLucro(double margem) {
        return transporte.getValor() + (transporte.getValor() * margem / 100);
    }

    public double calcularTotalPacote(double margem, double taxasAdicionais) {
        double totalHospedagem = calcularTotalHospedagem();
        double totalTransporte = calcularValorLucro(margem);
        return totalTransporte + totalHospedagem + taxasAdicionais;
    }

    public String getDestino() {
        return destino;
    }
}
