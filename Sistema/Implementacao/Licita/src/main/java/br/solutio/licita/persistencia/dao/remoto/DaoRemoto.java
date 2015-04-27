/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.persistencia.dao.remoto;

import br.solutio.licita.persistencia.dao.DaoAbstrato;
import br.solutio.licita.persistencia.dao.DaoIF;
import br.solutio.licita.persistencia.dao.FabricaDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author WitaloCarlos
 * @param <T>
 */
public class DaoRemoto<T> extends DaoAbstrato<T> implements DaoIF<T>{

    private static EntityManagerFactory emf; 
    protected EntityManager entityManager;
    
    
    
    public DaoRemoto(){
      
    }
    
     public DaoRemoto(Class<T> entidade){
        super(entidade);
       
    }
    
    @Override
    protected EntityManager getEntityManager() {
        if(emf == null){
            emf = Persistence.createEntityManagerFactory("Licita_PU_Remoto");
        }
        
        entityManager = emf.createEntityManager();
        return entityManager;
    }
    
}
