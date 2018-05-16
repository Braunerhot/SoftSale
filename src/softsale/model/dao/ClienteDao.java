package softsale.model.dao;

import javax.persistence.EntityManager;

import softsale.model.Cliente;

public class ClienteDao extends GenericDao<Cliente> {
	public ClienteDao(EntityManager entityManager) {
		super(entityManager);
	}
}
