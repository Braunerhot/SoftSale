package softsale.model.dao;

import javax.persistence.EntityManager;

import softsale.model.Pedido;

public class PedidoDao extends GenericDao<Pedido>{
	public PedidoDao(EntityManager entityManager) {
		super(entityManager);
	}
}
