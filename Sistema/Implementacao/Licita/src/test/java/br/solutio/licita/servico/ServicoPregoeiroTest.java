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
public class ServicoPregoeiroTest {

    ServicoPregoeiro servico;
    PessoaFisica pf;
    PessoaFisica pfAux;
    Login login;
    Login loginAux; 
    Pregoeiro membro;
    Pregoeiro membroAux;
    DaoIF<Pregoeiro> dao;
    FabricaDaoIF fabrica;

    @Before
    public void setUp() {


       servico = new ServicoPregoeiro(ProdutorEntityManagerDeTeste.getEntityManagerFactory().createEntityManager());

       pf = new PessoaFisica();
       pfAux = new PessoaFisica();
       
       membro = new Pregoeiro();
       membroAux = new Pregoeiro();
     
       pf.setCpf("123.123.123-32");       
       pfAux.setCpf("123.123.123-23");
       
       login = new Login();
       loginAux = new Login();
       
       login.setUsuario("abe");
       login.setSenha("johnn");
       
       loginAux.setUsuario("aby");
       loginAux.setSenha("johnny");
       
       membro.setPessoaFisica(pf);
       membroAux.setPessoaFisica(pfAux);
       
       membro.setLogin(login);
       membroAux.setLogin(loginAux);
       
    }

    @Test
    public void testarServicoPregao() {

        servico.criar(membro);
        servico.criar(membroAux);
        
        assertNotNull(membro.getId());
        assertNotNull(membroAux.getId());
        
        assertEquals(false, membro.equals(membroAux));
        
        assertEquals(4, servico.buscarTodos().size());
        
        servico.deletar(membro);
        servico.deletar(membroAux);

    }
    

    
   
    

}
