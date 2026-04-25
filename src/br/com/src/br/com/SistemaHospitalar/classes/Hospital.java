package br.com.SistemaHospitalar.classes;

public class Hospital {
    private Integer id;
    private String cnpj;
    private String nome_hospital;
    private Integer telefone;
    private String email;
    private String endereco;

    public Hospital(Integer id, String cnpj, String nome_hospital, Integer telefone, String email, String endereco) {
        this.id = id;
        this.cnpj = cnpj;
        this.nome_hospital = nome_hospital;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Hospital id=" + id + ", cnpj=" + cnpj + ", nome_hospital=" + nome_hospital + ", telefone=" + telefone
                + ", email=" + email + ", endereco=" + endereco;
    }

    public Integer getId() {
        return id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getNome_hospital() {
        return nome_hospital;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }

}
