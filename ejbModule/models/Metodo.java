package models;


import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Metodo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Es para generar un ID autogenerado
	private long id;
	
	@Column(length = 55)
	private String nombre;
	
	@OneToMany
	private List<Formulario> formularios;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
