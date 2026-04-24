package br.com.SistemaHospitalar.classes;

import br.com.SistemaHospitalar.enums.StatusLeito;

public class Leito {
    private Integer id;
    private StatusLeito statusLeito;
    private Ala ala;

    public Leito(Integer id, StatusLeito statusLeito, Ala ala) {
        this.id = id;
        this.statusLeito = statusLeito;
        this.ala = ala;
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
