package br.com.SistemaHospitalar.classes;

public class Paciente {
    private Integer id;
    private String CPF;
    private String nome;
    Medico medico;

    public Paciente(Integer id, String cPF, String nome, Medico medico) {
        this.id = id;
        CPF = cPF;
        this.nome = nome;
        this.medico = medico;
    }

    public Paciente(String string, String string2) {
    }

    @Override
    public String toString() {
        return "Paciente id=" + id + ", CPF=" + CPF + ", nome=" + nome + ", medico=" + medico;
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

    public Medico getMedico() {
        return medico;
    }
}
