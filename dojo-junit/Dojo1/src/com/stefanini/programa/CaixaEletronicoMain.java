package com.stefanini.programa;

public class CaixaEletronicoMain {

	public static void main(String[] args) {
		CaixaEletronico caixaEletronico = new CaixaEletronico();
		caixaEletronico.saque(200);
		caixaEletronico.saque(40);
		caixaEletronico.saque(500);
	}
	
}