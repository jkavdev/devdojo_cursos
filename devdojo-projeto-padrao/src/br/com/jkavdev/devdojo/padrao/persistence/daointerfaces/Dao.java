package br.com.jkavdev.devdojo.padrao.persistence.daointerfaces;

import java.io.Serializable;
import java.util.List;

public interface Dao<T> extends Serializable {

	public abstract T save(T entity);

	public abstract T update(T entity);

	public abstract List<T> listAll(T entity);
}
