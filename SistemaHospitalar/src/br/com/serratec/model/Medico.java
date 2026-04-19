package br.com.serratec.model;

public class Medico {
    private Integer id;
    private String nome;
    private String especialidade;
    private String CRM;

    public Medico(int id, String nome, String especialidade, String crm) {
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

}
