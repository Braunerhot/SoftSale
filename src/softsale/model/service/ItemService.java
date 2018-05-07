package softsale.model.service;

import java.util.ArrayList;
import java.util.List;

import softsale.model.Item;
import softsale.model.dao.ItemDao;

public class ItemService extends GenericService{	
	public List<Item> getAll(){
		ItemDao ItemDao = new ItemDao(entityManager);
		List<Item> ItemList = new ArrayList<>();
		
		try {
			entityManager.getTransaction().begin();
			ItemList = ItemDao.findAll();
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
		return ItemList;
	}
	
	public void saveUpdate(Item Item) {
		ItemDao ItemDao = new ItemDao(entityManager);
				
		try {
			entityManager.getTransaction().begin();

			if(Item.getId() > 0l) {
				ItemDao.update(Item);
			} else {
				ItemDao.save(Item);				
			}
			
			entityManager.getTransaction().commit();
		}catch (Exception e) {
		
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
	}
	
	public void remove(Item Item) {
		ItemDao ItemDao = new ItemDao(entityManager);
		try {
			entityManager.getTransaction().begin();
			ItemDao.remove(Item);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
	}
}