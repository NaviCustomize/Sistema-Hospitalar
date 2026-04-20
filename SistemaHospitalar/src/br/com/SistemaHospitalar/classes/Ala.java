package br.com.SistemaHospitalar.classes;

import java.util.List;

import br.com.SistemaHospitalar.enums.TipoAla;

public class Ala {
    private Integer id;
    private TipoAla tipo_ala;
    private List<Leito> leitos;
    private Hospital hospital;
    public Ala(Integer id, TipoAla tipo_ala, List<Leito> leitos, Hospital hospital) {
        this.id = id;
        this.tipo_ala = tipo_ala;
        this.leitos = leitos;
        this.hospital = hospital;
    }
    public Integer getId() {
        return id;
    }
    public TipoAla getTipo_ala() {
        return tipo_ala;
    }
    public int getLeitos() {
        int contador = 0;
        for (Leito leito : this.leitos) {
            if (leito.getStatusLeito().equals("LIVRE")) {
                contador++;
            }
        }
        return contador;
    }
    public Hospital getHospital() {
        return hospital;
    }
    @Override
    public String toString() {
        return "Ala id=" + id + ", tipo_ala=" + tipo_ala + ", leitos=" + leitos + ", hospital=" + hospital;
    }

    
    
}
