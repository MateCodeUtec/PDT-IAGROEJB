package models;

import java.io.Serializable;
import javax.persistence.*;
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
	
	@ManyToOne(optional = true)
	private Departamento departamento;
	
	@ManyToOne(optional = true)
	private Estacion estacion;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Metodo> metodos;
	
	@ManyToOne(optional = true)
	private Region region;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Equipamiento> equipamientos;
	
	@Column(length = 100)
	private String titulo;
	
	@Column(length = 250)
	private String descripcion;
	
	@Enumerated(value = EnumType.STRING)
	private Visibilidad visibilidad;
	
	@OneToMany(cascade = CascadeType.ALL)
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
	
	

	public Formulario(Usuario usuario, Departamento departamento, Estacion estacion, List<Metodo> metodos, Region region,
			List<Equipamiento> equipamientos, String titulo, String descripcion, Visibilidad visibilidad,
			List<Parametro> parametros) {
		super();
		this.usuario = usuario;
		this.departamento = departamento;
		this.estacion = estacion;
		this.metodos = metodos;
		this.region = region;
		this.equipamientos = equipamientos;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.visibilidad = visibilidad;
		this.parametros = parametros;
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

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Estacion getEstacion() {
		return estacion;
	}

	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
	
	public List<Metodo> getMetodos() {
		return metodos;
	}

	public void setMetodos(List<Metodo> metodos) {
		this.metodos = metodos;
	}

	public List<Equipamiento> getEquipamientos() {
		return equipamientos;
	}

	public void setEquipamientos(List<Equipamiento> equipamientos) {
		this.equipamientos = equipamientos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departamento == null) ? 0 : departamento.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((equipamientos == null) ? 0 : equipamientos.hashCode());
		result = prime * result + ((estacion == null) ? 0 : estacion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((metodos == null) ? 0 : metodos.hashCode());
		result = prime * result + ((parametros == null) ? 0 : parametros.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
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
		if (departamento == null) {
			if (other.departamento != null)
				return false;
		} else if (!departamento.equals(other.departamento))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (equipamientos == null) {
			if (other.equipamientos != null)
				return false;
		} else if (!equipamientos.equals(other.equipamientos))
			return false;
		if (estacion == null) {
			if (other.estacion != null)
				return false;
		} else if (!estacion.equals(other.estacion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (metodos == null) {
			if (other.metodos != null)
				return false;
		} else if (!metodos.equals(other.metodos))
			return false;
		if (parametros == null) {
			if (other.parametros != null)
				return false;
		} else if (!parametros.equals(other.parametros))
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
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

	@Override
	public String toString() {
		return titulo;
	}

		
	
	
}
