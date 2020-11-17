package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

import enums.Visibilidad;

/**
 * Entity implementation class for Entity: Formulario
 *
 */
@Entity
public class Formulario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;
	
	@ManyToOne(optional = false)
	private Usuario usuario;
	
	@Column(length = 100)
	private String titulo;
	
	@Column(length = 250)
	private String descripcion;
	
	@Enumerated(value = EnumType.STRING)
	private Visibilidad visibilidad;
	
	@OneToMany//(cascade = CascadeType.ALL)
	private List<Parametro> parametros;

	
	public Formulario() {
	}

	public Formulario(Usuario usuario, String titulo, String descripcion, Visibilidad visibilidad,
			List<Parametro> parametros) {
		super();
		this.usuario = usuario;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.visibilidad = visibilidad;
		this.parametros = parametros;
	}


	public Formulario(Usuario usuario, String titulo, String descripcion, Visibilidad visibilidad) {
		super();
		this.usuario = usuario;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.visibilidad = visibilidad;
	}

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

	public Visibilidad getVisibilidad() {
		return visibilidad;
	}

	public void setVisibilidad(Visibilidad visibilidad) {
		this.visibilidad = visibilidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public List<Parametro> getParametros() {
		return parametros;
	}

	public void setParametros(List<Parametro> parametros) {
		this.parametros = parametros;
	}
	
	public void addParametro (Parametro parametro) {
		parametros.add(parametro);
	}
	
	

	@Override
	public String toString() {
		return "Formulario [id=" + id + ", usuario=" + usuario + ", titulo=" + titulo + ", descripcion=" + descripcion
				+ ", visibilidad=" + visibilidad + ", parametros=" + parametros + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + ((visibilidad == null) ? 0 : visibilidad.hashCode());
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
		Formulario other = (Formulario) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (visibilidad != other.visibilidad)
			return false;
		return true;
	}
	
	
	
}
