/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.dao;

import br.solutio.licita.modelo.Pregao;
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
public class DaoPregaoTest {
    
    private DaoIF<Pregao> dao;
    private FabricaDaoIF fabrica;
    private Pregao pregao;
    private Pregao pregao2, pregaoVazio, pregaoAtualizado;
    
    @Before
    public void setUp() {
        fabrica = new FabricaDAO(ProdutorEntityManager.getInstancia().getEmTestes());
        dao = fabrica.getDaoPregao();
        pregao = new Pregao();
        pregao2 = new Pregao();
        pregaoVazio = new Pregao();
        pregaoAtualizado = new Pregao();
        
        pregao.setDescricao("vai começar a ccyber lluta");
        pregao.setNumeroPregao("123123");
        pregao.setNumeroProcesso("74367463");
        pregao.setStatusPregao("Aberto");
        pregao.setSincronizado(Boolean.TRUE);
        
        pregao2.setDescricao("vai terminar a ccyber lluta");
        pregao2.setNumeroPregao("1111");
        pregao2.setNumeroProcesso("76666");
        pregao2.setStatusPregao("Fechado");
        pregao2.setSincronizado(Boolean.FALSE);
    }
    
    @Test
    public void salvarPregao() {
        //Salvando no banco(HSQL) os pregoes.
        GerenciadorTransacao.abrirTransacao(dao.getEntityManager());
        dao.criar(pregao);
        GerenciadorTransacao.encerrarTransacao(dao.getEntityManager());
        dao.setEntityManager(ProdutorEntityManager.getInstancia().getEmTestes());
        
        GerenciadorTransacao.abrirTransacao(dao.getEntityManager());
        dao.criar(pregao2);
        GerenciadorTransacao.encerrarTransacao(dao.getEntityManager());
        dao.setEntityManager(ProdutorEntityManager.getInstancia().getEmTestes());
        /**
         * 1 - Falso, caso o pregao2.id = pregao.id
         * 2 - Verdade, caso o pregao2.id <> pregao.id
         * 3 - Falso, pregao2 for igual ao pregaoVazio
         * 4 - Falso, pregao for igual ao pregaoAtualizado
         */
        assertEquals(false, pregao2.equals(pregao));
        assertEquals(true, !pregao2.equals(pregao));
        assertEquals(false, pregao2.equals(pregaoVazio));
        assertEquals(false, pregao.equals(pregaoAtualizado));
        
        
        //Atualizando os valores de PRegao2
        pregao2.setDescricao("eu quero mudança meu filho");
        pregao2.setSincronizado(Boolean.TRUE);
        GerenciadorTransacao.abrirTransacao(dao.getEntityManager());
        dao.editar(pregao2);
        GerenciadorTransacao.encerrarTransacao(dao.getEntityManager());
        dao.setEntityManager(ProdutorEntityManager.getInstancia().getEmTestes());
        
        //Verificando buscaPorId
//        pregaoAtualizado = dao.buscarPorId(pregao2.getId());
//        assertEquals(true, pregao2.equals(pregaoAtualizado));
        
        //Verificando remocao do banco
        GerenciadorTransacao.abrirTransacao(dao.getEntityManager());
        dao.deletar(pregao);
        GerenciadorTransacao.encerrarTransacao(dao.getEntityManager());
        
        dao.setEntityManager(ProdutorEntityManager.getInstancia().getEmTestes());
        GerenciadorTransacao.abrirTransacao(dao.getEntityManager());
        dao.deletar(pregao2);
        GerenciadorTransacao.encerrarTransacao(dao.getEntityManager());
        
        assertEquals(true, !pregao.equals(pregaoVazio));
        assertEquals(false, pregao.equals(pregao2));
        assertEquals(false, pregao.equals(pregaoVazio));
        assertEquals(false, pregao2.equals(pregaoVazio));
        
    }
    
}
