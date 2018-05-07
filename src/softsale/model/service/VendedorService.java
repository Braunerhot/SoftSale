package softsale.model.service;

import java.util.ArrayList;
import java.util.List;

import softsale.model.Vendedor;
import softsale.model.dao.VendedorDao;

public class VendedorService extends GenericService{	
	public List<Vendedor> getAll(){
		VendedorDao VendedorDao = new VendedorDao(entityManager);
		List<Vendedor> VendedorList = new ArrayList<>();
		
		try {
			entityManager.getTransaction().begin();
			VendedorList = VendedorDao.findAll();
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
		return VendedorList;
	}
	
	public void saveUpdate(Vendedor Vendedor) {
		VendedorDao VendedorDao = new VendedorDao(entityManager);
				
		try {
			entityManager.getTransaction().begin();

			if(Vendedor.getId() > 0l) {
				VendedorDao.update(Vendedor);
			} else {
				VendedorDao.save(Vendedor);				
			}
			
			entityManager.getTransaction().commit();
		}catch (Exception e) {
		
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
	}
	
	public void remove(Vendedor Vendedor) {
		VendedorDao VendedorDao = new VendedorDao(entityManager);
		try {
			entityManager.getTransaction().begin();
			VendedorDao.remove(Vendedor);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
	}
}