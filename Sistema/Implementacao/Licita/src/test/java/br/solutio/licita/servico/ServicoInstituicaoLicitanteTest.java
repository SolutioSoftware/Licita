/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.servico;

import br.solutio.licita.main.Licita;
import br.solutio.licita.modelo.EmpresaLicitante;
import br.solutio.licita.modelo.InstituicaoLicitadora;
import br.solutio.licita.modelo.PessoaJuridica;
import br.solutio.licita.modelo.Pregao;
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
public class ServicoInstituicaoLicitanteTest {

    ServicoLicitante servico;
    PessoaJuridica pj;
    PessoaJuridica pjAux;
    EmpresaLicitante instituicao;
    EmpresaLicitante instituicaoAux;
    DaoIF<EmpresaLicitante> dao;
    FabricaDaoIF fabrica;

    @Before
    public void setUp() {


       servico = new ServicoLicitante(ProdutorEntityManagerDeTeste.getEntityManagerFactory().createEntityManager());

       instituicao = new EmpresaLicitante();
       instituicaoAux = new EmpresaLicitante();
       
       pj = new PessoaJuridica();
       pjAux = new PessoaJuridica();
       
       pj.setCnpj("123.123.123/1234-46");       
       pjAux.setCnpj("123.123.123/1234-44");
       
       instituicao.setPessoaJuridica(pj);
       instituicaoAux.setPessoaJuridica(pjAux);
       
    }

    @Test
    public void testarServicoPregao() {

        servico.criar(instituicao);
        servico.criar(instituicaoAux);
        
        assertNotNull(instituicao.getId());
        assertNotNull(instituicaoAux.getId());
        
        assertEquals(false, instituicao.equals(instituicaoAux));
        
        assertEquals(2, servico.buscarTodos().size());
        
        servico.deletar(instituicao);
        servico.deletar(instituicaoAux);

    }
    
   
    

}
