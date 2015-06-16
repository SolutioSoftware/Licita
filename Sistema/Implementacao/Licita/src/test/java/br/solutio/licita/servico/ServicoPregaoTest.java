/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.servico;

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
public class ServicoPregaoTest {

    ServicoPregao servico;
    Pregao pregao;
    Pregao pregaoAux;
    DaoIF<Pregao> dao;
    FabricaDaoIF fabrica;

    @Before
    public void setUp() {


        servico = new ServicoPregao(ProdutorEntityManagerDeTeste.getEntityManagerFactory().createEntityManager());

        pregaoAux = new Pregao();

        pregao = new Pregao();
        pregaoAux = new Pregao();
        pregao.setDescricao("33333");
        pregao.setNumeroPregao("11111");
        pregao.setNumeroProcesso("4646464");
        pregao.setSincronizado(Boolean.TRUE);
        pregao.setStatusPregao("Aberto");
        
        pregao.setDescricao("22222");
        pregao.setNumeroPregao("34443");
        pregao.setNumeroProcesso("23434545");
        pregao.setSincronizado(Boolean.FALSE);
        pregao.setStatusPregao("Aberto");
    }

    @Test
    public void testarServicoPregao() {

        servico.criar(pregao);
        servico.criar(pregaoAux);
        
        assertNotNull(pregao.getId());
        assertNotNull(pregao.getId());
        assertEquals(false, pregao.equals(pregaoAux));
        
        assertEquals(2, servico.buscarTodos().size());

    }
    
    @Test(expected = IllegalStateException.class)
    public void editarObjetoDuplicado() {
        pregao.setNumeroPregao("1232");
        pregaoAux.setNumeroPregao("1232");
        servico.editar(pregao);
        servico.editar(pregaoAux);
    }
    
    @Test(expected = IllegalStateException.class)
    public void cadastraObjetoDuplicado() {
        pregao.setNumeroPregao("1232");
        pregaoAux.setNumeroPregao("1232");
        servico.criar(pregao);
        servico.criar(pregaoAux);
        
        servico.deletar(pregao);
        servico.deletar(pregaoAux);
    }
    
   
    @Test(expected = IllegalStateException.class)
    public void deletaObjetoDuplicado() {
        
        servico.criar(pregao);
     
        
        servico.deletar(pregao);
        servico.deletar(pregao);
     
    }
    
    

}
