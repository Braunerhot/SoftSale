package softsale.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import softsale.model.Funcionario;

public class FuncionarioDao extends GenericDao<Funcionario> {
	public FuncionarioDao(EntityManager entityManager) {
		super(entityManager);
	}
	
	public Funcionario autenticar(String cpf, String senha) {
    	String consulta = "SELECT f FROM Funcionario f WHERE f.cpf = :cpf AND f.senha = :senha";
        TypedQuery<Funcionario> query = getEntityManager().createQuery(consulta, getEntityClass());
        query.setParameter("cpf", cpf);
        query.setParameter("senha", senha);
    	
        Funcionario funcionario;
        
        try {
        	funcionario = query.getSingleResult();
		} catch (NoResultException e) {
			funcionario = null;
		}
        
    	return funcionario;
	}
}
