package models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

public class Parametro implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Es para generar un ID autogenerado
	private Long id;
	
	private boolean obligatorio;
	
	@Enumerated(value = EnumType.STRING)
	private TipoParametro tipo;
	
	@OneToMany
	private List<Formulario> formularios;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isObligatorio() {
		return obligatorio;
	}

	public void setObligatorio(boolean obligatorio) {
		this.obligatorio = obligatorio;
	}

	public TipoParametro getTipo() {
		return tipo;
	}

	public void setTipo(TipoParametro tipo) {
		this.tipo = tipo;
	}

	public List<Formulario> getFormularios() {
		return formularios;
	}

	public void setFormularios(List<Formulario> formularios) {
		this.formularios = formularios;
	}
	 
	public void addFormulario(Formulario formulario) {
		formularios.add(formulario);
	}
	
	
}
