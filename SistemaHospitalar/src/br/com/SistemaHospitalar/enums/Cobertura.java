package br.com.SistemaHospitalar.enums;

public enum Cobertura {
    REGIONAL, NACIONAL;

    @Override
    public String toString() {
        if (name().equals("REGIONAL")) {
            return "Cobertura Regional";
        } else {
            return "Cobertura Nacional";
        }
    }

}