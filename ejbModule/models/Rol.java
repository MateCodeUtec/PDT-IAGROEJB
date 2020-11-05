package models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
public class Rol implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 45)
	private String nombre;
	
	@OneToMany
	private List<Usuario> usuarios;
	
	public Rol() {
		
	}
	
	public Rol(String nombre) {
		this.nombre = nombre;
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

	
}
