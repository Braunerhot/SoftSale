package softsale.model.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import softsale.model.Funcionario;
import softsale.model.dao.FuncionarioDao;

public class FuncionarioService extends GenericService{
	public Funcionario getById(Long id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		FuncionarioDao funcionarioDao = new FuncionarioDao(entityManager);
			
		Funcionario cliente = null;
		
		try {
			cliente = funcionarioDao.getById(id);
		} finally {
			entityManager.close();
		}
		
		return cliente;
	}
	
	public List<Funcionario> getAll() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		FuncionarioDao funcionarioDao = new FuncionarioDao(entityManager);
				
		try {
			return funcionarioDao.getAll();
		} catch (Exception e) {
			return new ArrayList<Funcionario>();
		} finally {
			entityManager.close();
		}
	}
	
	public void saveUpdate(Funcionario cliente) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		FuncionarioDao funcionarioDao = new FuncionarioDao(entityManager);
				
		try {
			entityManager.getTransaction().begin();

			if(cliente.getId() == null) {
				funcionarioDao.save(cliente);				
			} else {
				funcionarioDao.update(cliente);
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
		FuncionarioDao funcionarioDao = new FuncionarioDao(entityManager);
		
		Funcionario cliente = funcionarioDao.getById(id);
		
		try {
			entityManager.getTransaction().begin();
			funcionarioDao.remove(cliente);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		} finally {
			entityManager.close();
		}
	}
}
