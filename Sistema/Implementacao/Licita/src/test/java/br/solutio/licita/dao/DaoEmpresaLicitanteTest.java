/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.solutio.licita.dao;

import br.solutio.licita.dao.teste.DAOTestes;
import br.solutio.licita.modelo.EmpresaLicitante;
import br.solutio.licita.modelo.EmpresaLicitantePK;
import br.solutio.licita.modelo.PessoaJuridica;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Matheus Oliveira
 */
public class DaoEmpresaLicitanteTest {
    
    private EmpresaLicitante empresaLicitante, empresaLicitanteAux;
    private EmpresaLicitante empresaLicitanteBusca;
    private DAOTestes<EmpresaLicitante> daoEmpresaLicitante;
    
    @Before
    public void setUp(){
        
        empresaLicitanteBusca = new EmpresaLicitante();
        
        empresaLicitante = new EmpresaLicitante();
        empresaLicitante.setComplemento("Empresa que vende cal");
        empresaLicitante.setInscricaoEstadual("1231237812");
        empresaLicitante.setTipoEmpresa("ME");
        empresaLicitante.getPessoaJuridica().setCnpj("123123123");
        empresaLicitante.getPessoaJuridica().setRazaoSocial("Alooohaa");
        empresaLicitante.getPessoaJuridica().setNomeFantasia("Real Auto");
        
        /**
        empresaLicitanteAux = new EmpresaLicitante();
        empresaLicitanteAux.setComplemento("Empresa que vende cal");
        empresaLicitanteAux.setInscricaoEstadual("1231237812");
        empresaLicitanteAux.setTipoEmpresa("ME");
        empresaLicitanteAux.getPessoaJuridica().setCnpj("123123123");
        empresaLicitanteAux.getPessoaJuridica().setRazaoSocial("Alooohaa");
        empresaLicitanteAux.getPessoaJuridica().setNomeFantasia("Real Auto");**/
        
        daoEmpresaLicitante = new DAOTestes<>();
    }
    
    @Test
    public void testeSalvar(){
        //Salvando empresaLicitante
        daoEmpresaLicitante.criar(empresaLicitante);
        //empresaLicitante.getEmpresaLicitantePK().setId(empresaLicitante.getPessoaJuridica().getId());
       // empresaLicitante.getEmpresaLicitantePK().setIdPessoaJuridica(empresaLicitante.getPessoaJuridica().getId());
        //daoEmpresaLicitante.editar(empresaLicitante.getPessoaJuridica());
        
        //Salvando empresaLicitanteAux
       // daoEmpresaLicitante.criar(empresaLicitanteAux.getPessoaJuridica());
        //empresaLicitanteAux.getEmpresaLicitantePK().setId(empresaLicitanteAux.getPessoaJuridica().getId());
        //empresaLicitanteAux.getEmpresaLicitantePK().setIdPessoaJuridica(empresaLicitanteAux.getPessoaJuridica().getId());
        //daoEmpresaLicitante.editar(empresaLicitanteAux.getPessoaJuridica());
        
        
        assertEquals(true ,empresaLicitante.getId() == 0);
        assertEquals(false ,empresaLicitante.getId() == 1);
        assertEquals(true ,empresaLicitante.getPessoaJuridica().getId() == 1);
    }
    
//    @Test
//    public void testeBuscarId(){
//        PessoaJuridica pessoa = new PessoaJuridica();
//        pessoa = (PessoaJuridica) daoEmpresaLicitante.buscarPorId(empresaLicitante.getPessoaJuridica().getId());
//        
//        assertEquals(true, pessoa.getId() == 1);
//    }
//    
    @Test
    public void testeDeletar(){
//        daoEmpresaLicitante.deletar(empresaLicitante.getPessoaJuridica());
        daoEmpresaLicitante.deletar(empresaLicitante);
//        assertEquals(true, empresaLicitante.getPessoaJuridica().getId() == null);
//        assertEquals(true, empresaLicitante.getId() == 0);
        
    }
    
    
}
