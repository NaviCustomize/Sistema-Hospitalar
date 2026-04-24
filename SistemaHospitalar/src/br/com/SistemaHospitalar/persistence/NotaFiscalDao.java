package br.com.SistemaHospitalar.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.SistemaHospitalar.classes.NotaFiscal;
import br.com.SistemaHospitalar.conexao.ConnectionFactory;

public class NotaFiscalDao {
    private Connection connection;

    public NotaFiscalDao() {
        connection = new ConnectionFactory().getConnection();
    }

    public NotaFiscal gerarNotaFiscal(NotaFiscal nota) {
        String sql1 = "Select * from sistema_hospitalar.fatura";
        String sql2 = "Insert into sistema_hospitalar.nota_fiscal (id_fatura, valor_pis, valor_cofins, valor_iss, valor_irpj, valor_csll, valor_total, forma_pagamento) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        List<NotaFiscal> notasFiscais = new ArrayList<>();
        try {
            PreparedStatement stmt2 = connection.prepareStatement(sql2);
            ResultSet rs2 = stmt2.executeQuery();
            
                stmt2.setInt(1, nota.getFatura().getId());
                stmt2.setBigDecimal(2, nota.getPis());
                stmt2.setBigDecimal(3, nota.getCofins());
                stmt2.setBigDecimal(4, nota.getIss());
                stmt2.setBigDecimal(5, nota.getIrpj());
                stmt2.setBigDecimal(6, nota.getCsll());
                stmt2.setBigDecimal(7, nota.getFatura().getValor_fatura());
                stmt2.setString(8, nota.getFatura().getForma_pagamento());

        } catch (SQLException e) {
            System.out.println("Falha em criar as notas fiscais!");
            e.printStackTrace();
        }
        return notasFiscais;
    }
}
