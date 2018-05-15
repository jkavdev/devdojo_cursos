package com.stefanini.entidade;

import java.util.List;

public class CaixaEletronico {

	private Conta conta;
	
	private Integer[] saque;
	
	private List<Nota> notas;

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Integer[] getSaque() {
		return saque;
	}

	public void setSaque(Integer[] saque) {
		this.saque = saque;
	}

	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}
	
}