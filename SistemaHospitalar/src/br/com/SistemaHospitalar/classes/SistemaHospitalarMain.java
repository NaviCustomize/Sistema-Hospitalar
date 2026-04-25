package br.com.SistemaHospitalar.classes;

import java.io.IOException;
import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import br.com.SistemaHospitalar.conexao.ConnectionFactory;
import br.com.SistemaHospitalar.enums.StatusFatura;
import br.com.SistemaHospitalar.exception.FaturaNaoEncontradaException;
import br.com.SistemaHospitalar.services.GerenciadorFiscal;

/**
 * Classe Principal do Sistema Hospitalar.
 * Responsável por gerenciar a interação com o usuário, 
 * realizar consultas no banco de dados e processar as notas fiscais.
 */
public class SistemaHospitalarMain {

    public static void main(String[] args) {
        
        // Objeto responsável por ler as entradas do teclado
        Scanner leitorDeEntradas = new Scanner(System.in);
        
        // Serviço que contém as regras de negócio e cálculos de impostos
        GerenciadorFiscal servicoFiscal = new GerenciadorFiscal();

        System.out.println("=========================================================================");
        System.out.println("                     SISTEMA DE GESTAO HOSPITALAR                        ");
        System.out.println("                       UNIDADE: PETROPOLIS 2026                          ");
        System.out.println("=========================================================================");
        
        // Bloco try-with-resources para garantir que a conexao com o banco seja fechada
        // O Java vai buscar a conexao pronta que esta na sua classe ConnectionFactory
        try (Connection conexaoComBanco = ConnectionFactory.getConnection()) {
            
            System.out.println("\n[INFO] conexao com o banco de dados estabelecida com sucesso.");
            
            boolean sistemaEmExecucao = true;

            while (sistemaEmExecucao) {

                System.out.println("\n-------------------------------------------------------------------------");
                System.out.println("MENU PRINCIPAL:");
                System.out.println("1 - Pesquisar Fatura e Gerar Nota Fiscal (.csv e Banco)");
                System.out.println("2 - Consultar Historico de Notas Fiscais Existentes (Busca por ID)");
                System.out.println("0 - Sair do Sistema");
                System.out.print("\nSelecione a opcao desejada: ");    

                try {
                    int opcaoEscolhida = leitorDeEntradas.nextInt();
                    
                    switch (opcaoEscolhida) {
                        
                        case 1:
                            System.out.print("Digite o numero de identificacao (ID) da fatura que deseja processar: ");
                            int idFaturaBusca = leitorDeEntradas.nextInt();
                            
                            processarGeracaoDeNotaFiscal(conexaoComBanco, idFaturaBusca, servicoFiscal);
                            break;

                        case 2:
                            System.out.print("Digite o numero de identificacao (ID) da Nota Fiscal: ");
                            int idNotaParaBusca = leitorDeEntradas.nextInt();
                            
                            // Chama o metodo para busca dos dados ja salvos na tabela nota_fiscal
                            buscarNotaFiscalNoBanco(conexaoComBanco, idNotaParaBusca);
                            break;

                        case 0:
                            System.out.println("\nFinalizando sistema hospitalar... Até logo!");
                            return;

                        default:
                            System.out.println("\n[AVISO] Opcao invalida! Escolha entre 0, 1 ou 2.");
                            break;
                    
                    }

                } catch (InputMismatchException erroDeEntrada) {
                    // Tratamento para quando o usuario digita letras em campos numericos
                    System.err.println("\n[ERRO] Entrada invalida! Por favor, utilize apenas numeros inteiros.");
                    leitorDeEntradas.nextLine(); // Limpa o buffer para evitar loop infinito
                
                } catch (FaturaNaoEncontradaException erroDeNegocio) {
                    // Faturas inexistentes
                    System.err.println("\n[AVISO] " + erroDeNegocio.getMessage());
                
                } catch (SQLException erroDeBanco) {
                    // Tratamento para falhas de comunicacao com o PostgreSQL
                    System.err.println("\n[ERRO DE BANCO] Ocorreu uma falha na comunicacao com o banco de dados.");
                    System.err.println("Causa: " + erroDeBanco.getMessage());
                } catch (IOException erro) {
                    erro.printStackTrace();
                }
            }

        } catch (SQLException erroCritico) {
            System.err.println("\n[ERRO CRITICO] Nao foi possivel iniciar a conexao com o banco de dados.");
            System.err.println("Verifique as credenciais no ConnectionFactory.");
            erroCritico.printStackTrace();

        } finally {
            leitorDeEntradas.close();
            System.out.println("\n=========================================================================");
            System.out.println("                SESSAO ENCERRADA - HOSPITAL PETRÓPOLIS                     ");
            System.out.println("===========================================================================");
        }

        }   
        /**
         * Metodo para buscar fatura, calcular impostos, gerar CSV e salvar no banco.
         * @throws IOException 
         */
        
        private static void processarGeracaoDeNotaFiscal(Connection conexao, int idFatura, GerenciadorFiscal servico) 
            throws SQLException, FaturaNaoEncontradaException, IOException {
            
            // Busca a fatura no banco usando JOIN para trazer os dados do paciente
            Fatura faturaLocalizada = realizarBuscaDeFaturaNoBanco(conexao, idFatura);
                
            if (faturaLocalizada == null) {
                throw new FaturaNaoEncontradaException("A Fatura com o numero " + idFatura + " nao foi localizada no sistema.");
            }   

            System.out.println("\n[INFO] Fatura encontrada! Valor Total: R$ " + faturaLocalizada.getValor_fatura());
            System.out.println("[INFO] O Gerenciador Fiscal está a processar os impostos...");

            // Calcula os impostos e cria o objeto NotaFiscal
            // Aqui definimos um ID inicial 1 para a nota, o banco gerara o ID real no INSERT
            NotaFiscal novaNotaFiscal = servico.gerarNota(faturaLocalizada, 1);
            
            // Exibe o resumo formatado no terminal (Usa o toString() da NotaFiscal)
            System.out.println(novaNotaFiscal.toString());

            // Gera o arquivo fisico .csv e separado por ponto e virgula (;)
            servico.exportarCSV(novaNotaFiscal);

            // Persiste os dados calculados na tabela nota_fiscal do banco de dados
            gravarNotaFiscalNoBanco(conexao, novaNotaFiscal);
        }

        /**
         * Executa a consulta SQL para buscar a fatura e os dados do paciente.
         */
        private static Fatura realizarBuscaDeFaturaNoBanco(Connection conexao, int idFatura) throws SQLException {
            
            String sqlBusca = "SELECT f.*, p.nome_paciente AS nome_paciente, p.documento AS documento_paciente " +
                            "FROM sistema_hospitalar.fatura f " +
                            "INNER JOIN sistema_hospitalar.paciente p ON f.id_paciente = p.id_paciente " +
                            "WHERE f.id_fatura = ?";
            
            try (PreparedStatement declaracaoSQL = conexao.prepareStatement(sqlBusca)) {
                
                declaracaoSQL.setInt(1, idFatura);
                ResultSet resultado = declaracaoSQL.executeQuery();

                if (resultado.next()) {
                    // Instancia o paciente com os dados do banco
                    Paciente pacienteEncontrado = new Paciente(
                        resultado.getInt("id_paciente"),
                        resultado.getString("nome_paciente"), 
                        resultado.getString("documento_paciente")
                    );


                    // Retorna a fatura preenchida
                    return new Fatura(
                        resultado.getInt("id_fatura"),
                        pacienteEncontrado,
                        resultado.getBigDecimal("valor_fatura"),
                        resultado.getDate("data_emissao").toLocalDate(),
                        resultado.getDate("data_vencimento").toLocalDate(),
                        resultado.getString("forma_pagamento"),
                        StatusFatura.valueOf(resultado.getString("status_fatura"))
                    );
                }
            }
            return null;
        }

        /**
         * Salva os impostos calculados na tabela nota_fiscal.
         */
        private static void gravarNotaFiscalNoBanco(Connection conexao, NotaFiscal nota) throws SQLException {
            
            String sqlInsert = "INSERT INTO sistema_hospitalar.nota_fiscal (id_fatura, forma_pagamento, valor_total, valor_iss, valor_pis, valor_cofins, valor_irpj, valor_csll) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            
            try (PreparedStatement declaracaoSQL = conexao.prepareStatement(sqlInsert)) {
                
                declaracaoSQL.setInt(1, nota.getFatura().getId());
                declaracaoSQL.setBigDecimal(2, nota.getIss());
                declaracaoSQL.setBigDecimal(3, nota.getFatura().getValor_fatura());
                declaracaoSQL.setBigDecimal(4, nota.getIss());
                declaracaoSQL.setBigDecimal(5, nota.getPis());
                declaracaoSQL.setBigDecimal(6, nota.getCofins());
                declaracaoSQL.setBigDecimal(7, nota.getIrpj());
                declaracaoSQL.setBigDecimal(8, nota.getCsll());

                declaracaoSQL.executeUpdate();
                System.out.println(">> Sucesso: Os dados da Nota Fiscal foram gravados na tabela 'nota_fiscal'.");
            }
        }

        /**
         * Busca e exibe uma nota fiscal ja existente no historico do banco.
         */
        private static void buscarNotaFiscalNoBanco(Connection conexao, int idNotaParaBusca) throws SQLException {
            
            String sqlBuscaNota = "SELECT * FROM nota_fiscal WHERE id = ?";
            
            try (PreparedStatement declaracaoSQL = conexao.prepareStatement(sqlBuscaNota)) {
                
                declaracaoSQL.setInt(1, idNotaParaBusca);
                ResultSet resultado = declaracaoSQL.executeQuery();

                if (resultado.next()) {
                    System.out.println("\n=========================================================================");
                    System.out.println("                DADOS DA NOTA FISCAL CADASTRADA                          ");
                    System.out.println("=========================================================================");
                    System.out.println("ID da Nota: " + resultado.getInt("id"));
                    System.out.println("ID Fatura : " + resultado.getInt("fatura_id"));
                    System.out.println("ISS (3%)  : R$ " + resultado.getBigDecimal("iss"));
                    System.out.println("PIS (0.65%): R$ " + resultado.getBigDecimal("pis"));
                    System.out.println("COFINS (3%): R$ " + resultado.getBigDecimal("cofins"));
                    System.out.println("IRPJ (1.2%): R$ " + resultado.getBigDecimal("irpj"));
                    System.out.println("CSLL (1.08%): R$ " + resultado.getBigDecimal("csll"));
                    System.out.println("=========================================================================");
                    
                } else {
                    System.out.println("\n[AVISO] Nenhuma Nota Fiscal com o ID" + idNotaParaBusca +" foi gerada anteriormente. " + sqlBuscaNota);
                }
            }
        }   
}