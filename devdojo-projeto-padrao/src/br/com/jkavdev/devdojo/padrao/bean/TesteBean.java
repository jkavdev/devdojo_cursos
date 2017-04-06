package br.com.jkavdev.devdojo.padrao.bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.jkavdev.devdojo.padrao.persistence.daointerfaces.Dao;
import br.com.jkavdev.devdojo.padrao.persistence.model.Projeto;

@Named
@ViewScoped
public class TesteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Dao<Projeto> dao;

	public void init() {
		System.out.println("Nice.......");
	}

}
