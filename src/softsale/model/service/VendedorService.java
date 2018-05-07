package softsale.model.service;

import java.util.ArrayList;
import java.util.List;

import softsale.model.Vendedor;
import softsale.model.dao.VendedorDao;

public class VendedorService extends GenericService{	
	public List<Vendedor> getAll(){
		VendedorDao vendedorDao = new VendedorDao(entityManager);
		List<Vendedor> vendedorList = new ArrayList<>();
		
		try {
			entityManager.getTransaction().begin();
			vendedorList = vendedorDao.findAll();
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
		return vendedorList;
	}
	
	public void saveUpdate(Vendedor vendedor) {
		VendedorDao vendedorDao = new VendedorDao(entityManager);
				
		try {
			entityManager.getTransaction().begin();

			if(vendedor.getId() > 0l) {
				vendedorDao.update(vendedor);
			} else {
				vendedorDao.save(vendedor);				
			}
			
			entityManager.getTransaction().commit();
		}catch (Exception e) {
		
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
	}
	
	public void remove(Vendedor vendedor) {
		VendedorDao vendedorDao = new VendedorDao(entityManager);
		try {
			entityManager.getTransaction().begin();
			vendedorDao.remove(vendedor);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
	}
}