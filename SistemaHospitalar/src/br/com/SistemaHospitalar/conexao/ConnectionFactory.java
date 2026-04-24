package br.com.SistemaHospitalar.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    // Constantes com as credenciais
    private static final String url = "jdbc:postgresql://ep-late-unit-ac2y5sui.sa-east-1.aws.neon.tech:5432/neondb?sslmode=require";
    private static final String usuario = "neondb_owner";
    private static final String senha = "npg_eMyZ8gPD3rvc";

    /**
     * Fabrica e retorna uma nova conexão com o banco de dados.
     * O 'throws SQLException' avisa para a classe Main que ela deve tratar o erro caso a senha ou a internet falhem.
     */
    public static Connection getConnection() throws SQLException {
        
        System.out.println("\n[DB] Iniciando tentativa de conexao com o banco de dados...");
        
        // O DriverManager tenta conectar. Se falhar, ele lança a SQLException automaticamente.
        // Se passar desta linha, é porque conectou com sucesso absoluto.
        Connection conexaoNova = DriverManager.getConnection(url, usuario, senha);
        
        System.out.println("[DB] Conectado com sucesso ao banco de dados!");
        
        return conexaoNova;
    }
}