package br.solutio.licita.modelo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ricardocaldeira
 */
public class LoginTest {

    Login login1, login2;

    /**
     * Metodo executado antes dos testes, iniciando os objetos e setandos seus valores.
     */
    @Before
    public void setUp() {
        System.out.println("LoginTest iniciado");
        login1 = new Login();
        login2 = new Login();
        
        login1.setLogado(true);
        login1.setSenha("12345");
        login1.setUsuario("Ricardo");
        login1.setId(Long.MIN_VALUE);

        login2.setLogado(true);
        login2.setSenha("54321");
        login2.setUsuario("Ludmyla");
        login2.setId(Long.MAX_VALUE);
    }

    /**
     * Metodo executado depois dos teste.
     */
    @After
    public void tearDown() {
        System.out.println("LoginTest finalizado");
    }


    /**
     * Testando Set do Login
     */
    @Test
    public void testGetLogin() {
        assertEquals("Ricardo", login1.getUsuario());
        assertEquals("12345", login1.getSenha());
        assertEquals(true, login1.getLogado());

        assertEquals("Ludmyla", login2.getUsuario());
        assertEquals("54321", login2.getSenha());
        assertEquals(true, login2.getLogado());

        assertNotEquals("Ricardo", login2.getUsuario());
        assertNotEquals("12345", login2.getSenha());
        assertNotEquals(false, login2.getLogado());
    }
    
    /**
     * Testando o metodo equals
     */
    @Test
    public void testEqualsLogin(){
        assertEquals(false, login1.equals(login2));
        assertEquals(true, login1.equals(login1));
    }

}
