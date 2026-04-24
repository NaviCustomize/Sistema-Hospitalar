package br.com.SistemaHospitalar.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import br.com.SistemaHospitalar.classes.NotaFiscal;

public class CSV {
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
        }
    }
}
