/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.solutio.licita.dao;

import br.solutio.licita.modelo.MembroApoio;
import br.solutio.licita.persistencia.DaoIF;
import br.solutio.licita.persistencia.FabricaDAO;
import br.solutio.licita.persistencia.FabricaDaoIF;
import br.solutio.licita.servico.GerenciadorTransacao;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Matheus Oliveira
 */
public class DaoMembroApoioTest extends DaoTestesAbstrato{
    
    private DaoIF<MembroApoio> dao;
    private MembroApoio membro;
    private FabricaDaoIF fabrica;
    
    @Before
    public void setUp(){
        membro = new MembroApoio();
        fabrica = new FabricaDAO(emf.createEntityManager());
        dao = fabrica.getDaoMembroApoio();
        
        membro.getPessoaFisica().setCpf("12312312512");
        membro.getPessoaFisica().setNome("Matheus");
        membro.getPessoaFisica().setRg("11221312");
        membro.setFuncao("Avaliador");
    }
    
    @Test
    public void teste(){
        GerenciadorTransacao.abrirTransacao(dao.getEntityManager());
        dao.criar(membro);
        GerenciadorTransacao.executarTransacao(dao.getEntityManager());
        
        assertEquals(true, membro.getId() == 1);
        assertEquals(true, dao.buscarPorId((long) 1).equals(membro));
        
        GerenciadorTransacao.abrirTransacao(dao.getEntityManager());
        membro.setFuncao("Aviador");
        dao.editar(membro);
        GerenciadorTransacao.executarTransacao(dao.getEntityManager());
        
        assertEquals(true, dao.buscarPorId((long) 1).getFuncao().equals(membro.getFuncao()));
        assertEquals(false, dao.buscarPorId((long) 1).getFuncao().equals("Avaliador"));
        assertEquals(true, dao.buscarPorId((long) 1).getFuncao().equals("Aviador"));
        
        GerenciadorTransacao.abrirTransacao(dao.getEntityManager());
        dao.deletar(membro);
        GerenciadorTransacao.executarTransacao(dao.getEntityManager());
        
        assertNull(dao.buscarPorId((long) 1));
    }
    
    @After
    public void tearDown(){
        GerenciadorTransacao.encerrarTransacoes(dao.getEntityManager());
    }
}
