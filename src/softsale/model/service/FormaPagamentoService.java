package softsale.model.service;

import java.util.ArrayList;
import java.util.List;

import softsale.model.FormaPagamento;
import softsale.model.dao.FormaPagamentoDao;

public class FormaPagamentoService extends GenericService{	
	public List<FormaPagamento> getAll(){
		FormaPagamentoDao FormaPagamentoDao = new FormaPagamentoDao(entityManager);
		List<FormaPagamento> FormaPagamentoList = new ArrayList<>();
		
		try {
			entityManager.getTransaction().begin();
			FormaPagamentoList = FormaPagamentoDao.findAll();
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
		return FormaPagamentoList;
	}
	
	public void saveUpdate(FormaPagamento FormaPagamento) {
		FormaPagamentoDao FormaPagamentoDao = new FormaPagamentoDao(entityManager);
				
		try {
			entityManager.getTransaction().begin();

			if(FormaPagamento.getId() > 0l) {
				FormaPagamentoDao.update(FormaPagamento);
			} else {
				FormaPagamentoDao.save(FormaPagamento);				
			}
			
			entityManager.getTransaction().commit();
		}catch (Exception e) {
		
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
	}
	
	public void remove(FormaPagamento FormaPagamento) {
		FormaPagamentoDao FormaPagamentoDao = new FormaPagamentoDao(entityManager);
		try {
			entityManager.getTransaction().begin();
			FormaPagamentoDao.remove(FormaPagamento);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
	}
}