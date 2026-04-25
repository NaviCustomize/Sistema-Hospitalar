package br.com.SistemaHospitalar.classes;

public class Medico {
    private Integer id;
    private String nome;
    private String especialidade;
    private String CRM;

    public Medico(Integer id, String nome, String especialidade, String crm) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
        this.CRM = crm;
    }

    @Override
    public String toString() {
        return "Medico id = " + id + ", nome = " + nome + ", especialidade = " + especialidade + ", crm = " + CRM;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getCrm() {
        return CRM;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setCRM(String cRM) {
        CRM = cRM;
    }

    

}
