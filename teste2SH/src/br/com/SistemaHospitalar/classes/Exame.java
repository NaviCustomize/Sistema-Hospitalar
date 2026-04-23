package br.com.SistemaHospitalar.classes;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.SistemaHospitalar.enums.Resultado;
import br.com.SistemaHospitalar.enums.TipoExame;

public class Exame {
	
	private Integer id;
	private Medico medico;
	private Atendimento atendimento;
	private LocalDate data_solicitacao;
	private TipoExame tipoExame;
	private BigDecimal valorExame;
	private Resultado resultado;
	private LocalDate data_resultado;
	private String descricao;
	
	public Exame(Integer id, Medico medico, Atendimento atendimento, LocalDate data_solicitacao, TipoExame tipoExame,
			BigDecimal valorExame, Resultado resultado, LocalDate data_resultado, String descricao) {
		super();
		this.id = id;
		this.medico = medico;
		this.atendimento = atendimento;
		this.data_solicitacao = data_solicitacao;
		this.tipoExame = tipoExame;
		this.valorExame = valorExame;
		this.resultado = resultado;
		this.data_resultado = data_resultado;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public Medico getMedico() {
		return medico;
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public LocalDate getData_solicitacao() {
		return data_solicitacao;
	}

	public TipoExame getTipoExame() {
		return tipoExame;
	}

	public BigDecimal getValorExame() {
		return valorExame;
	}

	public Resultado getResultado() {
		return resultado;
	}

	public LocalDate getData_resultado() {
		return data_resultado;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return "Exame [id=" + id + ", medico=" + medico + ", atendimento=" + atendimento + ", data_solicitacao="
				+ data_solicitacao + ", tipoExame=" + tipoExame + ", valorExame=" + valorExame + ", resultado="
				+ resultado + ", data_resultado=" + data_resultado + ", descricao=" + descricao + "]";
	}
	
}
