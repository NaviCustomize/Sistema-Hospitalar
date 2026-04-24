package br.com.SistemaHospitalar.classes;

import br.com.SistemaHospitalar.enums.TipoAla;
import br.com.SistemaHospitalar.enums.TipoLaboratorio;

public class Laboratorio {
	
	private Long id;
	private Exame exame;
	private String nome_laboratorio;
	private TipoLaboratorio tipoLaboratorio;
	
	public Laboratorio(Long id, Exame exame, String nome_laboratorio, TipoLaboratorio tipoLaboratorio) {
		super();
		this.id = id;
		this.exame = exame;
		this.nome_laboratorio = nome_laboratorio;
		this.tipoLaboratorio = tipoLaboratorio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public String getNome_laboratorio() {
		return nome_laboratorio;
	}

	public void setNome_laboratorio(String nome_laboratorio) {
		this.nome_laboratorio = nome_laboratorio;
	}

	public TipoLaboratorio getTipoLaboratorio() {
		return tipoLaboratorio;
	}

	public void setTipoLaboratorio(TipoLaboratorio tipoLaboratorio) {
		this.tipoLaboratorio = tipoLaboratorio;
	}

	@Override
	public String toString() {
		return "Laboratorio [id=" + id + ", exame=" + exame + ", nome_laboratorio=" + nome_laboratorio
				+ ", tipoLaboratorio=" + tipoLaboratorio + "]";
	}
	
	
	
}
