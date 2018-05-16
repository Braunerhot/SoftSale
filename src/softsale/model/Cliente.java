package softsale.model;

import javax.persistence.Entity;

@Entity
public class Cliente extends Pessoa {

	public Cliente() {
		super();
	}

	public Cliente(Long id, String nome, String cpf, String telefone, String email, Endereco endereco) {
		super(id, nome, cpf, telefone, email, endereco);
	}

}
