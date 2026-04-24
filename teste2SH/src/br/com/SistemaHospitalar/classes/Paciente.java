package br.com.SistemaHospitalar.classes;

public class Paciente {
    private Long id;
    private String CPF;
    private String nome;
    Medico medico;

    public Paciente(Long id, String cPF, String nome, Medico medico) {
        this.id = id;
        CPF = cPF;
        this.nome = nome;
        this.medico = medico;
    }

    @Override
    public String toString() {
        return "Paciente id=" + id + ", CPF=" + CPF + ", nome=" + nome + ", medico=" + medico;
    }

    public Long getId() {
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
