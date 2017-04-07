package br.com.jkavdev.devdojo.padrao.persistence.daointerfaces;

import java.io.Serializable;
import java.util.List;

public interface Dao<T> extends Serializable {

	T save(T entity);

	T update(T entity);

	List<T> listAll();

	List<T> findByHqlQuery(String queryId, List<Object> values, int maxResults);

	List<T> findByHqlQueryNoParamaters(String queryId, int maxResults);
}
