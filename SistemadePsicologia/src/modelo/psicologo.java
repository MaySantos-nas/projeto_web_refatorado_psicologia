package modelo;

public class psicologo {
    private int id;
    private String nome;
    private String crp;
    private String especialidade;
    private String telefone;

    public psicologo() {}

    public psicologo(int id, String nome, String crp, String especialidade, String telefone) {
        this.id = id;
        this.nome = nome;
        this.crp = crp;
        this.especialidade = especialidade;
        this.telefone = telefone;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCrp() { return crp; }
    public void setCrp(String crp) { this.crp = crp; }

    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
}
