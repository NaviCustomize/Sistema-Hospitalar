package br.com.SistemaHospitalar.persistence;

import java.sql.Connection;
import java.sql.SQLException;

        /**
         * Busca uma nota fiscal ja existente no historico do banco.
         */
public class buscarNotaFiscalNoBanco {
    private static void buscarNotaFiscalNoBanco(Connection conexao, int idNotaParaBusca) throws SQLException {
            
        String sqlBuscaNota = "SELECT * FROM nota_fiscal WHERE id = ?";
            
        try (PreparedStatement declaracaoSQL = conexao.prepareStatement(sqlBuscaNota)) {
                
            declaracaoSQL.setInt(1, idNotaParaBusca);
            ResultSet resultado = declaracaoSQL.executeQuery();
        }
    }
}