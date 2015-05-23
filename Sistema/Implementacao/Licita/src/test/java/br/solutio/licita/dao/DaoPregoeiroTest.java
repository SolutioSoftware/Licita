/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.dao;

import br.solutio.licita.modelo.Pregoeiro;
import br.solutio.licita.persistencia.Dao;
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
public class DaoPregoeiroTest {

    private Pregoeiro pregoeiro;
    private Pregoeiro pregoeiroAux;
    private DaoIF<Pregoeiro> dao;
    private FabricaDaoIF fabrica;

    @Before
    public void setUp() {
        fabrica = new FabricaDAO(ProdutorEntityManager.getInstancia().getEmTestes());
        dao = fabrica.getDaoPregoeiro();
        dao.getEntityManager();
        pregoeiro = new Pregoeiro();
        pregoeiro.getPessoaFisica().setCpf("06953601400");
        pregoeiro.getPessoaFisica().setNome("Matheus");
        pregoeiro.getPessoaFisica().setRg("35229");
        pregoeiro.getLogin().setLogado(Boolean.TRUE);
        pregoeiro.getLogin().setUsuario("admin");
        pregoeiro.getLogin().setSenha("123");
        pregoeiro.getPessoaFisica().getEndereco().setCep("58500000");
        pregoeiro.getPessoaFisica().getEndereco().setCidade("Monteiro");
        pregoeiro.getPessoaFisica().getEndereco().setComplemento("1 andar");
        pregoeiro.getPessoaFisica().getEndereco().setEstado("PB");
        pregoeiro.getPessoaFisica().getEndereco().setLogradouro("Braz");
        pregoeiro.getPessoaFisica().getEndereco().setNumero(94);
        
        pregoeiroAux = new Pregoeiro();
        pregoeiroAux.getPessoaFisica().setCpf("06953601400");
        pregoeiroAux.getPessoaFisica().setNome("Matheus");
        pregoeiroAux.getPessoaFisica().setRg("35229");
        pregoeiroAux.getLogin().setLogado(Boolean.TRUE);
        pregoeiroAux.getLogin().setUsuario("admin");
        pregoeiroAux.getLogin().setSenha("123");


    }

    @Test
    public void testeSalvarEditarBuscar() {
        //Salvando Pregoeiros
        GerenciadorTransacao.abrirTransacao(dao.getEntityManager());
        dao.criar(pregoeiro);
        GerenciadorTransacao.encerrarTransacao(dao.getEntityManager());
        
        
        dao.setEntityManager(ProdutorEntityManager.getInstancia().getEmTestes());
        GerenciadorTransacao.abrirTransacao(dao.getEntityManager());
        dao.criar(pregoeiroAux);
        GerenciadorTransacao.encerrarTransacao(dao.getEntityManager());
        dao.setEntityManager(ProdutorEntityManager.getInstancia().getEmTestes());
        
        //Verificando pregoeiro
        assertEquals(true, pregoeiro.getId() == 1);
        assertEquals(false, pregoeiro.equals(pregoeiroAux));

        //Verificando pregoeiroAux
        assertEquals(false, pregoeiroAux.equals(pregoeiro));
        
        
        //Verificando edicao
        pregoeiroAux.getPessoaFisica().setCpf("12312312312");
        GerenciadorTransacao.abrirTransacao(dao.getEntityManager());
        dao.editar(pregoeiroAux);
        GerenciadorTransacao.encerrarTransacao(dao.getEntityManager());
        dao.setEntityManager(ProdutorEntityManager.getInstancia().getEmTestes());
        
        //Verificando remocao
        GerenciadorTransacao.abrirTransacao(dao.getEntityManager());
        dao.deletar(pregoeiro);
        GerenciadorTransacao.encerrarTransacao(dao.getEntityManager());
        dao.setEntityManager(ProdutorEntityManager.getInstancia().getEmTestes());
        
        GerenciadorTransacao.abrirTransacao(dao.getEntityManager());
        dao.deletar(pregoeiroAux);
        GerenciadorTransacao.encerrarTransacao(dao.getEntityManager());
        dao.setEntityManager(ProdutorEntityManager.getInstancia().getEmTestes());
        
    }

}
