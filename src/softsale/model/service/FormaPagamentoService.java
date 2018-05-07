package softsale.model.service;

import java.util.ArrayList;
import java.util.List;

import softsale.model.FormaPagamento;
import softsale.model.dao.FormaPagamentoDao;

public class FormaPagamentoService extends GenericService{	
	public List<FormaPagamento> getAll(){
		FormaPagamentoDao formaPagamentoDao = new FormaPagamentoDao(entityManager);
		List<FormaPagamento> formaPagamentoList = new ArrayList<>();
		
		try {
			entityManager.getTransaction().begin();
			formaPagamentoList = formaPagamentoDao.findAll();
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
		return formaPagamentoList;
	}
	
	public void saveUpdate(FormaPagamento formaPagamento) {
		FormaPagamentoDao formaPagamentoDao = new FormaPagamentoDao(entityManager);
				
		try {
			entityManager.getTransaction().begin();

			if(formaPagamento.getId() > 0l) {
				formaPagamentoDao.update(formaPagamento);
			} else {
				formaPagamentoDao.save(formaPagamento);				
			}
			
			entityManager.getTransaction().commit();
		}catch (Exception e) {
		
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
	}
	
	public void remove(FormaPagamento formaPagamento) {
		FormaPagamentoDao formaPagamentoDao = new FormaPagamentoDao(entityManager);
		try {
			entityManager.getTransaction().begin();
			formaPagamentoDao.remove(formaPagamento);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
	}
}