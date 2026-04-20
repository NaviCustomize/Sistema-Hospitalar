package br.com.SistemaHospitalar.conexao;

import br.com.SistemaHospitalar.model.Medico;
import br.com.SistemaHospitalar.persistence.MedicoDao;

public class TesteListarMedicoDao {
    public static void main(String[] args) {
        MedicoDao dao = new MedicoDao();
        for (Medico medico : dao.listar()) {
            System.out.println(medico);
        }
    }
}
