package softsale.model.dao;

import javax.persistence.EntityManager;

import softsale.model.PessoaFisica;

public class PessoaFisicaDao extends GenericDao<PessoaFisica>{
	public PessoaFisicaDao(EntityManager entityManager) {
		super(entityManager);
	}
}
