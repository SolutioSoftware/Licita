/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.persistencia.dao.local;

import br.solutio.licita.persistencia.dao.DaoAbstrato;
import br.solutio.licita.persistencia.dao.DaoIF;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author WitaloCarlos
 * @param <T>
 */
public class DaoLocal<T> extends DaoAbstrato<T> implements DaoIF<T>{

    private static EntityManagerFactory emf = null; 
    protected EntityManager entityManager;
    
    public DaoLocal(){
      
    }
    
    public DaoLocal(Class<T> entidade){
        super(entidade);
        
    }
    
    @Override
    protected EntityManager getEntityManager() {
        if (emf == null){
            emf = Persistence.createEntityManagerFactory("Licita_PU_Local");
        }
        
        entityManager = emf.createEntityManager();
        return entityManager;
    }
    
}
