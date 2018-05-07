package softsale.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Item extends GenericEntity{
	@Id @GeneratedValue
	private Long id;
	@Column
	private int quantidade;
	@OneToOne
	private Produto produto;                                                                                  
	@Column
	private Double valor;
	
	public Item() {
		super();
	}
	public Item(Long id, int quantidade, Produto produto, Double valor) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.produto = produto;
		this.valor = valor;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
}
