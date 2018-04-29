package teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import entidade.Conta;
import entidade.Pessoa;
import entidade.TipoConta;
import entidade.TipoPessoa;

public class ContaTest {

	@Test
	public void criarContaValidaTest() {
		Conta contaDoJhonatan = new Conta("213456", "3214", TipoConta.POUPANCA, jhonatan());
		
		assertEquals("213456", contaDoJhonatan.getNumConta());
		assertEquals("3214", contaDoJhonatan.getNumAgencia());
		assertEquals(TipoConta.POUPANCA, contaDoJhonatan.getTipo());
		assertEquals(0, contaDoJhonatan.getSaldo(), 0.00001);
		assertEquals(jhonatan().getNumeroCPF(), contaDoJhonatan.getPessoa().getNumeroCPF());
	}
	@Test(expected = IllegalArgumentException.class)
	public void falhaAoCriarContaInvalidaTest() {
		new Conta("213456", "3214", TipoConta.POUPANCA, null);
	}
	@Test
	public void depositarNaContaTest() {
		Conta contaDoJhonatan = contaDoJhonatan();

		contaDoJhonatan.depositar(150);

		assertEquals(150, contaDoJhonatan.getSaldo(), 0.00001);

		contaDoJhonatan.depositar(150);

		assertEquals(300, contaDoJhonatan.getSaldo(), 0.00001);
	}
    @Test(expected = IllegalArgumentException.class)
	public void naoPermiteDepositarValoresNegativosOuZeradosNaContaTest() {
		Conta contaDoJhonatan = contaDoJhonatan();

		contaDoJhonatan.depositar(0);
		contaDoJhonatan.depositar(-1);
	}
	@Test
	public void sacarDaContaTest() {
		Conta contaDoJhonatan = contaDoJhonatan();

        contaDoJhonatan.depositar(500);

		contaDoJhonatan.sacar(150);

		assertEquals(350, contaDoJhonatan.getSaldo(), 0.00001);

		contaDoJhonatan.sacar(150);

		assertEquals(200, contaDoJhonatan.getSaldo(), 0.00001);
	}
	@Test(expected = IllegalArgumentException.class)
	public void naoPermiteSacarValorMaiorQueTemNaContaTest() {
		Conta contaDoJhonatan = contaDoJhonatan();

        assertEquals(0, contaDoJhonatan.getSaldo(), 0.00001);

		contaDoJhonatan.sacar(150);
	}

	private Conta contaDoJhonatan() {
		return new Conta("213456", "3214", TipoConta.POUPANCA, jhonatan());
	}

	private Pessoa jhonatan() {
        return new Pessoa("Jhonatan", "123456789", TipoPessoa.FISICA);
    }

}
