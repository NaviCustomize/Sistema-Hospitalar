package br.com.SistemaHospitalar.services;

import br.com.SistemaHospitalar.interfaces.ICalculoImposto;
import br.com.SistemaHospitalar.classes.NotaFiscal;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.io.*;
import java.util.Locale;

public class GerenciadorFiscal implements ICalculoImposto {

    @Override
    public BigDecimal calcularISS(BigDecimal v) {
        return v.multiply(new BigDecimal("0.03")).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal calcularPIS(BigDecimal v) {
        return v.multiply(new BigDecimal("0.0065")).setScale(2, RoundingMode.HALF_UP); 
    }

    @Override
    public BigDecimal calcularCOFINS(BigDecimal v) {
        return v.multiply(new BigDecimal("0.03")).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal calcularIRPJ(BigDecimal v) {
        return v.multiply(new BigDecimal("0.012")).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal calcularCSLL(BigDecimal v) {
        return v.multiply(new BigDecimal("0.0108")).setScale(2, RoundingMode.HALF_UP);
    }
}