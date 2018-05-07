package softsale.model.service;

import java.util.ArrayList;
import java.util.List;

import softsale.model.PessoaFisica;
import softsale.model.dao.PessoaFisicaDao;

public class PessoaFisicaService extends GenericService{	
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

			if(pessoaFisica.getId() > 0l) {
				pessoaFisicaDao.update(pessoaFisica);
			} else {
				pessoaFisicaDao.save(pessoaFisica);				
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