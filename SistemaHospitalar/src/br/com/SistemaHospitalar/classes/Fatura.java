package br.com.SistemaHospitalar.classes;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.SistemaHospitalar.enums.StatusFatura;

public class Fatura {
	
	private Integer id;
	private Paciente paciente;
	private BigDecimal valor_fatura;
	private LocalDate data_emissao;
	private LocalDate data_vencimento;
	private String forma_pagamento;
	private StatusFatura statusFatura;
	
	public Fatura(Integer id, Paciente paciente, BigDecimal valor_fatura, LocalDate data_emissao,
			LocalDate data_vencimento, String forma_pagamento, StatusFatura statusFatura) {
		super();
		this.id = id;
		this.paciente = paciente;
		this.valor_fatura = valor_fatura;
		this.data_emissao = data_emissao;
		this.data_vencimento = data_vencimento;
		this.forma_pagamento = forma_pagamento;
		this.statusFatura = statusFatura;
	}

    @Override
    public String toString() {
        return "Nº " + this.id + " | Status: " + this.statusFatura + "\n" +
               "Paciente       : " + this.paciente + "\n" +
               "Data de Emissão: " + this.data_emissao + " | Vencimento: " + this.data_vencimento + "\n" +
               "Valor da Fatura: R$ " + this.valor_fatura + "\n" +
               "Forma de Pagt. : " + this.forma_pagamento;
    }

	public Integer getId() {
		return id;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public BigDecimal getValor_fatura() {
		return valor_fatura;
	}

	public LocalDate getData_emissao() {
		return data_emissao;
	}

	public LocalDate getData_vencimento() {
		return data_vencimento;
	}

	public String getForma_pagamento() {
		return forma_pagamento;
	}

	public StatusFatura getStatusFatura() {
		return statusFatura;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public void setValor_fatura(BigDecimal valor_fatura) {
		this.valor_fatura = valor_fatura;
	}

	public void setData_emissao(LocalDate data_emissao) {
		this.data_emissao = data_emissao;
	}

	public void setData_vencimento(LocalDate data_vencimento) {
		this.data_vencimento = data_vencimento;
	}

	public void setForma_pagamento(String forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}

	public void setStatusFatura(StatusFatura statusFatura) {
		this.statusFatura = statusFatura;
	}
}