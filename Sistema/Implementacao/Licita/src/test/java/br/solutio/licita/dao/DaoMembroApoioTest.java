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
import br.solutio.licita.servico.ProdutorEntityManager;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Matheus Oliveira
 */
public class DaoMembroApoioTest {
    
    private DaoIF<MembroApoio> dao;
    private MembroApoio membro;
    private FabricaDaoIF fabrica;
    
    @Before
    public void setUp(){
        membro = new MembroApoio();
        fabrica = new FabricaDAO(ProdutorEntityManager.getInstancia().getEmTestes());
        dao = fabrica.getDaoMembroApoio();
        
        membro.getPessoaFisica().setCpf("12312312312");
        membro.getPessoaFisica().setNome("Matheus");
        membro.getPessoaFisica().setRg("11221312");
        membro.setFuncao("Avaliador");
        GerenciadorTransacao.abrirTransacao(dao.getEntityManager());
    }
    
    @Test
    public void teste(){
        dao.criar(membro);
        membro.setFuncao("Aviador");
//        dao.editar(membro);
//        dao.deletar(membro);
        GerenciadorTransacao.encerrarTransacao(dao.getEntityManager());
        assertEquals(true, membro.getId() == 1);
    }
}
