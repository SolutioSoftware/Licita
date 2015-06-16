/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.servico;

import br.solutio.licita.modelo.Item;
import br.solutio.licita.modelo.Pregao;
import br.solutio.licita.persistencia.DaoConsultarException;
import br.solutio.licita.persistencia.DaoIF;
import br.solutio.licita.persistencia.FabricaDAO;
import br.solutio.licita.persistencia.FabricaDaoIF;
import br.solutio.licita.util.ProdutorEntityManagerDeTeste;
import java.util.List;
import javax.persistence.RollbackException;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author WitaloCarlos
 */
public class ServicoItemTest {
    
    ServicoItem servico;
    Item item;
    Item itemAux;
    DaoIF<Item> dao;
    FabricaDaoIF fabrica;
    
    @Before
    public void setUp(){
        
        
        servico = new ServicoItem(ProdutorEntityManagerDeTeste.getEntityManagerFactory().createEntityManager());
        item = new Item();
        itemAux = new Item();
        
         
        item.setDescricao("Bla Bla Bla");
        item.setNome("Chocolate Blz");
        item.setUnidade("Unidade");
        
        itemAux.setDescricao("Bla Bla Bla");
        itemAux.setNome("Chocolate Blz");
        itemAux.setUnidade("Unidade");
    }
    
    
    @Test
    public void testeSalvar(){
        
        
        
        servico.criar(item);
        servico.criar(itemAux);
        
        assertNotNull(item.getId());
        assertNotNull(itemAux.getId());
        assertEquals(false, item.equals(itemAux));
        
        Long id = (long) 1;
        
        item = servico.buscarPorId(id);
        
        assertEquals(2, servico.buscarTodos().size());
        
        assertNotNull(item.getId());
        assertEquals(id, item.getId());
        assertEquals(true, item.getId().equals(id));
        
        item.setNome("ChocoliciaSz");
        
        servico.editar(item);
        
        
        
        assertEquals(false, item.getNome().equals(itemAux.getNome()));
        assertEquals(true, servico.buscarPorId(id).getNome().equals(item.getNome()));
        
    
        
        
        item = servico.buscarPorId(id);
                
        assertNotNull(item.getId());
        assertEquals(id, item.getId());
        assertEquals(true, item.getId().equals(id));
        
        servico.deletar(item);
        
         assertNull(servico.buscarPorId(id));
        
    }
        
    @Test(expected = IllegalArgumentException.class)
    public void cadastraObjetoNull() {
          servico.criar(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void editaObjetoNull() {
          servico.editar(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void deletaObjetoNull() {
          servico.deletar(null);
    }
    
    
   
    
   
    
}
