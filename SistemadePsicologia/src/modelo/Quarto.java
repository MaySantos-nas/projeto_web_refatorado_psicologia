package modelo;

public class Quarto {
    private int id;
    private int numero;
    private String tipo;
    private boolean disponivel;

    public Quarto(int id, int numero, String tipo, boolean disponivel) {
        this.id = id;
        this.numero = numero;
        this.tipo = tipo;
        this.disponivel = disponivel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}

