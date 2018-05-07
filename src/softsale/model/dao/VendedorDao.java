package softsale.model.dao;

import javax.persistence.EntityManager;

import softsale.model.Vendedor;

public class VendedorDao extends GenericDao<Vendedor>{
	public VendedorDao(EntityManager entityManager) {
		super(entityManager);
	}
}
