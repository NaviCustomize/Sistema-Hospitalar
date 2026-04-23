package br.com.SistemaHospitalar.classes;

import java.math.BigDecimal;

public class Medicamento {
	
	private Integer id;
	private String nome_medicamento;
	private BigDecimal dosagem;
	private Integer quantidade;
	
	public Medicamento(Integer id, String nome_medicamento, BigDecimal dosagem, Integer quantidade) {
		super();
		this.id = id;
		this.nome_medicamento = nome_medicamento;
		this.dosagem = dosagem;
		this.quantidade = quantidade;
	}

	public Integer getId() {
		return id;
	}

	public String getNome_medicamento() {
		return nome_medicamento;
	}

	public BigDecimal getDosagem() {
		return dosagem;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	@Override
	public String toString() {
		return "Medicamento [id=" + id + ", nome_medicamento=" + nome_medicamento + ", dosagem=" + dosagem
				+ ", quantidade=" + quantidade + "]";
	}
	
}
