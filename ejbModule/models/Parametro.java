package models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Parametro implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Es para generar un ID autogenerado
	private Long id;
	
	private boolean obligatorio;
	
	@OneToOne
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((formularios == null) ? 0 : formularios.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (obligatorio ? 1231 : 1237);
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parametro other = (Parametro) obj;
		if (formularios == null) {
			if (other.formularios != null)
				return false;
		} else if (!formularios.equals(other.formularios))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (obligatorio != other.obligatorio)
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
	
}
