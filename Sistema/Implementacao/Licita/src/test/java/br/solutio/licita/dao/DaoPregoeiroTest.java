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
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Matheus Oliveira
 */
public class DaoPregoeiroTest extends DaoTestesAbstrato {

    private Pregoeiro pregoeiro;
    private Pregoeiro pregoeiroAux;
    private Pregoeiro pregoeiroEditar;
    private DaoIF<Pregoeiro> dao;
    private FabricaDaoIF fabrica;

    @Before
    public void setUp() {

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

        pregoeiroEditar = new Pregoeiro();
        pregoeiroEditar.getPessoaFisica().setCpf("06953601400");
        pregoeiroEditar.getPessoaFisica().setNome("Matheus");
        pregoeiroEditar.getPessoaFisica().setRg("35229");
        pregoeiroEditar.getLogin().setLogado(Boolean.TRUE);
        pregoeiroEditar.getLogin().setUsuario("admin");
        pregoeiroEditar.getLogin().setSenha("123");

        
        dao = new Dao<>(emf.createEntityManager());
    }

    @Test
    public void testeSalvar() {
        //Salvando Pregoeiros
        GerenciadorTransacao.abrirTransacao(dao.getEntityManager());
        dao.criar(pregoeiro);
        dao.criar(pregoeiroAux);
        GerenciadorTransacao.executarTransacao(dao.getEntityManager());

        //Verificando pregoeiro
        assertNotNull(pregoeiro.getId());
        assertNotNull(pregoeiroAux.getId());
        assertEquals(false, pregoeiro.equals(pregoeiroAux));

    }

    @Test
    public void testeEditarBuscar() {
        GerenciadorTransacao.abrirTransacao(dao.getEntityManager());
        dao.criar(pregoeiroEditar);
        GerenciadorTransacao.executarTransacao(dao.getEntityManager());
        
        GerenciadorTransacao.abrirTransacao(dao.getEntityManager());
        pregoeiroEditar.getPessoaFisica().setCpf("05434576623");
        dao.editar(pregoeiroEditar);
        GerenciadorTransacao.executarTransacao(dao.getEntityManager());
        
        assertEquals(true, pregoeiroEditar.getId() == 3);
        
    }
    
    @After
    public void tearDown(){
        GerenciadorTransacao.encerrarTransacoes(dao.getEntityManager());
    }

}
