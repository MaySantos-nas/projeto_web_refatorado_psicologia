package model;

import java.util.Date;

public class Consulta {
    private int id;
    private int idPaciente;
    private int idPsicologo;
    private Date dataConsulta;
    private String horario;
    private String observacoes;

    // Getters e Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdPaciente() {
        return idPaciente;
    }
    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
    public int getIdPsicologo() {
        return idPsicologo;
    }
    public void setIdPsicologo(int idPsicologo) {
        this.idPsicologo = idPsicologo;
    }
    public Date getDataConsulta() {
        return dataConsulta;
    }
    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }
    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }
    public String getObservacoes() {
        return observacoes;
    }
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}

