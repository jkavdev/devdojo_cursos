package com.stefanini.teste;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.stefanini.programa.CaixaEletronico;
import com.stefanini.programa.Nota;

public class CaixaEletronicoTeste {

	private CaixaEletronico caixaEletronico;
	private Integer saque;
	private Map<Nota, Integer> notas;	

	@Before
	public void setUp() {
		caixaEletronico = new CaixaEletronico();
		saque = null;
		notas = new HashMap<Nota, Integer>();
	}

	//------------------------------------------------
	//	VALIDADORES
	//------------------------------------------------
	@Test
	public void deveAceitarMultiplosDe10() {
		saque = 50;
		caixaEletronico.saque(saque);
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveAceitarNaoMultiplosDe10() {
		Integer saque = 55;
		caixaEletronico.saque(saque);
	}
	
	//------------------------------------------------
	//	SAQUE
	//------------------------------------------------
	@Test
	public void deveSacarUmaNotaDe100ParaSaqueDe100() {
		saque = 100;
		notas = caixaEletronico.saque(saque);
		
		assertTrue(notas.get(Nota.CEM) == 1);
	}

	@Test
	public void deveSacarUmaNotaDe100UmaDe50ParaSaqueDe150() {
		saque = 150;
		notas = caixaEletronico.saque(saque);
		
		assertTrue(notas.get(Nota.CEM) == 1);
		assertTrue(notas.get(Nota.CINQUENTA) == 1);
	}

	@Test
	public void deveSacarUmaNotaDe100UmaDe50UmaDe20ParaSaqueDe170() {
		saque = 170;
		notas = caixaEletronico.saque(saque);
		
		assertTrue(notas.get(Nota.CEM) == 1);
		assertTrue(notas.get(Nota.CINQUENTA) == 1);
		assertTrue(notas.get(Nota.VINTE) == 1);
	}
	
	@Test
	public void deveSacarUmaNotaDe100UmaDe10ParaSaqueDe110() {
		saque = 110;
		notas = caixaEletronico.saque(saque);
		
		assertTrue(notas.get(Nota.CEM) == 1);
		assertTrue(notas.get(Nota.DEZ) == 1);
	}
	
	@Test
	public void deveSacarTresNotasDe100UmaDe50UmaDe10ParaSaqueDe360() {
		saque = 360;
		notas = caixaEletronico.saque(saque);
		
		assertTrue(notas.get(Nota.CEM) == 3);
		assertTrue(notas.get(Nota.CINQUENTA) == 1);
		assertTrue(notas.get(Nota.DEZ) == 1);
	}
	
	//------------------------------------------------
	//	100
	//------------------------------------------------
	@Test
	public void deveCalcularUmaNotaDe100ParaSaqueDe100() {
		saque = 100;
		Integer saldoSaque = caixaEletronico.calcularNotasDe100(notas, saque);
		assertTrue(saldoSaque == 0);
		assertTrue(notas.get(Nota.CEM) == 1);
	}

	@Test
	public void deveCalcularUmaNotaDe100ParaSaqueDe150() {
		saque = 150;
		Integer saldoSalque = caixaEletronico.calcularNotasDe100(notas, saque);
		assertTrue(saldoSalque == 50);
		assertTrue(notas.get(Nota.CEM) == 1);
	}

	@Test
	public void deveCalcularDuasNotasDe100ParaSaqueDe200() {
		saque = 200;
		Integer saldoSaque = caixaEletronico.calcularNotasDe100(notas, saque);
		assertTrue(saldoSaque == 0);
		assertTrue(notas.get(Nota.CEM) == 2);
	}
	
	//------------------------------------------------
	//	50
	//------------------------------------------------
	@Test
	public void deveCalcularUmaNotaDe50ParaSaqueDe50() {
		saque = 50;
		Integer saldoSalque = caixaEletronico.calcularNotasDe50(notas, saque);
		assertTrue(saldoSalque == 0);
		assertTrue(notas.get(Nota.CINQUENTA) == 1);
	}
	
	@Test
	public void deveCalcularUmaNotaDe50ParaSaqueDe90() {
		saque = 90;
		Integer saldoSalque = caixaEletronico.calcularNotasDe50(notas, saque);
		assertTrue(saldoSalque == 40);
		assertTrue(notas.get(Nota.CINQUENTA) == 1);
	}

	@Test
	public void deveCalcularDuasNotasDe50ParaSaqueDe110() {
		saque = 110;
		Integer saldoSalque = caixaEletronico.calcularNotasDe50(notas, saque);
		assertTrue(saldoSalque == 10);
		assertTrue(notas.get(Nota.CINQUENTA) == 2);
	}
	//------------------------------------------------
	//	20
	//------------------------------------------------
	@Test
	public void deveCalcularUmaNotaDe20ParaSaqueDe20() {
		saque = 20;
		Integer saldoSalque = caixaEletronico.calcularNotasDe20(notas, saque);
		assertTrue(saldoSalque == 0);
		assertTrue(notas.get(Nota.VINTE) == 1);
	}
	
	@Test
	public void deveCalcularUmaNotaDe20ParaSaqueDe30() {
		saque = 30;
		Integer saldoSalque = caixaEletronico.calcularNotasDe20(notas, saque);
		assertTrue(saldoSalque == 10);
		assertTrue(notas.get(Nota.VINTE) == 1);
	}

	@Test
	public void deveCalcularDuasNotaDe20ParaSaqueDe40() {
		saque = 40;
		Integer saldoSalque = caixaEletronico.calcularNotasDe20(notas, saque);
		assertTrue(saldoSalque == 0);
		assertTrue(notas.get(Nota.VINTE) == 2);
	}
	
	//------------------------------------------------
	//	10
	//------------------------------------------------
	@Test
	public void deveCalcularUmaNotaDe10ParaSaqueDe10() {
		saque = 10;
		Integer saldoSalque = caixaEletronico.calcularNotasDe10(notas, saque);
		assertTrue(saldoSalque == 0);
		assertTrue(notas.get(Nota.DEZ) == 1);
	}
}
