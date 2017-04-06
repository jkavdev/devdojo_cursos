package br.com.jkavdev.devdojo.padrao.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.jkavdev.devdojo.padrao.persistence.daointerfaces.Dao;

public class DaoImpl<T> implements Dao<T> {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager manager;

	private final Class<T> classe;

	public DaoImpl(Class<T> classe, EntityManager manager) {
		this.classe = classe;
		this.manager = manager;
	}

	@Override
	public T save(T entity) {
		manager.persist(entity);
		return entity;
	}

	@Override
	public T update(T entity) {
		return null;
	}

	@Override
	public List<T> listAll(T entity) {
		return null;
	}

}
