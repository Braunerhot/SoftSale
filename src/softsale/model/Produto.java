package softsale.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produto{
	@Id @GeneratedValue
	private Long id;
	@Column
	private String descricao;
	@Column
	private int estoque;
	@Column
	private double valorCompra;
	@Column
	private double valorVenda;
	
	public Produto() {
		super();
	}
	public Produto(Long id, String descricao, int estoque, double valorCompra, double valorVenda) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.estoque = estoque;
		this.valorCompra = valorCompra;
		this.valorVenda = valorVenda;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	public double getValorCompra() {
		return valorCompra;
	}
	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}
	public double getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}
}
