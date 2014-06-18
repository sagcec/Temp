package br.com.defaultproject.sgr.model.dao;

import javax.persistence.EntityManager;

/**
 * 
 * @author Gutemberg A Da Silva
 * 
 */

public interface AbstractDAO<T> {

	public EntityManager getEntityManager();

	public void setEntityManager(EntityManager entityManager);

	// manter sessao
	public void connection(T entity) throws Exception;

	// excluir
	public void delete(T entity, Long id) throws Exception;

	public void flushAndClear() throws Exception;

	// inserir
	public void insert(T entity) throws Exception;

	// atualizar
	public void update(T entity) throws Exception;

	/**
	 * LOTE
	 */

	// inserir
	public void insertBatch(T entity) throws Exception;

	// atualizar
	public void updateBatch(T entity) throws Exception;

}