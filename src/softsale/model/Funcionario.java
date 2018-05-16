package softsale.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Funcionario extends Pessoa {	
	@Column
	private String senha;
	public Funcionario() {
		super();
	}

	public Funcionario(Long id, String nome, String cpf, String senha, String telefone, String email, Endereco endereco) {
		super(id, nome, cpf, telefone, email, endereco);
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}