package br.com.serratec.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.serratec.conexao.ConnectionFactory;
import br.com.serratec.model.Medico;

public class MedicoDao {
    private Connection connection;

    public MedicoDao() {
        connection = new ConnectionFactory().getConnection();
        }

    public List<Medico> listar() {
        String sql = "select * from medico";
        List<Medico> medicos = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Medico medico = new Medico(rs.getInt("id"), rs.getString("nome"), rs.getString("especialidade"), rs.getString("CRM"));
                medicos.add(medico);
            }
            rs.close();
            stmt.close();
            connection.close();

        } catch (SQLException e) {
            System.err.println("Problemas ao listar os clientes");
            e.printStackTrace();
        }
        return medicos;
    }

    public void inserirMedico(Medico medico){
        String postgresql = "insert into medico (nome, especialidade, CRM) values (?, ?, ?);";
        try{
            PreparedStatement stmt = connection.prepareStatement(postgresql);
            stmt.setString(1, medico.getNome());
            stmt.setString(2, medico.getEspecialidade());
            stmt.setString(3, medico.getCrm());
            stmt.execute();
            stmt.close();
            System.out.println("Medico inserido.");
            connection.close();
        } catch (SQLException e){
            System.out.println("Medico não inserido!");
            e.printStackTrace();
        }
    }

}
