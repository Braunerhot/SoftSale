package softsale.model.service;

import java.util.ArrayList;
import java.util.List;

import softsale.model.Pedido;
import softsale.model.dao.PedidoDao;

public class PedidoService extends GenericService{	
	public List<Pedido> getAll(){
		PedidoDao PedidoDao = new PedidoDao(entityManager);
		List<Pedido> PedidoList = new ArrayList<>();
		
		try {
			entityManager.getTransaction().begin();
			PedidoList = PedidoDao.findAll();
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
		return PedidoList;
	}
	
	public void saveUpdate(Pedido Pedido) {
		PedidoDao PedidoDao = new PedidoDao(entityManager);
				
		try {
			entityManager.getTransaction().begin();

			if(Pedido.getId() > 0l) {
				PedidoDao.update(Pedido);
			} else {
				PedidoDao.save(Pedido);				
			}
			
			entityManager.getTransaction().commit();
		}catch (Exception e) {
		
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
	}
	
	public void remove(Pedido Pedido) {
		PedidoDao PedidoDao = new PedidoDao(entityManager);
		try {
			entityManager.getTransaction().begin();
			PedidoDao.remove(Pedido);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
	}
}