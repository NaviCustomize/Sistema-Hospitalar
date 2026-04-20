package br.com.SistemaHospitalar.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private String url = "jdbc:postgresql://ep-late-unit-ac2y5sui.sa-east-1.aws.neon.tech:5432/neondb";
    private String usuario = "neondb_owner";
    private String senha = "npg_eMyZ8gPD3rvc";

    private Connection connection;

    public Connection getConnection() {
        System.out.println("Conectando no banco de dados....");
        try {
            connection = DriverManager.getConnection(url, usuario, senha);
            if (connection != null) {
                System.out.println("Conectado com sucesso!");
                return connection;
            } else {
                System.out.println("Não foi possível conectar!");
            }

        } catch (SQLException e) {
            System.out.println("Problemas no Driver ou senha incorreta do banco");
            e.printStackTrace();
        }
        return connection;
    }
}