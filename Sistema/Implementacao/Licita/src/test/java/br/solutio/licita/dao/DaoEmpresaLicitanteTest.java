/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.solutio.licita.dao;

import br.solutio.licita.dao.teste.DAOTestes;
import br.solutio.licita.modelo.EmpresaLicitante;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Matheus Oliveira
 */
public class DaoEmpresaLicitanteTest {
    
    private EmpresaLicitante empresaLicitante;
    private DAOTestes<EmpresaLicitante> daoEmpresaLicitante;
    
    @Before
    public void setUp(){
        
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
        
        daoEmpresaLicitante = new DAOTestes<>();
    }
    
    @Test
    public void testeSalvar(){
        daoEmpresaLicitante.criar(empresaLicitante);
        assertEquals(true ,empresaLicitante.getId() == 1);
        assertEquals(true ,empresaLicitante.getPessoaJuridica().getId() == 1);
    }
    
}
