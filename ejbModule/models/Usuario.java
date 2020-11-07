package models;

import java.io.Serializable;
import javax.persistence.*;


@Entity
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 50)
	private String nombre;
	
	@Column(length = 50)
	private String apellido;
	
	@Column(length = 50, unique = true)
	private String usuario;
	
	@Column(length = 50)
	private String contrasenia;
	
	@ManyToOne(optional = false)//, cascade=CascadeType.ALL)
	private Rol rol;
	
	public Usuario() {
		
	}
	
	public Usuario(Long id, String nombre, String apellido, String usuario, String contrasenia, Rol rol) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.rol = rol;
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}

}
