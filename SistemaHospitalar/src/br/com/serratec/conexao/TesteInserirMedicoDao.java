package br.com.serratec.conexao;

import java.util.Scanner;

import br.com.serratec.model.Medico;
import br.com.serratec.persistence.MedicoDao;

public class TesteInserirMedicoDao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        MedicoDao dao = new MedicoDao();

        System.out.println("Digite o nome do médico:");
        String nome = sc.next();

        System.out.println("Digite a especialidade do médico:");
        String especialidade = sc.next();

        System.out.println("Digite o CRM do médico:");
        String crm = sc.next();

        Medico medico = new Medico(null, nome, especialidade, crm);
        dao.inserirMedico(medico);
    }
}
