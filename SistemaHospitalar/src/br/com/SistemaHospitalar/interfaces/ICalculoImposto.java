package br.com.SistemaHospitalar.interfaces;

import java.math.BigDecimal;

public interface ICalculoImposto {
    BigDecimal calcularISS(BigDecimal valor);
    BigDecimal calcularPIS(BigDecimal valor);
    BigDecimal calcularCOFINS(BigDecimal valor);
    BigDecimal calcularIRPJ(BigDecimal valor);
    BigDecimal calcularCSLL(BigDecimal valor);    
}