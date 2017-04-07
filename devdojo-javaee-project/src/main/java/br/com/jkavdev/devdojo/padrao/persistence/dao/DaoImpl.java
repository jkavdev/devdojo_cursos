package br.com.jkavdev.devdojo.padrao.persistence.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.jkavdev.devdojo.padrao.persistence.daointerfaces.Dao;
import br.com.jkavdev.devdojo.padrao.persistence.fileservice.FileXmlService;

public class DaoImpl<T> implements Dao<T> {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager manager;

	private final Class<T> classe;

	// Classe com as consultas
	private static final FileXmlService hqlQuery;
	private static final FileXmlService sqlQuery;

	static {
		hqlQuery = new FileXmlService("hql.xml");
		sqlQuery = new FileXmlService("sql.xml");
	}

	public DaoImpl(Class<T> classe, EntityManager manager) {
		this.classe = classe;
		this.manager = manager;
	}

	@Override
	public T save(T entity) {
		manager.persist(entity);
		manager.flush();

		return entity;
	}

	@Override
	public T update(T entity) {
		manager.merge(entity);
		manager.flush();
		return entity;
	}

	@Override
	public List<T> listAll() {
		return manager.createQuery("from " + classe.getSimpleName(), classe).getResultList();
	}

	/**
	 * Retorna uma consulta de acordo com o id da consulta, seus parametros e
	 * quantidade de registros
	 */
	@Override
	public List<T> findByHqlQuery(String queryId, List<Object> values, int maxResults) {
		// Retorna a consulta de acordo com o id passado
		String hql = hqlQuery.findValue(queryId);
		// Retorna apenas os parametros da consulta
		Pattern pattern = Pattern.compile("(:\\w+)");
		Matcher matcher = pattern.matcher(hql);

		// Adiciona os parametros da consulta na lista de parametros
		List<String> params = new ArrayList<>();
		while (matcher.find()) {
			params.add(matcher.group().replace(":", ""));
		}

		TypedQuery<T> query = manager.createQuery(hql, classe);

		// Atribui os parametros retornados na consulta
		for (int i = 0; i < params.size(); i++) {
			query.setParameter(params.get(i), values.get(i));
		}

		// Retorna ou nao uma consulta com registros maximos
		return maxResults == 0 ? query.getResultList() : query.setMaxResults(maxResults).getResultList();
	}

}
