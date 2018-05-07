package softsale.model.dao;

import javax.persistence.EntityManager;

import softsale.model.Produto;

public class ProdutoDao extends GenericDao<Produto>{
	public ProdutoDao(EntityManager entityManager) {
		super(entityManager);
	}
}
