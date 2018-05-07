package softsale.model.service;

import java.util.ArrayList;
import java.util.List;

import softsale.model.Produto;
import softsale.model.dao.ProdutoDao;

public class ProdutoService extends GenericService{	
	public List<Produto> getAll(){
		ProdutoDao produtoDao = new ProdutoDao(entityManager);
		List<Produto> produtoList = new ArrayList<>();
		
		try {
			entityManager.getTransaction().begin();
			produtoList = produtoDao.findAll();
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
		return produtoList;
	}
	
	public void saveUpdate(Produto produto) {
		ProdutoDao produtoDao = new ProdutoDao(entityManager);
				
		try {
			entityManager.getTransaction().begin();

			if(produto.getId() > 0l) {
				produtoDao.update(produto);
			} else {
				produtoDao.save(produto);				
			}
			
			entityManager.getTransaction().commit();
		}catch (Exception e) {
		
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
	}
	
	public void remove(Produto produto) {
		ProdutoDao produtoDao = new ProdutoDao(entityManager);
		try {
			entityManager.getTransaction().begin();
			produtoDao.remove(produto);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
	}
}