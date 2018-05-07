package softsale.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PessoaFisica extends Pessoa{
	@Column
	private String cpf;
}
