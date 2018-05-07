package softsale.model.service;

import java.util.ArrayList;
import java.util.List;

import softsale.model.Produto;
import softsale.model.dao.ProdutoDao;

public class ProdutoService extends GenericService{	
	public List<Produto> getAll(){
		ProdutoDao ProdutoDao = new ProdutoDao(entityManager);
		List<Produto> ProdutoList = new ArrayList<>();
		
		try {
			entityManager.getTransaction().begin();
			ProdutoList = ProdutoDao.findAll();
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
		return ProdutoList;
	}
	
	public void saveUpdate(Produto Produto) {
		ProdutoDao ProdutoDao = new ProdutoDao(entityManager);
				
		try {
			entityManager.getTransaction().begin();

			if(Produto.getId() > 0l) {
				ProdutoDao.update(Produto);
			} else {
				ProdutoDao.save(Produto);				
			}
			
			entityManager.getTransaction().commit();
		}catch (Exception e) {
		
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
	}
	
	public void remove(Produto Produto) {
		ProdutoDao ProdutoDao = new ProdutoDao(entityManager);
		try {
			entityManager.getTransaction().begin();
			ProdutoDao.remove(Produto);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
	}
}