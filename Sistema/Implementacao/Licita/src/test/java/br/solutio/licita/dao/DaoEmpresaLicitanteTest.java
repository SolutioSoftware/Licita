/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.dao;

import br.solutio.licita.modelo.EmpresaLicitante;
import br.solutio.licita.persistencia.Dao;
import br.solutio.licita.persistencia.DaoIF;
import br.solutio.licita.persistencia.FabricaDAO;
import br.solutio.licita.servico.GerenciadorTransacao;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Matheus Oliveira
 */
public class DaoEmpresaLicitanteTest extends DaoTestesAbstrato{

    private EmpresaLicitante empresaLicitante;
    private DaoIF<EmpresaLicitante> daoEmpresaLicitante;
    private FabricaDAO fabrica;

    @Before
    public void setUp() {

        empresaLicitante = new EmpresaLicitante();
        empresaLicitante.setComplemento("Empresa que vende cal");
        empresaLicitante.setInscricaoEstadual("1231237812");
        empresaLicitante.setTipoEmpresa("ME");
        empresaLicitante.getPessoaJuridica().setCnpj("123123123");
        empresaLicitante.getPessoaJuridica().setRazaoSocial("Alooohaa");
        empresaLicitante.getPessoaJuridica().setNomeFantasia("Real Auto");
        empresaLicitante.getRepresentanteLegal().getPessoaFisica().setCpf("12345678900");
        empresaLicitante.getRepresentanteLegal().getPessoaFisica().setNome("Mahtues");
        empresaLicitante.getRepresentanteLegal().getPessoaFisica().setRg("1231231");
        empresaLicitante.getContaBancaria().setAgencia("3315");
        empresaLicitante.getContaBancaria().setBanco(102);
        empresaLicitante.getContaBancaria().setNome("CEF");
        empresaLicitante.getContaBancaria().setNumeroConta("102933");
        empresaLicitante.getContaBancaria().setOperacao("013");

       
        daoEmpresaLicitante = new Dao<>(emf.createEntityManager());
    }

    @Test
    public void testeSalvar() {
        GerenciadorTransacao.abrirTransacao(daoEmpresaLicitante.getEntityManager());

        daoEmpresaLicitante.criar(empresaLicitante);
        GerenciadorTransacao.executarTransacao(daoEmpresaLicitante.getEntityManager());
        
        assertEquals(true, empresaLicitante.getId() == 1);
        assertEquals(true, empresaLicitante.getPessoaJuridica().getId() == 1);
    }
    
    @After
    public void tearDown(){
        GerenciadorTransacao.encerrarTransacoes(daoEmpresaLicitante.getEntityManager());
    }
    

}
