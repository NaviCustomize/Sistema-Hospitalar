package br.com.SistemaHospitalar.services;

import br.com.SistemaHospitalar.interfaces.ICalculoImposto;
import br.com.SistemaHospitalar.classes.Fatura;
import br.com.SistemaHospitalar.classes.NotaFiscal;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.io.*;
import java.util.Locale;

public class GerenciadorFiscal implements ICalculoImposto {

    public NotaFiscal gerarNota(Fatura fatura, int idNotaProvisorio) {
        BigDecimal valorTotal = fatura.getValor_fatura();

        BigDecimal iss = valorTotal.multiply(new BigDecimal("0.03")).setScale(2, RoundingMode.HALF_UP);
        BigDecimal pis = valorTotal.multiply(new BigDecimal("0.0065")).setScale(2, RoundingMode.HALF_UP);
        BigDecimal cofins = valorTotal.multiply(new BigDecimal("0.03")).setScale(2, RoundingMode.HALF_UP);
        BigDecimal irpj = valorTotal.multiply(new BigDecimal("0.012")).setScale(2, RoundingMode.HALF_UP);
        BigDecimal csll = valorTotal.multiply(new BigDecimal("0.0108")).setScale(2, RoundingMode.HALF_UP);

        return new NotaFiscal(idNotaProvisorio, fatura, fatura.getForma_pagamento(), iss, pis, cofins, irpj, csll);
    }

    public void exportarCSV(NotaFiscal nf) throws IOException {

        String nomeArq = "NotaFiscal_" + nf.getFatura().getId() + ".csv";
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArq))) {
            // Formato de saída: <Nome>;<valor>;<iss>;<pis>;<cofins>;<irpj>;<csll>
            writer.printf(Locale.ROOT, "%s;%.2f;%.2f;%.2f;%.2f;%.2f;%.2f",
                nf.getFatura().getPaciente().getNome(),
                nf.getFatura().getValor_fatura(),
                nf.getIss(), nf.getPis(), nf.getCofins(), nf.getIrpj(), nf.getCsll());

            FileOutputStream caminhoArquivo = new FileOutputStream("\\notaFiscal\\Nota_Fiscal_.csv");
            ObjectOutputStream gravarObjeto = new ObjectOutputStream(caminhoArquivo);
            gravarObjeto.writeObject(nf.toString());
            gravarObjeto.flush();
            gravarObjeto.close();
            caminhoArquivo.flush();
            caminhoArquivo.close();



        System.out.println(">> Arquivo CSV gerado com sucesso: " + nomeArq + " <<\n");

        } catch (IOException erro) {
            System.err.println("Erro de Sistema: Falha ao acessar o disco para gravar o arquivo.");
            System.err.println("Detalhe técnico: " + erro.getMessage());
            erro.printStackTrace();
        }
    }

    @Override
    public BigDecimal calcularISS(BigDecimal valor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularISS'");
    }

    @Override
    public BigDecimal calcularPIS(BigDecimal valor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularPIS'");
    }

    @Override
    public BigDecimal calcularCOFINS(BigDecimal valor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularCOFINS'");
    }

    @Override
    public BigDecimal calcularIRPJ(BigDecimal valor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularIRPJ'");
    }

    @Override
    public BigDecimal calcularCSLL(BigDecimal valor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularCSLL'");
    }
}