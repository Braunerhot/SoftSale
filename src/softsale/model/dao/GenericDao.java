package softsale.model.dao;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class GenericDao<T> {

    private final Class<T> entityClass;
    private final EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public GenericDao(EntityManager entityManager) {
        this.entityClass = (Class<T>) ((ParameterizedType) getClass()
        		.getGenericSuperclass()).getActualTypeArguments()[0];
        this.entityManager = entityManager;
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public T getById(Long id){
        return (T) getEntityManager().find(getEntityClass(), id);
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
    	String consulta = String.format("FROM %s", getEntityClass().getName());
        return getEntityManager().createQuery(consulta).getResultList();
    }

    public void save(T entity){
        getEntityManager().persist(entity);
    }

    public void update(T entity){
        getEntityManager().merge(entity);
    }

    public void remove(T entity){
        getEntityManager().remove(entity);
    }
}
