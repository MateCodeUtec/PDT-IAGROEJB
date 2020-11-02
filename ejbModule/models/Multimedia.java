package models;

import javax.persistence.*;

import enums.TipoMultimedia;

@Entity
public class Multimedia {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Es para generar un ID autogenerado
	private Long id;
	
	@Column(length = 150)
	private String url;
	
	@Enumerated
	private TipoMultimedia tipo;
	
	@ManyToOne
	private Reporte reporte;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public TipoMultimedia getTipo() {
		return tipo;
	}

	public void setTipo(TipoMultimedia tipo) {
		this.tipo = tipo;
	}

	public Reporte getReporte() {
		return reporte;
	}

	public void setReporte(Reporte reporte) {
		this.reporte = reporte;
	}
	
	
}
