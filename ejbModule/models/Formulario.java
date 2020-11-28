package models;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	
	@OneToMany(cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
	private Set<Parametro> parametros  = new HashSet<Parametro>();
	
	@Column(length = 1)
	private String usaEquip = "N";
	
	@Column(length = 1)
	private String usaMetodo = "N";
	
	@Column(length = 1)
	private String usaRegion = "N";
	
	@Column(length = 1)
	private String usaDepto = "N";
	
	@Column(length = 1)
	private String usaLocalidad = "N";
	
	@Column(length = 1)
	private String usaFecha = "N";
	
	@Column(length = 1)
	private String usaEstacion = "N";
	
	@Column(length = 1)
	private String activoSN = "S";
	
	
	public Formulario() {
	}

	public Formulario(Usuario usuario, String titulo, String descripcion, Visibilidad visibilidad,
			Set<Parametro> parametros) {
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
	
	public Set<Parametro> getParametros() {
		return parametros;
	}

	public void setParametros(Set<Parametro> listaParametros) {
		this.parametros = listaParametros;
	}
	
	public void addParametro (Parametro parametro) {
		parametros.add(parametro);
	}

	public String getUsaEquip() {
		return usaEquip;
	}

	public void setUsaEquip(String usaEquip) {
		this.usaEquip = usaEquip;
	}

	public String getUsaMetodo() {
		return usaMetodo;
	}

	public void setUsaMetodo(String usaMetodo) {
		this.usaMetodo = usaMetodo;
	}

	public String getUsaRegion() {
		return usaRegion;
	}

	public void setUsaRegion(String usaRegion) {
		this.usaRegion = usaRegion;
	}

	public String getUsaDepto() {
		return usaDepto;
	}

	public void setUsaDepto(String usaDepto) {
		this.usaDepto = usaDepto;
	}

	public String getUsaLocalidad() {
		return usaLocalidad;
	}

	public void setUsaLocalidad(String usaLocalidad) {
		this.usaLocalidad = usaLocalidad;
	}

	public String getUsaFecha() {
		return usaFecha;
	}

	public void setUsaFecha(String usaFecha) {
		this.usaFecha = usaFecha;
	}

	public String getUsaEstacion() {
		return usaEstacion;
	}

	public void setUsaEstacion(String usaEstacion) {
		this.usaEstacion = usaEstacion;
	}
	

	public String getActivoSN() {
		return activoSN;
	}

	public void setActivoSN(String activoSN) {
		this.activoSN = activoSN;
	}

	@Override
	public String toString() {
		return titulo;
	}

}
