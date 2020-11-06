package models;

import javax.persistence.*;

import enums.TipoDato;

@Entity
public class TipoParametro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 50)
	private String nombre;
	
	@Enumerated(value = EnumType.STRING)
	private TipoDato tipo;
	
	@Override
	public String toString() {
		return nombre;
	}
	
}	
