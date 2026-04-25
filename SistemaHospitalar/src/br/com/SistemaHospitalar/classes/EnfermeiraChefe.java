package br.com.SistemaHospitalar.classes;

import br.com.SistemaHospitalar.enums.Turno;

public class EnfermeiraChefe extends Enfermeira {

    private Integer id_enfermeira_chefe;

    public EnfermeiraChefe(Integer id, Ala ala, String cre, Turno enfermeiraTurno, String nome_enfermeira,
            Integer id_enfermeira_chefe) {
        super(id, ala, cre, enfermeiraTurno, nome_enfermeira);
        this.id_enfermeira_chefe = id_enfermeira_chefe;
    }

    @Override
    public String toString() {
        return "EnfermeiraChefe [id_enfermeira_chefe=" + id_enfermeira_chefe + "]";
    }

    public Integer getId_enfermeira_chefe() {
        return id_enfermeira_chefe;
    }

    public void setId_enfermeira_chefe(Integer id_enfermeira_chefe) {
        this.id_enfermeira_chefe = id_enfermeira_chefe;
    }


}