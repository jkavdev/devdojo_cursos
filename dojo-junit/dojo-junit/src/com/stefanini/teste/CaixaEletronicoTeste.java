package com.stefanini.teste;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.junit.Test;

import com.stefanini.entidade.CaixaEletronico;
import com.stefanini.entidade.Conta;
import com.stefanini.entidade.Nota;
import com.stefanini.entidade.Pessoa;

public class CaixaEletronicoTeste {

	@Test
	public void mostrarSaldoTest() {

		CaixaEletronico caixa = new CaixaEletronico();

		assertEquals(500, caixa.mostrarSaldo(contaDoJhonatan()), 0.0001);
	}
	
	@Test
	public void realizarSaqueTest() throws OperationNotSupportedException {
		
		List<Nota> notas = Arrays.asList(new Nota(100, 1), new Nota(50, 5), new Nota(2, 1), new Nota(5, 10));
		CaixaEletronico caixa = new CaixaEletronico(notas);
		
		caixa.logarCom(contaDoJhonatan());
		
		assertEquals(122, caixa.realizarSaque(122), 0.0001);
	}
	
	@Test(expected = OperationNotSupportedException.class)
	public void naoPermitirSaqueCasoSaqueMaiorQueSaldoTest() throws OperationNotSupportedException {
		
		List<Nota> notas = Arrays.asList(new Nota(100, 1), new Nota(50, 5), new Nota(2, 1), new Nota(5, 10));
		CaixaEletronico caixa = new CaixaEletronico(notas);
		
		caixa.logarCom(contaDoJhonatan());
		
		caixa.realizarSaque(403);
	}	

	private Conta contaDoJhonatan() {
		Pessoa jhonatan = new Pessoa("Jhonatan", "123456789", 'F');
		return new Conta("123456", "4567", 'A', 500, jhonatan);
	}

}
