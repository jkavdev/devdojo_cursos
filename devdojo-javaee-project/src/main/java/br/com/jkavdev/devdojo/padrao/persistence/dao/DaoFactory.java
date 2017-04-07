package br.com.jkavdev.devdojo.padrao.persistence.dao;

import java.lang.reflect.ParameterizedType;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.jkavdev.devdojo.padrao.persistence.daointerfaces.Dao;

public class DaoFactory {

	@Inject
	private EntityManager manager;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Produces
	@Dependent
	public <T> Dao<T> createDao(InjectionPoint point) {
		ParameterizedType type = (ParameterizedType) point.getType();
		Class classe = (Class) type.getActualTypeArguments()[0];

		return new DaoImpl<T>(classe, manager);
	}

}
