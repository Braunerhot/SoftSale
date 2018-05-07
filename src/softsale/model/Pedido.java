package softsale.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Pedido {
	@Id @GeneratedValue
	private Long id;
	@OneToOne
	private Pessoa cliente;
	@OneToOne
	private Vendedor vendedor;
	@Column
	private Date date;
	@OneToMany
	private List<Item> itens;
	@OneToOne
	private FormaPagamento formaPagamento;
	
	public Pedido() {
		super();
	}
	public Pedido(Long id, Pessoa cliente, Vendedor vendedor, Date date, List<Item> itens,
			FormaPagamento formaPagamento) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.date = date;
		this.itens = itens;
		this.formaPagamento = formaPagamento;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Pessoa getCliente() {
		return cliente;
	}
	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
}
