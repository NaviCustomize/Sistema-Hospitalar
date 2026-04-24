package br.com.SistemaHospitalar.enums;

public enum StatusFatura {
    PENDENTE("pendente"),
    PAGO("pago"),
    CANCELADO("cancelado"),
    EM_ANALISE("em_analise"); 

    private String textoNoBanco;

    StatusFatura(String textoNoBanco) {
        this.textoNoBanco = textoNoBanco;
    }

    public static StatusFatura converterDoBanco(String texto) {
        if (texto == null) return null;
        
        for (StatusFatura status : StatusFatura.values()) {
            if (status.textoNoBanco.equalsIgnoreCase(texto) || status.name().equalsIgnoreCase(texto)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Status desconhecido no banco de dados: " + texto);
    }
}