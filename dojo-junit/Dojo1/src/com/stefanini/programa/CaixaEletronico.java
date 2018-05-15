package com.stefanini.programa;

import java.util.HashMap;
import java.util.Map;

public class CaixaEletronico {

	public Map<Nota, Integer> saque(Integer saque) {
		if (saque % 10 != 0) {
			throw new IllegalArgumentException("O caixa só aceita múltiplos de 10");
		}
		Map<Nota, Integer> notas = new HashMap<Nota, Integer>();
		saque = calcularNotasDe100(notas, saque);
		saque = calcularNotasDe50(notas, saque);
		saque = calcularNotasDe20(notas, saque);
		calcularNotasDe10(notas, saque);
		return notas;
	}

	public Integer calcularNotasDe100(Map<Nota, Integer> notas, Integer saque) {
		int qtdNotasCem = saque / 100;
		notas.put(Nota.CEM, qtdNotasCem);
		return saque - 100 * qtdNotasCem;
	}

	public Integer calcularNotasDe50(Map<Nota, Integer> notas, Integer saque) {
		int qtdNotasCinquenta = saque / 50;
		notas.put(Nota.CINQUENTA, qtdNotasCinquenta);
		return saque - 50 * qtdNotasCinquenta;
	}

	public Integer calcularNotasDe20(Map<Nota, Integer> notas, Integer saque) {
		int qtdNotasVinte = saque / 20;
		notas.put(Nota.VINTE, qtdNotasVinte);
		return saque - 20 * qtdNotasVinte;
	}

	public Integer calcularNotasDe10(Map<Nota, Integer> notas, Integer saque) {
		int qtdNotasDez = saque / 10;
		notas.put(Nota.DEZ, qtdNotasDez);
		return saque - 10 * qtdNotasDez;
	}
	
}