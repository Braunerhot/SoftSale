package softsale.model.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import softsale.model.Cliente;
import softsale.model.dao.ClienteDao;

public class ClienteService extends GenericService{
	public Cliente getById(Long id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		ClienteDao clienteDao = new ClienteDao(entityManager);
			
		Cliente cliente = null;
		
		try {
			cliente = clienteDao.getById(id);
		} finally {
			entityManager.close();
		}
		
		return cliente;
	}
	
	public List<Cliente> getAll() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		ClienteDao clienteDao = new ClienteDao(entityManager);
				
		try {
			return clienteDao.getAll();
		} catch (Exception e) {
			return new ArrayList<Cliente>();
		} finally {
			entityManager.close();
		}
	}
	
	public void saveUpdate(Cliente cliente) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		ClienteDao clienteDao = new ClienteDao(entityManager);
				
		try {
			entityManager.getTransaction().begin();

			if(cliente.getId() == null) {
				clienteDao.save(cliente);				
			} else {
				clienteDao.update(cliente);
			}
			
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		} finally {
			entityManager.close();
		}
	}
	
	public void remove(Long id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		ClienteDao clienteDao = new ClienteDao(entityManager);
		
		Cliente cliente = clienteDao.getById(id);
		
		try {
			entityManager.getTransaction().begin();
			clienteDao.remove(cliente);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		} finally {
			entityManager.close();
		}
	}
}
