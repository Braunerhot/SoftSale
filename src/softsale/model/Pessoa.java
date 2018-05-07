package softsale.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Pessoa extends GenericEntity{
	@Id @GeneratedValue
	private Long id;
	@Column
	private String nome;
	@Column
	private int idade;
	@Column
	private String telefone;
	@Column
	private String email;
	
	public Pessoa() {
		super();
	}
	public Pessoa(Long id, String nome, int idade, String telefone, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.telefone = telefone;
		this.email = email;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
}
