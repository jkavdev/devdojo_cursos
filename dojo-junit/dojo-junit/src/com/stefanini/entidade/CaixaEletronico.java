package com.stefanini.entidade;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.OperationNotSupportedException;

public class CaixaEletronico {

	private Conta conta;

	private Integer[] saque;

	private List<Nota> notas;

	private int saldo;

	public CaixaEletronico() {
	}

	public CaixaEletronico(List<Nota> notas) {
		this.notas = notas;
		Collections.sort(this.notas, Comparator.comparing(Nota::getQualNota).reversed());
		this.saldo = notas.stream().mapToInt(n -> n.getQualNota() * n.getTotalNota()).sum();
	}

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

	public double mostrarSaldo(Conta conta) {
		return conta.getSaldo();
	}

	public double realizarSaque(int valor) throws OperationNotSupportedException {
		if (!temDinheiroNoCaixa(valor)) {
			throw new OperationNotSupportedException("Saque nao permitido");
		}
		
		int i = 0;
		int valorSaque = valor;
		int size = notas.size();
		Map<Integer, Integer> notasEntregues = new HashMap<>();

		for (i = 0; i < size; i++) {
			Nota nota = notas.get(i);
			int axu = valorSaque;
			axu = valorSaque - nota.getQualNota().intValue();
			if (axu < 0) {
				continue;
			} else {
				int a = 0;
				if (notasEntregues.containsKey(nota.getQualNota())) {
					a = notasEntregues.get(nota.getQualNota());
				}
				a++;
				notasEntregues.put(nota.getQualNota(), a);
				valorSaque = axu;
				nota.setTotalNota(nota.getTotalNota() - 1);
				if (nota.getTotalNota() > 0) {
					i--;
				} else {
					notas = notas.subList(++i, notas.size());
					// rever isso
					i--;
				}

				if (axu == 0) {
					break;
				}
			}
		}

		return notasEntregues.entrySet().stream().mapToInt(d -> d.getValue() * d.getKey()).sum();
	}

	private boolean temDinheiroNoCaixa(int valor) {
		return valor <= this.saldo;
	}

	public void logarCom(Conta conta) {
		this.conta = conta;
	}

}