package softsale.model.dao;

import javax.persistence.EntityManager;

import softsale.model.Funcionario;

public class FuncionarioDao extends GenericDao<Funcionario> {
	public FuncionarioDao(EntityManager entityManager) {
		super(entityManager);
	}
}
