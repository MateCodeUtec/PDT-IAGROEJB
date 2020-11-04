package models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Funcionalidad
 *
 */
@Entity
public class Funcionalidad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Es para generar un ID autogenerado
	private long id;

	@Column(length = 50)
	private String nombre;

	public Funcionalidad() {

	}

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

}
