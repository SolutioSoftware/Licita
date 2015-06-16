/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.servico;

import br.solutio.licita.modelo.MembroApoio;
import br.solutio.licita.modelo.PessoaFisica;
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
public class ServicoMembroApoioTest {

    ServicoMembroApoio servico;
    PessoaFisica pf;
    PessoaFisica pfAux;
    MembroApoio membro;
    MembroApoio membroAux;
    DaoIF<MembroApoio> dao;
    FabricaDaoIF fabrica;

    @Before
    public void setUp() {


       servico = new ServicoMembroApoio(ProdutorEntityManagerDeTeste.getEntityManagerFactory().createEntityManager());

       pf = new PessoaFisica();
       pfAux = new PessoaFisica();
       
       membro = new MembroApoio();
       membroAux = new MembroApoio();
     
       pf.setCpf("123.123.123-36");       
       pfAux.setCpf("123.123.123-28");
       
       membro.setPessoaFisica(pf);
       membroAux.setPessoaFisica(pfAux);
       
    }

    @Test
    public void testarServicoPregao() {

        servico.criar(membro);
        servico.criar(membroAux);
        
        assertNotNull(membro.getId());
        assertNotNull(membroAux.getId());
        
        assertEquals(false, membro.equals(membroAux));
        
        assertEquals(2, servico.buscarTodos().size());
        
        servico.deletar(membro);
        servico.deletar(membroAux);

    }
    
   
    

}
