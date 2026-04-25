package br.com.SistemaHospitalar.services;

import br.com.SistemaHospitalar.interfaces.ICalculoImposto;
import br.com.SistemaHospitalar.classes.Fatura;
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

    public NotaFiscal gerarNota(Fatura fatura, int i) {
        
        throw new UnsupportedOperationException("Unimplemented method 'gerarNota'");
    }

    public void exportarCSV(NotaFiscal nf) throws IOException {

        String nomeArq = "NotaFiscal_" + nf.getFatura().getId() + ".csv";
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArq))) {
            // Formato de saída: <Nome>;<valor>;<iss>;<pis>;<cofins>;<irpj>;<csll>
            writer.printf(Locale.US, "%s;%.2f;%.2f;%.2f;%.2f;%.2f;%.2f",
                nf.getFatura().getPaciente().getNome(),
                nf.getFatura().getValor_fatura(),
                nf.getIss(), nf.getPis(), nf.getCofins(), nf.getIrpj(), nf.getCsll());

        System.out.println(">> Arquivo CSV gerado com sucesso: " + nomeArq + " <<\n");

        } catch (IOException erro) {
            System.err.println("Erro de Sistema: Falha ao acessar o disco para gravar o arquivo.");
            System.err.println("Detalhe técnico: " + erro.getMessage());
            erro.printStackTrace();
        }
    }
}