package br.com.jkavdev.devdojo.padrao.bean;

import static br.com.jkavdev.devdojo.padrao.utils.FacesUtils.addSuccessMessage;
import static br.com.jkavdev.devdojo.padrao.utils.StringUtils.like;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.devdojo.padrao.annotations.Transactional;
import br.com.jkavdev.devdojo.padrao.persistence.daointerfaces.Dao;
import br.com.jkavdev.devdojo.padrao.persistence.model.Projeto;

@Named
@ViewScoped
public class TesteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Dao<Projeto> dao;
	
	private List<Projeto> projetos;
	
	private Projeto projeto;
	
	@Transactional
	public void construct() throws Exception{
		Projeto projeto = new Projeto();
		projeto.setNome("Projeto velho");
		
		dao.save(projeto);
		
		System.out.println("Nice.......");
		
		System.out.println(dao.listAll());
		
		List<Projeto> projetoPeloNome = dao.findByHqlQuery("searchProjectByName", Collections.singletonList("Projeto velho"), 0);
		
		System.out.println("Busca pelo nome: \n" + projetoPeloNome);
		
		List<Projeto> projetoPeloNomeEId = dao.findByHqlQuery("searchProjectByNameAndId", Arrays.asList(like("Projeto velho"), 1L), 0);
		
		System.out.println("Busca pelo nome e id: \n" + projetoPeloNomeEId);
		
		addSuccessMessage("sucesso");
		
		List<Projeto> projetoSemParametros = dao.findByHqlQueryNoParamaters("searchProject", 0);
		
		System.out.println(projetoSemParametros);
	}
	
	@PostConstruct
	public void init() throws Exception {
		projetos = dao.listAll();
	}
	
	public void mostrarProjeto(){
		System.out.println(projeto);
	}
	
	public List<Projeto> getProjetos() {
		return projetos;
	}
	
	public Projeto getProjeto() {
		return projeto;
	}

}
