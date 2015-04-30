package br.solutio.licita.modelo;

import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ricardocaldeira
 */
public class PregoeiroTest {

    Pregoeiro pregoeiro1, pregoeiro2;
    PregoeiroPK pregoeiroPK1, pregoeiroPK2;
    Sessao sessao1, sessao2;
    Set<Sessao> sessoes1, sessoes2;
    PessoaFisica pessoaFisica1, pessoaFisica2;
    Login login1, login2;

    /**
     * Metodo executado antes dos testes, iniciando os objetos e setandos seus
     * valores.
     */
    @Before
    public void setUp() {

        pregoeiro1 = new Pregoeiro();
        pregoeiro2 = new Pregoeiro();
        pregoeiroPK1 = new PregoeiroPK();
        pregoeiroPK2 = new PregoeiroPK();
        sessao1 = new Sessao();
        sessao2 = new Sessao();
        sessoes1 = new HashSet<Sessao>();
        sessoes2 = new HashSet<Sessao>();
        pessoaFisica1 = new PessoaFisica();
        pessoaFisica2 = new PessoaFisica();
        login1 = new Login();
        login2 = new Login();

        login1.setId(Long.MIN_VALUE);
        login1.setLogado(Boolean.TRUE);
        login1.setSenha("12345");
        login1.setUsuario("Ricardo");

        login2.setId(Long.MAX_VALUE);
        login2.setLogado(Boolean.FALSE);
        login2.setSenha("54321");
        login2.setUsuario("Ludmyla");

        pessoaFisica1.setId(Long.MIN_VALUE);
        pessoaFisica1.setCpf("999.999.999-99");
        pessoaFisica1.setNome("Ricardo");

        pessoaFisica2.setId(Long.MAX_VALUE);
        pessoaFisica2.setCpf("888.888.888-88");
        pessoaFisica2.setNome("Ludmyla");

        sessao1.setId(Long.MIN_VALUE);
        sessao2.setId(Long.MAX_VALUE);

        sessoes1.add(sessao1);
        sessoes2.add(sessao2);

        pregoeiroPK1.setId(Long.MIN_VALUE);
        pregoeiroPK1.setIdPessoaFisica(Long.MIN_VALUE);

        pregoeiroPK2.setId(Long.MAX_VALUE);
        pregoeiroPK2.setIdPessoaFisica(Long.MAX_VALUE);

        pregoeiro1.setLogin(login1);
        pregoeiro1.setPessoaFisica(pessoaFisica1);
        pregoeiro1.setPregoeiroPK(pregoeiroPK1);
        pregoeiro1.setSessaoSet(sessoes1);

        pregoeiro2.setLogin(login2);
        pregoeiro2.setPessoaFisica(pessoaFisica2);
        pregoeiro2.setPregoeiroPK(pregoeiroPK2);
        pregoeiro2.setSessaoSet(sessoes2);

    }

    @Test
    public void testGetPregoeiro() {

        assertEquals("Login de pregoeiro1 ok", login1, pregoeiro1.getLogin());
        assertEquals(pessoaFisica1, pregoeiro1.getPessoaFisica());
        assertEquals(pregoeiroPK1, pregoeiro1.getPregoeiroPK());
        assertEquals(sessoes1, pregoeiro1.getSessaoSet());

        assertEquals(login2, pregoeiro2.getLogin());
        assertEquals(pessoaFisica2, pregoeiro2.getPessoaFisica());
        assertEquals(pregoeiroPK2, pregoeiro2.getPregoeiroPK());
        assertEquals(sessoes2, pregoeiro2.getSessaoSet());
        

    }
    
    @Test
    public void testEqualsPregoeiro(){
        
        assertEquals(true, pregoeiro1.equals(pregoeiro1));
        assertEquals(false, pregoeiro1.equals(pregoeiro2));
    }

}
