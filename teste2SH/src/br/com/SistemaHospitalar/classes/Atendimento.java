package br.com.SistemaHospitalar.classes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.SistemaHospitalar.enums.StatusAtendimento;
import br.com.SistemaHospitalar.enums.TipoAtendimento;

public class Atendimento {
	
	private Integer id;
	private Paciente paciente;
	private Medico medico;
	private LocalDateTime data_hora;
	private TipoAtendimento tipoAtendimento;
	private StatusAtendimento statusAtendimento;
	private String observacoes_clinicas;
	private BigDecimal valor_atendimento;
	private BigDecimal valor_internacao;
	
	public Atendimento(Integer id, Paciente paciente, Medico medico, LocalDateTime data_hora,
			TipoAtendimento tipoAtendimento, StatusAtendimento statusAtendimento, String observacoes_clinicas,
			BigDecimal valor_atendimento, BigDecimal valor_internacao) {
		super();
		this.id = id;
		this.paciente = paciente;
		this.medico = medico;
		this.data_hora = data_hora;
		this.tipoAtendimento = tipoAtendimento;
		this.statusAtendimento = statusAtendimento;
		this.observacoes_clinicas = observacoes_clinicas;
		this.valor_atendimento = valor_atendimento;
		this.valor_internacao = valor_internacao;
	}

	public Integer getId() {
		return id;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public LocalDateTime getData_hora() {
		return data_hora;
	}

	public TipoAtendimento getTipoAtendimento() {
		return tipoAtendimento;
	}

	public StatusAtendimento getStatusAtendimento() {
		return statusAtendimento;
	}

	public String getObservacoes_clinicas() {
		return observacoes_clinicas;
	}

	public BigDecimal getValor_atendimento() {
		return valor_atendimento;
	}

	public BigDecimal getValor_internacao() {
		return valor_internacao;
	}

	@Override
	public String toString() {
		return "Atendimento [id=" + id + ", paciente=" + paciente + ", medico=" + medico + ", data_hora=" + data_hora
				+ ", tipoAtendimento=" + tipoAtendimento + ", statusAtendimento=" + statusAtendimento
				+ ", observacoes_clinicas=" + observacoes_clinicas + ", valor_atendimento=" + valor_atendimento
				+ ", valor_internacao=" + valor_internacao + "]";
	}
	
	
	
	
}
