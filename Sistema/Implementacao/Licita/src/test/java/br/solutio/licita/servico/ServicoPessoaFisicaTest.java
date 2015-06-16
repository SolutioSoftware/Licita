/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.servico;

import br.solutio.licita.modelo.InstituicaoLicitadora;
import br.solutio.licita.modelo.PessoaFisica;
import br.solutio.licita.modelo.PessoaJuridica;
import br.solutio.licita.persistencia.DaoIF;
import br.solutio.licita.persistencia.FabricaDaoIF;
import br.solutio.licita.util.ProdutorEntityManagerDeTeste;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Matheus Oliveira
 */
public class ServicoPessoaFisicaTest {

    ServicoPessoaFisica servico;
    PessoaFisica pf;
    PessoaFisica pfAux;
    DaoIF<PessoaFisica> dao;
    FabricaDaoIF fabrica;

    @Before
    public void setUp() {


       servico = new ServicoPessoaFisica(ProdutorEntityManagerDeTeste.getEntityManagerFactory().createEntityManager());

       pf = new PessoaFisica();
       pfAux = new PessoaFisica();
       
     
       pf.setCpf("123.123.123-56");       
       pfAux.setCpf("123.123.123-58");
       
       
       
    }

    @Test
    public void testarServicoPregao() {

        servico.criar(pf);
        servico.criar(pfAux);
        
        assertNotNull(pf.getId());
        assertNotNull(pfAux.getId());
        
        assertEquals(false, pf.equals(pfAux));
        
        assertEquals(4, servico.buscarTodos().size());
        
        servico.deletar(pfAux);
        servico.deletar(pfAux);

    }
    
   
    

}
