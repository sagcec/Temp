package br.com.defaultproject.sgr.model.business;

import java.util.List;

/**
 * 
 * @author Gutemberg A Da Silva
 * 
 */

public interface AbstractBusiness<T> {

	public List<T> autocomplete(String suggest) throws Exception;

	public void delete(T entity) throws Exception;

	public void insert(T entity) throws Exception;

	public List<T> search(T entity) throws Exception;

	public void update(T entity) throws Exception;

}