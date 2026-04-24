package br.com.SistemaHospitalar.classes;

import br.com.SistemaHospitalar.enums.Turno;

public class Enfermeira {
    private Long id;
    private Ala ala;
    private String cre;
    private Turno enfermeiraTurno;
    private String nome_enfermeira;

    public Enfermeira(Long id, Ala ala, String cre, Turno enfermeiraTurno,
            String nome_enfermeira) {
        this.id = id;
        this.ala = ala;
        this.cre = cre;
        this.enfermeiraTurno = enfermeiraTurno;
        this.nome_enfermeira = nome_enfermeira;
    }

    @Override
    public String toString() {
        return "Enfermeira id=" + id + ", ala=" + ala + ", cre=" + cre
                + ", enfermeiraTurno=" + enfermeiraTurno + ", nome_enfermeira=" + nome_enfermeira + "]";
    }

    public Long getId() {
        return id;
    }

    public Ala getAla() {
        return ala;
    }

    public String getCre() {
        return cre;
    }

    public Turno getEnfermeiraTurno() {
        return enfermeiraTurno;
    }

    public String getNome_enfermeira() {
        return nome_enfermeira;
    }

}
