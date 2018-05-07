package softsale.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Vendedor extends PessoaFisica{
	@Column
	private Double comissao;
	@Column
	private Double desconto;
}
