package teste;

import entidade.Nota;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class NotaTest {

    @Test
    public void criaUmaNotaTest() {
        Nota notaDe20 = new Nota(20);
        assertNotNull(notaDe20);
        assertEquals(20, notaDe20.getEspecie().intValue());
    }
    @Test
    public void criaUmaNotaComQuantidadeTest() {
        Nota notaDe20 = new Nota(20, 20);
        assertNotNull(notaDe20);
        assertEquals(20, notaDe20.getEspecie().intValue());
        assertEquals(20, notaDe20.getQtde().intValue());
    }
    @Test(expected = NullPointerException.class)
    public void falhaAoCriaUmaNotaInvalidaTest() {
        Nota notaDe20 = new Nota(null);
    }
    @Test(expected = NullPointerException.class)
    public void falhaAoCriaUmaNotaComQuantidadeTest() {
        Nota notaDe20 = new Nota(20, null);
    }

}
