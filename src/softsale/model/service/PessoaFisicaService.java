package softsale.model.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;

import softsale.model.PessoaFisica;
import softsale.model.dao.PessoaFisicaDao;

public class PessoaFisicaService extends GenericService {
	
	List<PessoaFisicaListener> listeners = new ArrayList<>();
		
		public PessoaFisicaService() {
			super();
			addListener(new Email());
		}
	
		public void addListener(PessoaFisicaListener listener) {
			listeners.add(listener);
		}
		
		public void removeListener(PessoaFisicaListener listener) {
			listeners.remove(listener);
		}
	
		public void notificar(PessoaFisica pessoaFisica) {
			for (PessoaFisicaListener listener : listeners) {
				listener.pessoaCadastrada(pessoaFisica);
			}
		}	
	
	public List<PessoaFisica> getAll(){
		PessoaFisicaDao pessoaFisicaDao = new PessoaFisicaDao(entityManager);
		List<PessoaFisica> pessoaFisicaList = new ArrayList<>();
		
		try {
			entityManager.getTransaction().begin();
			pessoaFisicaList = pessoaFisicaDao.findAll();
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
		return pessoaFisicaList;
	}
	
	public void saveUpdate(PessoaFisica pessoaFisica) {
		PessoaFisicaDao pessoaFisicaDao = new PessoaFisicaDao(entityManager);
		
		try {
			entityManager.getTransaction().begin();

			if(pessoaFisica.getId() == null) {
				System.out.println("Save");
				pessoaFisicaDao.save(pessoaFisica);
				notificar(pessoaFisica);
			} else {
				System.out.println("update");
				pessoaFisicaDao.update(pessoaFisica);
			}
			
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
	}
	
	public void remove(PessoaFisica pessoaFisica) {
		PessoaFisicaDao pessoaFisicaDao = new PessoaFisicaDao(entityManager);
		try {
			entityManager.getTransaction().begin();
			pessoaFisicaDao.remove(pessoaFisica);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
	}
}