package softsale.model.dao;

import javax.persistence.EntityManager;

import softsale.model.Item;

public class ItemDao extends GenericDao<Item>{
	public ItemDao(EntityManager entityManager) {
		super(entityManager);
	}
}
