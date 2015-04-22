package br.solutio.licita.modelo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ricardocaldeira
 */
public class InstituicaoLicitadoraTest {
    
    InstituicaoLicitadora instituicao1, instituicao2;
    InstituicaoLicitadoraPK instituicaoPK3, instituicaoPK4;
    PessoaJuridica pessoaJuridica5, pessoaJuridica6;
    
    /**
     * Metodo executado antes dos testes, iniciando os objetos e setando seus valores.
     */
    @Before
    public void setUp() {
        
        instituicao1 = new InstituicaoLicitadora();
        instituicao2 = new InstituicaoLicitadora();
        instituicaoPK3 = new InstituicaoLicitadoraPK();
        instituicaoPK4 = new InstituicaoLicitadoraPK();
        pessoaJuridica5 = new PessoaJuridica();
        pessoaJuridica6 = new PessoaJuridica();
        
        instituicaoPK3.setId(Long.MIN_VALUE);
        instituicaoPK3.setIdPessoaJuridica(Long.MIN_VALUE);
        
        instituicaoPK4.setId(Long.MAX_VALUE);
        instituicaoPK4.setIdPessoaJuridica(Long.MAX_VALUE);
        
        pessoaJuridica5.setRazaoSocial("Ricardo");
        pessoaJuridica6.setRazaoSocial("Ludmyla");
        
        instituicao1.setInstituicaoLicitadoraPK(instituicaoPK3);
        instituicao1.setPessoaJuridica(pessoaJuridica5);
        
        instituicao2.setInstituicaoLicitadoraPK(instituicaoPK4);
        instituicao2.setPessoaJuridica(pessoaJuridica6);
        
        System.out.println("InstituicaoLicitadoraTest iniciado");
    }

    /**
     * Metodo executado depois dos teste.
     */
    @After
    public void tearDown() {
        System.out.println("InstituicaoLicitadoraTest finalizado");
    }
    
    /**
     * testando Set da InstituicaoLicitadora.
     */
    @Test
    public void testGetInstituicaoLicitadora(){
        
        assertEquals(instituicaoPK3, instituicao1.getInstituicaoLicitadoraPK());
        assertEquals(instituicaoPK4, instituicao2.getInstituicaoLicitadoraPK());
        
        assertEquals("Ricardo", instituicao1.getPessoaJuridica().getRazaoSocial());
        assertEquals("Ludmyla", instituicao2.getPessoaJuridica().getRazaoSocial());
        
    }
    
    /**
     * Testando Metodo equals da InstituicaoLicitadora.
     */
    @Test
    public void testEqualsInstituicaoLicitadora(){
        
        assertEquals(false, instituicao1.equals(instituicao2));
        assertEquals(true, instituicao1.equals(instituicao1));
    }

}
