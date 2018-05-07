package softsale.model.service;

import java.util.ArrayList;
import java.util.List;

import softsale.model.Item;
import softsale.model.dao.ItemDao;

public class ItemService extends GenericService{	
	public List<Item> getAll(){
		ItemDao itemDao = new ItemDao(entityManager);
		List<Item> itemList = new ArrayList<>();
		
		try {
			entityManager.getTransaction().begin();
			itemList = itemDao.findAll();
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
		return itemList;
	}
	
	public void saveUpdate(Item item) {
		ItemDao itemDao = new ItemDao(entityManager);
				
		try {
			entityManager.getTransaction().begin();

			if(item.getId() > 0l) {
				itemDao.update(item);
			} else {
				itemDao.save(item);				
			}
			
			entityManager.getTransaction().commit();
		}catch (Exception e) {
		
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
	}
	
	public void remove(Item item) {
		ItemDao itemDao = new ItemDao(entityManager);
		try {
			entityManager.getTransaction().begin();
			itemDao.remove(item);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
	}
}