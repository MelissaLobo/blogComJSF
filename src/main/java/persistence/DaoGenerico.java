package persistence;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import util.EntityLocal;
import util.JpaUseful;

public abstract class DaoGenerico<T, I extends Serializable> {
	// T é o tipo, a classe. E I é o tipo do id, int ou long

	protected final EntityManager entityManager;
	protected final Class<T> clazz;

	protected DaoGenerico() {
		this.entityManager = EntityLocal.currentEntityManager.get();

		@SuppressWarnings("unchecked")
		Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

		this.clazz = clazz;
	}

	public void create(T entity) {
		try {
			entityManager.persist(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public T update(T entity) {
		T entityUpdated = null;
		try {
			entityUpdated = entityManager.merge(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entityUpdated;

	}

	public void destroy(T entity) {
		try {
			entityManager.remove(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public T find(I id) {

		T object = null;

		try {
			object = entityManager.find(clazz, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {

		List<T> resultList = null;

		try {
			Query query = entityManager.createQuery("from " + clazz.getName());
			resultList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}
}