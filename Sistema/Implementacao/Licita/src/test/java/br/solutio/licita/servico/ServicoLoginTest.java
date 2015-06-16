/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.servico;

import br.solutio.licita.modelo.Login;
import br.solutio.licita.modelo.MembroApoio;
import br.solutio.licita.modelo.PessoaFisica;
import br.solutio.licita.modelo.Pregoeiro;
import br.solutio.licita.persistencia.DaoIF;
import br.solutio.licita.persistencia.FabricaDaoIF;
import br.solutio.licita.servico.util.Criptografar;
import br.solutio.licita.util.ProdutorEntityManagerDeTeste;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Matheus Oliveira
 */
public class ServicoLoginTest {

    ServicoLogin servico;
    PessoaFisica pf;
    PessoaFisica pfAux;
    Login login;
    Login loginAux; 
    Pregoeiro membro;
    Pregoeiro membroAux;
    DaoIF<Login> dao;
    FabricaDaoIF fabrica;

    @Before
    public void setUp() {


       servico = new ServicoLogin(ProdutorEntityManagerDeTeste.getEntityManagerFactory().createEntityManager());

       pf = new PessoaFisica();
       pfAux = new PessoaFisica();
       
       membro = new Pregoeiro();
       membroAux = new Pregoeiro();
     
       pf.setCpf("123.123.123-32");       
       pfAux.setCpf("123.123.123-23");
       
       login = new Login();
       loginAux = new Login();
       
       login.setUsuario("abe");
       login.setSenha(Criptografar.getInstance().criptografar("johnn"));
       
       loginAux.setUsuario("aby");
       loginAux.setSenha("johnny");
       
       membro.setPessoaFisica(pf);
       membroAux.setPessoaFisica(pfAux);
       
       membro.setLogin(login);
       membroAux.setLogin(loginAux);
       
    }

    @Test
    public void testarServicoPregao() {

        servico.criar(login);
        servico.criar(loginAux);
        
        assertNotNull(login.getId());
        assertNotNull(loginAux.getId());
        
        assertEquals(false, login.equals(loginAux));
        assertEquals(false, login.getUsuario().equals(loginAux.getUsuario()));
        assertEquals(false, login.getSenha().equals(loginAux.getSenha()));
        
        assertEquals(4, servico.buscarTodos().size());

    }
    
    @Test
    public void testarCriptografia(){
        
        assertEquals(true, servico.verificarDados("abe", "johnn"));
        assertEquals(false, servico.verificarDados("gunt", login.getSenha()));
        
        
    }
    
   
    

}
