package softsale.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FormaPagamento extends GenericEntity{
	@Id @GeneratedValue
	private Long id;
	@Column
	private String titulo;
	
	public FormaPagamento() {
		super();
	}
	public FormaPagamento(Long id, String titulo) {
		super();
		this.id = id;
		this.titulo = titulo;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
