package br.solutio.licita.modelo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ricardocaldeira
 */
public class InstituicaoLicitadoraPKTest {

    InstituicaoLicitadoraPK instituicaoPK1, instituicaoPK2;

    /**
     * Metodo executado antes dos testes, iniciando os objetos e setandos seus
     * valores.
     */
    @Before
    public void setUp() {
        instituicaoPK1 = new InstituicaoLicitadoraPK();
        instituicaoPK2 = new InstituicaoLicitadoraPK();

        instituicaoPK1.setId(Long.MIN_VALUE);
        instituicaoPK1.setIdPessoaJuridica(Long.MIN_VALUE);

        instituicaoPK2.setId(Long.MAX_VALUE);
        instituicaoPK2.setIdPessoaJuridica(Long.MAX_VALUE);

        System.out.println("InstituicaoLicitadoraPKTest iniciado");
    }

    /**
     * Metodo executado depois dos teste.
     */
    @After
    public void tearDown() {
        System.out.println("InstituicaoLicitadoraPKTest finalizado");
    }

    /**
     * testando Get da InstituicaoLicitadoraPK.
     */
    @Test
    public void testGetInstituicaoLicitadoraPK() {

        assertEquals(Long.MIN_VALUE, instituicaoPK1.getId());
        assertEquals(Long.MAX_VALUE, instituicaoPK2.getId());

    }

    /**
     * Testando metodo Equals da InstituicaoLicitadoraPK.
     */
    @Test
    public void testEqualsInstituicaoLicitadoraPK() {

        assertEquals(false, instituicaoPK1.equals(instituicaoPK2));
        assertEquals(true, instituicaoPK1.equals(instituicaoPK1));

    }
}
