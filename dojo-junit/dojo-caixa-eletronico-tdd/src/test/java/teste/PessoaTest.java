package teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import entidade.Pessoa;
import entidade.TipoPessoa;

public class PessoaTest {

	@Test
	public void criaUmaPessoaFisicaValidaTest() {
		Pessoa jhonatan = new Pessoa("Jhonatan", "123456", TipoPessoa.FISICA);
		
		assertEquals("Jhonatan", jhonatan.getNome());
		assertEquals("123456", jhonatan.getNumeroCPF());
		assertEquals(TipoPessoa.FISICA, jhonatan.getTipo());
	}
	@Test(expected = IllegalArgumentException.class)
	public void falhaAoCriarUmaPessoaFisicaInvalidaValidaTest() {
		Pessoa jhonatan = new Pessoa("Jhonatan");
		jhonatan.setNumeroCPF(null);
	}
}
