/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.solutio.licita.servico;

import br.solutio.licita.modelo.Login;
import br.solutio.licita.persistencia.dao.DaoIF;
import br.solutio.licita.persistencia.dao.FabricaDAO;
import br.solutio.licita.persistencia.dao.TipoDAO;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Matheus Oliveira
 */
public class ServicoLoginTest {
    
    ServicoLoginIF servicoLogin;
    
    @Before
    public void setUp(){
        servicoLogin = new ServicoLogin();
        
    }
    
    @Test
    /**
     *Verificacao do metodo <verificarDados(String usuario, String senha)>,
     * que invoca um metodo do dao para verificar se os valores inseridos
     * sao validos para fazerem o login.
     */
    public void testVerificarDados(){
        assertEquals(false, servicoLogin.verificarDados("ads", "123"));
        assertEquals(false, servicoLogin.verificarDados("abs", "123"));
        assertEquals(false, servicoLogin.verificarDados("abs", null));
        assertEquals(false, servicoLogin.verificarDados(null, "123"));
        assertEquals(false, servicoLogin.verificarDados(null, null));
    }
    
}
