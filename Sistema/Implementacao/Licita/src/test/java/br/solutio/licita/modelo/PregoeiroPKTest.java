package br.solutio.licita.modelo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ricardocaldeira
 */
public class PregoeiroPKTest {

    PregoeiroPK pregoeiropk1, pregoeiropk2;

    /**
     * Metodo executado antes dos testes, iniciando os objetos e setandos seus
     * valores.
     */
    @Before
    public void setUp() {

        pregoeiropk1 = new PregoeiroPK();
        pregoeiropk2 = new PregoeiroPK();

        pregoeiropk1.setId(Long.MIN_VALUE);
        pregoeiropk1.setIdPessoaFisica(Long.MIN_VALUE);

        pregoeiropk2.setId(Long.MAX_VALUE);
        pregoeiropk2.setIdPessoaFisica(Long.MAX_VALUE);

    }

    /**
     * Testando Get do PregoeiroPK
     */
    @Test
    public void testGetPregoeiroPK() {

        assertEquals(Long.MIN_VALUE, pregoeiropk1.getId());
        assertEquals(Long.MIN_VALUE, pregoeiropk1.getIdPessoaFisica());
        assertNotEquals(Long.MAX_VALUE, pregoeiropk1.getId());

        assertEquals(Long.MAX_VALUE, pregoeiropk2.getId());
        assertEquals(Long.MAX_VALUE, pregoeiropk2.getIdPessoaFisica());
    }

    /**
     * Testando metodo Equals do PregoeiroPK
     */
    @Test
    public void testEqualsPregoeiroPK() {
        
        assertEquals(true, pregoeiropk1.equals(pregoeiropk1));
        assertEquals(false, pregoeiropk1.equals(pregoeiropk2));

    }

}
