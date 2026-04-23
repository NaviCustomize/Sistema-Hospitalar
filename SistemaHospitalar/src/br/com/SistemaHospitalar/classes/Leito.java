package br.com.SistemaHospitalar.classes;

import br.com.SistemaHospitalar.enums.StatusLeito;

public class Leito {
    private Integer id;
    private StatusLeito statusLeito;
    private Ala ala;

    @Override
    public String toString() {
        return "Leito [id=" + id + ", statusLeito=" + statusLeito + ", ala=" + ala + "]";
    }

    public Integer getId() {
        return id;
    }
    public StatusLeito getStatusLeito() {
        return statusLeito;
    }
    public Ala getAla() {
        return ala;
    }
 
}