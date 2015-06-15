/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.servico;

import br.solutio.licita.modelo.Pregao;
import br.solutio.licita.persistencia.DaoIF;
import br.solutio.licita.persistencia.FabricaDAO;
import br.solutio.licita.persistencia.FabricaDaoIF;
import br.solutio.licita.util.ProdutorEntityManagerDeTeste;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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


        servico = new ServicoPregao();

        pregaoAux = new Pregao();

        fabrica = new FabricaDAO(ProdutorEntityManagerDeTeste.getEntityManagerFactory().createEntityManager());

        dao = fabrica.getDaoPregao();
        servico.setDao(dao);

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
        
        Long id = (long) 1;
        
        pregao = servico.buscarPorId(id);
        
        assertNotNull(pregao.getId());
        assertEquals(id, pregao.getId());
        assertEquals(true, pregao.getId().equals(id));
        
        pregao.setNumeroPregao("2343");
        
        servico.editar(pregao);
        
        
        
        assertEquals(false, pregao.getNumeroPregao().equals(pregaoAux.getNumeroPregao()));
        assertEquals(true, servico.buscarPorId(id).getNumeroPregao().equals(pregao.getNumeroPregao()));
        
    
        
        
        pregao = servico.buscarPorId(id);
                
        assertNotNull(pregao.getId());
        assertEquals(id, pregao.getId());
        assertEquals(true, pregao.getId().equals(id));
        
        servico.deletar(pregao);
        
         assertNull(servico.buscarPorId(id));

    }

}
