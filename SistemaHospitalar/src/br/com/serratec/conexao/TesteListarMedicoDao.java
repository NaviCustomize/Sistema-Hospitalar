package br.com.serratec.conexao;

import br.com.serratec.model.Medico;
import br.com.serratec.persistence.MedicoDao;

public class TesteListarMedicoDao {
    public static void main(String[] args) {
        MedicoDao dao = new MedicoDao();
        for (Medico medico : dao.listar()) {
            System.out.println(medico);
        }
    }
}
