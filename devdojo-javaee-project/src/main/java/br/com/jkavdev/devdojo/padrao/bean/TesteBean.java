package br.com.jkavdev.devdojo.padrao.bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.devdojo.padrao.persistence.daointerfaces.Dao;
import br.com.jkavdev.devdojo.padrao.persistence.model.Projeto;

@Named
@ViewScoped
public class TesteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Dao<Projeto> dao;

	public void init() {
		Projeto projeto = new Projeto();
		projeto.setNome("Projeto velho");
		
		dao.save(projeto);
		
		System.out.println("Nice.......");
	}

}