package entidade;

import java.util.ArrayList;
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
		setNotas(notas);
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
		ordenarNotasPelasMaiores();
		this.saldo = obterSaldo(notas);
	}

	public double mostrarSaldo() {
		return this.conta.getSaldo();
	}

	public void logarCom(Conta conta) {
		this.conta = conta;
	}

	public double realizarSaque(int valor) throws OperationNotSupportedException {
		if (saldoInsuficienteNoCaixa(valor)) {
			throw new OperationNotSupportedException("Saque nao permitido");
		}

		int i = 0;
		int valorSaque = valor;
		int size = notas.size();
		Map<Integer, Integer> notasEntregues = new HashMap<>();

		for (i = 0; i < size; i++) {
			Nota nota = notas.get(i);
			int axu = valorSaque;
			axu = valorSaque - nota.getEspecie().intValue();
			if (axu < 0) {
				continue;
			} else {
				int a = 0;
				if (notasEntregues.containsKey(nota.getEspecie())) {
					a = notasEntregues.get(nota.getEspecie());
				}
				a++;
				notasEntregues.put(nota.getEspecie(), a);
				valorSaque = axu;
				nota.setQtde(nota.getQtde() - 1);
				if (nota.getQtde() > 0) {
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

	public double sacar(int valor) throws OperationNotSupportedException {
		if (saldoInsuficienteNoCaixa(valor)) {
			throw new OperationNotSupportedException("Saque nao permitido");
		}
		List<Nota> notasEntregues = new ArrayList<>();

		for (int i = 0; i < notas.size(); i++) {
			Nota nota = notas.get(i);
			if (valor >= nota.getEspecie().intValue()) {
				valor -= nota.getEspecie().intValue();
				notasEntregues.add(new Nota(nota.getEspecie(), 1));
				
				if (valor >= nota.getEspecie().intValue()) {
					i--;
				}
				if (valor == 0) {
					break;
				}
			}
		}

		return notasEntregues.stream().mapToInt(n -> n.getEspecie()).sum();
	}

	private int obterSaldo(List<Nota> notas) {
		return notas.stream().mapToInt(n -> n.getEspecie() * n.getQtde()).sum();
	}

	private void ordenarNotasPelasMaiores() {
		Collections.sort(this.notas, Comparator.comparing(Nota::getEspecie).reversed());
	}

	private boolean saldoSuficienteNoCaixa(int valor) {
		return valor <= this.saldo;
	}

	private boolean saldoInsuficienteNoCaixa(int valor) {
		return !saldoSuficienteNoCaixa(valor);
	}

}