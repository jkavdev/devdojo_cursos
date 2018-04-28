package teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import entidade.Pessoa;
import entidade.TipoPessoa;

public class PessoaTeste {

	@Test
	public void criaUmaPessoaFisicaValidaTest() {
		Pessoa jhonatan = new Pessoa("Jhonatan", "123456", TipoPessoa.Fisica);
		
		assertEquals("Jhonatan", jhonatan.getNome());
		assertEquals("123456", jhonatan.getNumeroCPF());
		assertEquals(TipoPessoa.Fisica, jhonatan.getTipo());
	}
	@Test(expected = IllegalArgumentException.class)
	public void falhaAoCriarUmaPessoaFisicaInvalidaValidaTest() {
		Pessoa jhonatan = new Pessoa("Jhonatan");
		jhonatan.setNumeroCPF(null);
	}
}
