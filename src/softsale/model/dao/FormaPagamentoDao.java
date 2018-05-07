package softsale.model.dao;

import javax.persistence.EntityManager;

import softsale.model.FormaPagamento;

public class FormaPagamentoDao extends GenericDao<FormaPagamento>{
	public FormaPagamentoDao(EntityManager entityManager) {
		super(entityManager);
	}
}
