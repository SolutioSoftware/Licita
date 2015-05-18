/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.solutio.licita.servico;

import br.solutio.licita.modelo.Pregao;
import br.solutio.licita.persistencia.dao.local.DaoLocal;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 *
 * @author Matheus Oliveira
 */
public class ServicoPregaoTest {
    
    private ServicoPregao servico = new ServicoPregao();
    private DaoLocal<Pregao> daoMock = Mockito.mock(DaoLocal.class);
    private Pregao pregao, pregaoAux;

    @Before
    public void setUp(){
        servico.setDao(daoMock);
        pregao = new Pregao();
        pregaoAux = new Pregao();
        pregao.setDescricao("33333");
        pregao.setNumeroPregao("11111");
        pregao.setNumeroProcesso("4646464");
        pregao.setSincronizado(Boolean.TRUE);
        pregao.setStatusPregao("Aberto");
    }
    
    @Test
    public void testarServicoLogin(){
        servico.criar(pregao);
        assertEquals(true, pregao.equals(pregaoAux));
        
    }
    
    
    
}
