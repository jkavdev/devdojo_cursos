package com.stefanini.entidade;

public class Pessoa {

	private String nome;
	
	/**
	 * Tipos: F = Fisica; J = Juridica
	 */
	private Character tipoPessoJuridica;
	
	private String numeroCPF;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Character getTipoPessoJuridica() {
		return tipoPessoJuridica;
	}

	public void setTipoPessoJuridica(Character tipoPessoJuridica) {
		this.tipoPessoJuridica = tipoPessoJuridica;
	}

	public String getNumeroCPF() {
		return numeroCPF;
	}

	public void setNumeroCPF(String numeroCPF) {
		this.numeroCPF = numeroCPF;
	}
	
}