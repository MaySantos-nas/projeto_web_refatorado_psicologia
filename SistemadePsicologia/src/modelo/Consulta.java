package modelo;

import java.time.LocalDateTime;

public class Consulta {
    private int id;
    private LocalDateTime dataHora;
    private double valor;
    private String observacoes;
    private Paciente paciente;
    private psicologo psicologo;

    public Consulta() {}

    public Consulta(int id, LocalDateTime dataHora, double valor, String observacoes, Paciente paciente, psicologo psicologo) {
        this.id = id;
        this.dataHora = dataHora;
        this.valor = valor;
        this.observacoes = observacoes;
        this.paciente = paciente;
        this.psicologo = psicologo;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public psicologo getPsicologo() { return psicologo; }
    public void setPsicologo(psicologo psicologo) { this.psicologo = psicologo; }
}

