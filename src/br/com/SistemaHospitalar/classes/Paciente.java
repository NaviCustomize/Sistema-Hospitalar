package br.com.SistemaHospitalar.classes;

public class Paciente {

    private Integer id;
    private String CPF;
    private String nome;

    public Paciente(Integer id, String cPF, String nome) {
        this.id = id;
        this.CPF = cPF;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Paciente id=" + id + ", CPF=" + CPF + ", nome=" + nome;
    }

    public Integer getId() {
        return id;
    }

    public String getCPF() {
        return CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
