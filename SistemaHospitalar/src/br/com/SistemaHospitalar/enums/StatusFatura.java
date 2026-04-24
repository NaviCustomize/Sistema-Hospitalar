package br.com.SistemaHospitalar.enums;

public enum StatusFatura {
    pendente, pago, cancelado, em_analise;

    public static StatusFatura fromString(String status) {
            for (StatusFatura s : StatusFatura.values()) {
                if (s.name().equalsIgnoreCase(status)) {
                    return s;
                }
            }
            throw new IllegalArgumentException("Status não encontrado: " + status);
    }
}