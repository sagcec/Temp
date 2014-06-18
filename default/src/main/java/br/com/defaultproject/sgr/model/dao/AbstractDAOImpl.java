package br.com.defaultproject.sgr.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;

/**
 * 
 * @author Gutemberg A Da Silva
 * 
 */

public class AbstractDAOImpl<T> implements AbstractDAO<T> {

	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	// manter sessao
	public void connection(T entity) throws Exception {
		this.getEntityManager().lock(entity, LockModeType.READ);
	}

	// excluir
	public void delete(T entity, Long id) throws Exception {
		this.getEntityManager().remove(
				this.getEntityManager().getReference(entity.getClass(), id));
	}

	public void flushAndClear() throws Exception {
		Session sessao = (Session) this.getEntityManager().getDelegate();

		if (sessao.isDirty()) {
			sessao.flush();
			sessao.clear();
		}
	}

	// inserir
	public void insert(T entity) throws Exception {
		this.getEntityManager().persist(entity);
	}

	// atualizar
	public void update(T entity) throws Exception {
		this.getEntityManager().merge(entity);
	}

	/**
	 * LOTE
	 */

	// inserir
	public void insertBatch(T entity) throws Exception {
		this.getEntityManager().persist(entity);
	}

	// atualizar
	public void updateBatch(T entity) throws Exception {
		this.getEntityManager().merge(entity);
	}

}