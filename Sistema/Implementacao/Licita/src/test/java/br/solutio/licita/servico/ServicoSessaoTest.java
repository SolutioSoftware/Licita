/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.servico;

import br.solutio.licita.modelo.PessoaFisica;
import br.solutio.licita.modelo.Pregao;
import br.solutio.licita.modelo.Pregoeiro;
import br.solutio.licita.modelo.Sessao;
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
public class ServicoSessaoTest {

    ServicoSessao servico;
    Sessao sessao;
    Sessao sessaoAux;
    PessoaFisica pf;
    PessoaFisica pfAux;
    Pregoeiro membro;
    Pregoeiro membroAux;
    Pregao pregao;
    Pregao pregaoAux;
    DaoIF<Sessao> dao;
    FabricaDaoIF fabrica;

    @Before
    public void setUp() {


        servico = new ServicoSessao(ProdutorEntityManagerDeTeste.getEntityManagerFactory().createEntityManager());
        
        
       pf = new PessoaFisica();
       pfAux = new PessoaFisica();
       
       pregaoAux = new Pregao();

        pregao = new Pregao();
        pregaoAux = new Pregao();
        pregao.setDescricao("33344");
        pregao.setNumeroPregao("22111");
        pregao.setNumeroProcesso("5546464");
        pregao.setSincronizado(Boolean.TRUE);
        pregao.setStatusPregao("Aberto");
        
        pregao.setDescricao("22211");
        pregao.setNumeroPregao("34233");
        pregao.setNumeroProcesso("45434545");
        pregao.setSincronizado(Boolean.FALSE);
        pregao.setStatusPregao("Aberto");
       
       
       membro = new Pregoeiro();
       membroAux = new Pregoeiro();
     
       pf.setCpf("123.123.223-32");       
       pfAux.setCpf("123.223.123-23");
       
       membro.setPessoaFisica(pf);
       membroAux.setPessoaFisica(pfAux);
       
       sessao = new Sessao();
       sessaoAux = new Sessao();
       
       sessao.setIdPregao(pregao);
       sessao.setIdPregoeiro(membro);
       
       sessaoAux.setIdPregao(pregaoAux);
       sessaoAux.setIdPregoeiro(membroAux);
        
    }

    @Test(expected = IllegalStateException.class)
    public void testarServicoPregao() {
        
        servico = new ServicoSessao(ProdutorEntityManagerDeTeste.getEntityManagerFactory().createEntityManager());
        
        servico.criar(sessao);
        servico.criar(sessaoAux);
        
        assertNotNull(sessao.getId());
        assertNotNull(sessaoAux.getId());
        assertEquals(false, sessao.equals(sessaoAux));
        
        assertEquals(2, servico.buscarTodos().size());

    }
    
   
    

}
