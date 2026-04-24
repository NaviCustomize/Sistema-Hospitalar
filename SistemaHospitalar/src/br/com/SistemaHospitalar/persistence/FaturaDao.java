package br.com.SistemaHospitalar.persistence;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.SistemaHospitalar.classes.Fatura;
import br.com.SistemaHospitalar.conexao.ConnectionFactory;
import br.com.SistemaHospitalar.exception.FaturaNaoEncontradaException;

public class FaturaDao {

    private Connection connection;

    public FaturaDao() {
        connection = new ConnectionFactory().getConnection();
        }
    public Fatura buscarPorNumero(int idFatura) throws FaturaNaoEncontradaException {
        
        String sql = "SELECT id_fatura, valor_fatura, status_pagamento FROM sistema_hospitalar.fatura WHERE id_fatura = ?";
        Fatura fatura = new Fatura(idFatura, null, null, null, null, sql, null);

        try  {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, idFatura);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                fatura = new Fatura(idFatura, null, null, null, null, sql, null);
                fatura.setId(rs.getInt("id_fatura"));
                
                fatura.setValor_fatura(rs.getBigDecimal("valor_fatura"));
                
                fatura.setForma_pagamento(rs.getString("status_pagamento"));
                
            } else {
                throw new FaturaNaoEncontradaException("Fatura inexistente.");
            }

        } catch (SQLException e) {
            System.out.println("Erro crítico ao acessar o banco de dados: " + e.getMessage());
        }

        return fatura;
    }
}