package teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import entidade.Conta;
import entidade.Pessoa;
import entidade.TipoConta;
import entidade.TipoPessoa;

public class ContaTeste {

	@Test
	public void criarContaValidaTest() {
		Conta contaDoJhonatan = new Conta("213456", "3214", TipoConta.POUPANCA, 1235, jhonatan());
		
		assertEquals("213456", contaDoJhonatan.getNumConta());
		assertEquals("3214", contaDoJhonatan.getNumAgencia());
		assertEquals(TipoConta.POUPANCA, contaDoJhonatan.getTipo());
		assertEquals(1235, contaDoJhonatan.getSaldo(), 0.00001);
		assertEquals(jhonatan().getNumeroCPF(), contaDoJhonatan.getPessoa().getNumeroCPF());
	}
	@Test(expected = IllegalArgumentException.class)
	public void falhaAoCriarContaInvalidaTest() {
		new Conta("213456", "3214", TipoConta.POUPANCA, 1235, null);
	}
	
	private Pessoa jhonatan() {
        return new Pessoa("Jhonatan", "123456789", TipoPessoa.Fisica);
    }

}
