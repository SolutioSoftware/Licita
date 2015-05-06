/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.solutio.licita.controlador.unidade;

import br.solutio.licita.controlador.ControladorLogin;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Matheus Oliveira
 */
public class ControladorLoginTest {
    
    ControladorLogin cl;
    ControladorLogin cl2;
    ControladorLogin cl3;
    ControladorLogin cl4;
    @Before
    public void setUp(){
        cl = new ControladorLogin();
        cl.getEntidade().setSenha("123");
        cl.getEntidade().setUsuario("ads");
        cl2 = new ControladorLogin();
        cl2.getEntidade().setSenha("abra");
        cl2.getEntidade().setUsuario("mamae");
        cl3 = new ControladorLogin();
        cl3.getEntidade().setSenha(null);
        cl3.getEntidade().setUsuario("ads");
        cl4 = new ControladorLogin();
        cl4.getEntidade().setSenha("123");
        cl4.getEntidade().setUsuario(null);
    }
    
    @Test
    public void testEfetuarLogin(){
        assertEquals(false, cl.efetuarLogin());
        assertEquals(false, cl2.efetuarLogin());
        assertEquals(false, cl3.efetuarLogin());
        assertEquals(false, cl4.efetuarLogin());
    }
}
