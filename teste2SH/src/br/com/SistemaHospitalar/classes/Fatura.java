package br.com.SistemaHospitalar.classes;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.SistemaHospitalar.enums.StatusFatura;

public class Fatura {
	
	private Long id;
	private Integer idPaciente;
	private BigDecimal valorFatura;
	private LocalDate dataEmissao;
	private LocalDate dataVencimento;
	private String formaPagamento;
	private StatusFatura statusFatura;
	
	public Fatura(Long id, Integer idPaciente, BigDecimal valorFatura, LocalDate dataEmissao,
			LocalDate dataVencimento, String formaPagamento, StatusFatura statusFatura) {
		super();
		this.id = id;
		this.idPaciente = idPaciente;
		this.valorFatura = valorFatura;
		this.dataEmissao = dataEmissao;
		this.dataVencimento = dataVencimento;
		this.formaPagamento = formaPagamento;
		this.statusFatura = statusFatura;
	}

    @Override
    public String toString() {
        return "Nº " + this.id + " | Status: " + this.statusFatura + "\n" +
               "Paciente ID     : " + this.idPaciente + "\n" +
               "Data de Emissão: " + this.dataEmissao + " | Vencimento: " + this.dataVencimento + "\n" +
               "Valor da Fatura: R$ " + this.valorFatura + "\n" +
               "Forma de Pagt. : " + this.formaPagamento;
    }

	public Long getId() {
		return id;
	}

	public Integer getPaciente() {
		return idPaciente;
	}

	public BigDecimal getValor_fatura() {
		return valorFatura;
	}

	public LocalDate getData_emissao() {
		return dataEmissao;
	}

	public LocalDate getData_vencimento() {
		return dataVencimento;
	}

	public String getForma_pagamento() {
		return formaPagamento;
	}

	public StatusFatura getStatusFatura() {
		return statusFatura;
	}

}