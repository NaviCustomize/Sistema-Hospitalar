package br.com.SistemaHospitalar.repository;

import br.com.SistemaHospitalar.classes.Fatura;
import br.com.SistemaHospitalar.enums.StatusFatura;

import java.sql.*;
import java.math.BigDecimal;

public class FaturaRepository {

    private Connection conn;

    public FaturaRepository(Connection conn) {
        this.conn = conn;
    }

    public Fatura buscarPorId(Long id) {

        String sql = "SELECT * FROM fatura WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                return null;
            }

            return new Fatura(
            	    rs.getLong("id_fatura"),
            	    rs.getInt("id_paciente"),
            	    rs.getBigDecimal("valor_fatura"),
            	    rs.getDate("data_emissao").toLocalDate(),
            	    rs.getDate("data_vencimento").toLocalDate(),
            	    rs.getString("forma_pagamento"),
            	    StatusFatura.valueOf(rs.getString("status_pagamento").toUpperCase())
            	);

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar fatura", e);
        }
    }
}
