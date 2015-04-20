/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.persistencia.dao.local;

import br.solutio.licita.modelo.Identificavel;
import br.solutio.licita.persistencia.dao.DaoAbstrato;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author WitaloCarlos
 * @param <T>
 */
public class DaoLocal<T extends Identificavel> extends DaoAbstrato<T> implements DaoLocalIF{

    protected EntityManagerFactory emf; 
    protected EntityManager entityManager;
    
    public DaoLocal(){
        this.emf = Persistence.createEntityManagerFactory("Licita_PU_Local");
        this.entityManager = emf.createEntityManager();
    }
    
    public DaoLocal(Class<T> entidade){
        super(entidade);
        this.emf = Persistence.createEntityManagerFactory("Licita_PU_Local");
        this.entityManager = emf.createEntityManager();
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
    
}
