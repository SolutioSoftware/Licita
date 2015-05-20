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
        
        daoEmpresaLicitante = new DAOTestes<>();
    }
    
    @Test
    public void testeSalvar(){
        daoEmpresaLicitante.criar(empresaLicitante);
        assertEquals(true ,empresaLicitante.getId() == 0);
        assertEquals(false ,empresaLicitante.getId() == 1);
        assertEquals(true ,empresaLicitante.getPessoaJuridica().getId() == 2);
    }
    
    @Test
    public void testeEditar(){
        empresaLicitante.setTipoEmpresa("MEI");
        daoEmpresaLicitante.editar(empresaLicitante);
        assertEquals(true, empresaLicitante.getTipoEmpresa().equals("MEI"));
    }
    
    @Test
    public void testeDeletar(){
        daoEmpresaLicitante.deletar(empresaLicitante);
    }
    
    
}
