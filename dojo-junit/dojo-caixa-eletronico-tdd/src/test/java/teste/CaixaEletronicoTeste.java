package teste;

import entidade.CaixaEletronico;
import entidade.Conta;
import entidade.Nota;
import entidade.Pessoa;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CaixaEletronicoTeste {

    @Test
    public void mostrarSaldoTest() {

        CaixaEletronico caixa = caixaEletronico();

        caixa.logarCom(contaDoJhonatan());

        assertEquals(500, caixa.mostrarSaldo(), 0.0001);
    }

    @Test
    public void realizarSaqueTest() throws OperationNotSupportedException {

        CaixaEletronico caixa = caixaEletronico();

        caixa.logarCom(contaDoJhonatan());

        assertEquals(122, caixa.realizarSaque(122), 0.0001);
    }
    
    @Test
    public void realizarSaqueNovoTest() throws OperationNotSupportedException {
    	
    	CaixaEletronico caixa = caixaEletronico();
    	
    	caixa.logarCom(contaDoJhonatan());
    	
    	assertEquals(122, caixa.sacar(122), 0.0001);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void naoPermitirSaqueCasoSaqueMaiorQueSaldoTest() throws OperationNotSupportedException {

        CaixaEletronico caixa = caixaEletronicoSemNotas();

        caixa.logarCom(contaDoJhonatan());

        caixa.realizarSaque(403);
    }

    private Conta contaDoJhonatan() {
        Pessoa jhonatan = new Pessoa("Jhonatan", "123456789", 'F');
        return new Conta("123456", "4567", 'A', 500, jhonatan);
    }

    private CaixaEletronico caixaEletronico() {
        CaixaEletronico caixa = new CaixaEletronico();
        List<Nota> notas = Arrays.asList(new Nota(100, 1), new Nota(50, 5), new Nota(2, 1), new Nota(5, 10));
        caixa.setNotas(notas);
        return caixa;
    }
    private CaixaEletronico caixaEletronicoSemNotas() {
        CaixaEletronico caixa = new CaixaEletronico();
        return caixa;
    }

}