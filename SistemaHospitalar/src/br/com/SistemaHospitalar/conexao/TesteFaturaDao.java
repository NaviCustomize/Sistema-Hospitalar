package br.com.SistemaHospitalar.conexao;

import java.util.Scanner;

import br.com.SistemaHospitalar.classes.Fatura;
import br.com.SistemaHospitalar.exception.FaturaNaoEncontradaException;
import br.com.SistemaHospitalar.persistence.FaturaDao;

public class TesteFaturaDao {
    public static void main(String[] args) throws FaturaNaoEncontradaException {
        Scanner scanner = new Scanner(System.in);
        FaturaDao dao = new FaturaDao();

        System.out.print("Digite o número da fatura que deseja pesquisar: ");
        int numeroDigitado = scanner.nextInt();

        Fatura faturaEncontrada = dao.buscarFatura(numeroDigitado);
        
        System.out.println("Fatura encontrada com sucesso!");
        System.out.println("Valor: R$ " + faturaEncontrada.getValor_fatura());
        System.out.println("Status: " + faturaEncontrada.getStatusFatura());
        
        scanner.close();
    }
}