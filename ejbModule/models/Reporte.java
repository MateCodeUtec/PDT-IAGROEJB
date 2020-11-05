package models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Reporte implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Es para generar un ID autogenerado
	private Long id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Usuario usuario;
	
	@Column(length = 45)
	private String nombre;
	
	@Column(length = 500)
	private String descripcion;
	
	@OneToMany 
	private List<Multimedia> multimedias;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Multimedia> getMultimedias() {
		return multimedias;
	}

	public void setMultimedias(List<Multimedia> multimedias) {
		this.multimedias = multimedias;
	}
	
	
}
