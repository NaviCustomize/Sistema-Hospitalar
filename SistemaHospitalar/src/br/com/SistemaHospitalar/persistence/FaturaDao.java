package br.com.SistemaHospitalar.persistence;

import java.sql.Connection;
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

    public Fatura buscarFatura(int numeroFatura) throws FaturaNaoEncontradaException {
        String sql = "select * from fatura where id_fatura = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, numeroFatura);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                
                stmt.setInt(1, fatura.getId());
                stmt.setBigDecimal(2, fatura.getValor_fatura());
                

                stmt.execute();
                stmt.close();
                connection.close();
            } else {
                throw new FaturaNaoEncontradaException("Fatura inexistente");
            }

        } catch (SQLException e) {
            System.out.println("Problema ao buscar a fatura");
            e.printStackTrace();
        }
        return fatura;
    }
}
