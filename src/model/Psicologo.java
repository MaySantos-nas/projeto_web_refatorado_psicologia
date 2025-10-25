package model;

public class Psicologo {
    private int id;
    private String nome;
    private String crp;
    private String especializacao;
    private String telefone;

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrp() {
        return crp;
    }

    public void setCrp(String crp) {
        this.crp = crp;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Exibir no console
    @Override
    public String toString() {
        return "Psicologo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", crp='" + crp + '\'' +
                ", especializacao='" + especializacao + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
