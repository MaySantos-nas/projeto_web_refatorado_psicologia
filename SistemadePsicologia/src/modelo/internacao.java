package modelo;

import java.time.LocalDate;

public class internacao {
    private int id;
    private LocalDate dataEntrada;
    private LocalDate dataPrevistaSaida;
    private Paciente paciente;
    private Quarto quarto;

    public internacao(int id, LocalDate dataEntrada, LocalDate dataPrevistaSaida, Paciente paciente, Quarto quarto) {
        this.id = id;
        this.dataEntrada = dataEntrada;
        this.dataPrevistaSaida = dataPrevistaSaida;
        this.paciente = paciente;
        this.quarto = quarto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataPrevistaSaida() {
        return dataPrevistaSaida;
    }

    public void setDataPrevistaSaida(LocalDate dataPrevistaSaida) {
        this.dataPrevistaSaida = dataPrevistaSaida;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }
}

