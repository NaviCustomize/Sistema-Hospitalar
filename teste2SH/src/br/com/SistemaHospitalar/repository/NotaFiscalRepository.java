package br.com.SistemaHospitalar.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.SistemaHospitalar.classes.NotaFiscal;

public class NotaFiscalRepository {

    private Connection conn;

    public NotaFiscalRepository(Connection conn) {
        this.conn = conn;
    }

    public void salvar(NotaFiscal nf) {
        String sql = """
            INSERT INTO nota_fiscal
            (paciente, valor, iss, pis, cofins, irpj, csll)
            VALUES (?, ?, ?, ?, ?, ?, ?)
        """;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nf.getFatura().getPaciente().toString());
            ps.setBigDecimal(2, nf.getValor());
            ps.setBigDecimal(3, nf.getIss());
            ps.setBigDecimal(4, nf.getPis());
            ps.setBigDecimal(5, nf.getCofins());
            ps.setBigDecimal(6, nf.getIrpj());
            ps.setBigDecimal(7, nf.getCsll());

            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
