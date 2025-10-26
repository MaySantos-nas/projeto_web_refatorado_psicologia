package modelo;

import java.time.LocalDateTime;

public class Prontuario {
    private int id;
    private String descricao;
    private LocalDateTime dataRegistro;
    private Paciente paciente;
    private psicologo psicologo;
    private Consulta consulta;

    public Prontuario(int id, String descricao, LocalDateTime dataRegistro, Paciente paciente, psicologo psicologo, Consulta consulta) {
        this.id = id;
        this.descricao = descricao;
        this.dataRegistro = dataRegistro;
        this.paciente = paciente;
        this.psicologo = psicologo;
        this.consulta = consulta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public psicologo getPsicologo() {
        return psicologo;
    }

    public void setpsicologo(psicologo psicologo) {
        this.psicologo = psicologo;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
}

