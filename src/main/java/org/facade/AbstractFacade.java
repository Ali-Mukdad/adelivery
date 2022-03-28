package org.facade;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.eclipse.persistence.internal.jpa.EJBQueryImpl;
import org.eclipse.persistence.jpa.JpaEntityManager;
import org.eclipse.persistence.queries.DatabaseQuery;
import org.eclipse.persistence.sessions.DatabaseRecord;
import org.eclipse.persistence.sessions.Session;

@Stateless
public abstract class AbstractFacade<T> implements Serializable{

	private static final long serialVersionUID = -1L;
	protected Class<T> entityClass;
	@PersistenceContext(unitName = "ADelivery-persistence-unit")
	private EntityManager em;

	public AbstractFacade(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	protected EntityManager getEntityManager() {
		return em;
	}

	@Transactional
	public T save(T entity) throws Exception {
		return getEntityManager().merge(entity);
	}
	
	public T persist(T entity) {
		if (entity != null) {
			getEntityManager().persist(entity);
		}
		return entity;
	}

	@Transactional
	public void remove(T entity) throws Exception {
		getEntityManager().remove(getEntityManager().merge(entity));
	}

	public void remove(T[] entityArray) throws Exception {
		for (T entity : entityArray) {
			getEntityManager().remove(getEntityManager().merge(entity));
		}
	}

	public T find(Object id) {
		return getEntityManager().find(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<T> cq = (CriteriaQuery<T>) cb.createQuery();
		Root<T> r = cq.from(entityClass);
		cq.select(r);
		return getEntityManager().createQuery(cq).getResultList();
	}

	public List<T> findRange(int[] range) {
		CriteriaQuery<T> cq = getEntityManager().getCriteriaBuilder().createQuery(entityClass);
		cq.select(cq.from(entityClass));
		return getEntityManager().createQuery(cq).setMaxResults(range[1] - range[0]).setFirstResult(range[0])
				.getResultList();
	}

	public int count() {
		CriteriaQuery<Long> cq = getEntityManager().getCriteriaBuilder().createQuery(Long.class);
		Root<T> root = cq.from(entityClass);
		cq.select(getEntityManager().getCriteriaBuilder().count(root));
		return (getEntityManager().createQuery(cq).getSingleResult()).intValue();
	}

	@SuppressWarnings("deprecation")
	public T newEntity() throws InstantiationException, IllegalAccessException {
		return this.entityClass.newInstance();
	}

	public String getSqlFromJpql(Query query) {
		try {
			Session s = em.unwrap(JpaEntityManager.class).getActiveSession();
			DatabaseQuery dq = ((EJBQueryImpl<?>) query).getDatabaseQuery();
			dq.prepareCall(s, new DatabaseRecord());
			System.out.println(dq.getSQLString());
			return dq.getSQLString();
		} catch (Exception e) {
			System.out.println("error in query");
		}
		return null;
	}
}