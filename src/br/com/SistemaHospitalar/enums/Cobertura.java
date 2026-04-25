package br.com.SistemaHospitalar.enums;

public enum Cobertura {
    regional, nacional;

    @Override
    public String toString() {
        if (name().equals("regional")) {
            return "Cobertura Regional";
        } else {
            return "Cobertura Nacional";
        }
    }

}