package br.com.SistemaHospitalar.conexao;

import java.util.Scanner;

import br.com.SistemaHospitalar.classes.Fatura;
import br.com.SistemaHospitalar.exception.FaturaNaoEncontradaException;
import br.com.SistemaHospitalar.persistence.FaturaDao;

public class TesteFaturaDao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FaturaDao dao = new FaturaDao();

        System.out.print("Digite o número da fatura que deseja pesquisar: ");
        int numeroDigitado = scanner.nextInt();

        try {
            Fatura faturaEncontrada = dao.buscarPorNumero(numeroDigitado);

            System.out.println("Fatura encontrada com sucesso!");
            System.out.println("Id da fatura: " + faturaEncontrada.getId());
            System.out.println("Valor: R$ " + faturaEncontrada.getValor_fatura());
            System.out.println("Status da fatura: " + faturaEncontrada.getStatusFatura());


        } catch (FaturaNaoEncontradaException e) {
            System.out.println("Atenção: " + e.getMessage());
        }

        scanner.close();
    }
}
