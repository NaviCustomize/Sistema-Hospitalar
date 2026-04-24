package br.com.SistemaHospitalar.classes;


import java.security.Provider.Service;

import java.util.Scanner;

import br.com.SistemaHospitalar.services.GerenciadorFiscal;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		GerenciadorFiscal gf = new GerenciadorFiscal();
		
		System.out.println("--------------Sistema de Gestão Hospitalar, Geração de NF-------------------");
	
		while(true) {
			
			System.out.println("\n1 - Criar nota fiscal com a fatura: ");
			System.out.println("2 - Buscar nota fiscal: ");
			System.out.println("3 - Sair: ");
			
			int menu = sc.nextInt();
			
			try {
				
				switch(menu) {
					
					case 1:
						System.out.println("Infome o numero da fatura: ");
						String id_fatura = sc.nextLine();
						NotaFiscal nf = gf.exportarCSV(id_fatura);
						break;
					case 2:
						
						System.out.println("Infome o id da nota fiscal: ");
						Integer idNotaFiscal = Integer.parseInt(sc.nextLine());
						Integer nf = services.buscarNotaFiscal(idNotaFiscal);
						break;
					case 3:
						System.out.println("Fechando o programa...");
						return;
					default:
						System.out.println("Escolha um numero de 1 ate 3");
						break;
				}
				
			}//catch(FaturaNaoEncontradaException e) {
				//System.err.println("Erro: " + e.getMessage);
			//}
			catch(NumberFormatException e) {
				System.err.println("Erro: Apenas numero.");
			}catch(Exception e) {
				System.out.println("Erro: Algo inesperado aconteceu");
				e.printStackTrace();
			}
			
		}
	}
	
}
