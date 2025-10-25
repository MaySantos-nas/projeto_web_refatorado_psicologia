package model;

import java.util.Date;

public class Prontuario {
    private int id;
    private int idPaciente;
    private int idPsicologo;
    private Date dataRegistro;
    private String descricao;

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
    public Date getDataRegistro() {
        return dataRegistro;
    }
    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
