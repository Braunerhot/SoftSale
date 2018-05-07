package softsale.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PessoaFisica extends Pessoa{
	@Column
	private String cpf;

	public PessoaFisica() {
		super();
	}

	public PessoaFisica(Long id, String nome, int idade, String telefone, String email, String cpf) {
		super(id, nome, idade, telefone, email);
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
