/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.solutio.licita.dao.teste;

import br.solutio.licita.persistencia.dao.DaoAbstrato;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Matheus Oliveira
 */
public class DAOTestes<T> extends DaoAbstrato<T>{
    
    private EntityManagerFactory emf;
    private EntityManager em;
    private Logger logger = Logger.getGlobal();
    
    public DAOTestes(){
    }
    
    public DAOTestes(Class<T> entidade){
        super(entidade);
    }
    
    @Override
    public EntityManager getEntityManager() {
        if (emf == null){
            logger.log(Level.INFO, "EMF Teste");
            emf = Persistence.createEntityManagerFactory("Licita_PU_Teste");
        }
        
        em = emf.createEntityManager();
        return em;
    }
    
}
