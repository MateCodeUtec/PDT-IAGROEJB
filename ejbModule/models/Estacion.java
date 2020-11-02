package models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Estacion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 50)
	private String nombre;
	
	@OneToMany
	private List<Formulario> formularios;

	public Estacion() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
