package model;

public class Quarto {
    private int id;
    private int numero; 
    private String tipo;
    private boolean disponibilidade;

    // Getters e Setters
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

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    // Opcional: facilitar exibição no console
    @Override
    public String toString() {
        return "Quarto{" +
                "id=" + id +
                ", numero=" + numero +
                ", tipo='" + tipo + '\'' +
                ", disponibilidade=" + disponibilidade +
                '}';
    }
}


