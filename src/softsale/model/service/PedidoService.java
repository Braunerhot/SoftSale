package softsale.model.service;

import java.util.ArrayList;
import java.util.List;

import softsale.model.Item;
import softsale.model.Pedido;
import softsale.model.dao.ItemDao;
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
	
	public void saveUpdate(Pedido pedido) {
		PedidoDao pedidoDao = new PedidoDao(entityManager);
		ItemDao itemDao = new ItemDao(entityManager);
				
		try {
			entityManager.getTransaction().begin();

			for(Item item: pedido.getItens()) {
				if(item.getId() > 0l) {
					itemDao.update(item);			
				} else {
					itemDao.save(item);
				}
			}
			
			if(pedido.getId() > 0l) {
				pedidoDao.update(pedido);
			} else {
				pedidoDao.save(pedido);
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