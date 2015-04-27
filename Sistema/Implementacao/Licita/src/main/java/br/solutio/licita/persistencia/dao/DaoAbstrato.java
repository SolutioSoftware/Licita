/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.persistencia.dao;

import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author WitaloCarlos
 * @param <T>
 */
public abstract class DaoAbstrato<T> implements DaoIF<T>{
    
    private Class<T> entidade;
    static final Logger logger = Logger.getGlobal();
   

    /**
     *      
     * @return EntityManager
     */
    protected abstract EntityManager getEntityManager();

    
    
  
    public DaoAbstrato(Class<T> entidade) {
        this.entidade = entidade;
    }

    public DaoAbstrato() {
    }

    @Override
    public int contagem() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entidade);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    @Override
    public boolean criar(T entidade) {
        getEntityManager().persist(entidade);
        return true;
    }

    @Override
    public boolean editar(T entidade) {
        getEntityManager().merge(entidade);
        return true;
    }

    @Override
    public boolean deletar(T entidade) {
        getEntityManager().remove(entidade);      
        return true;
    }


    @Override
    public T buscarPorId(Long id) {
        return getEntityManager().find(entidade, id);
    }

    @Override
    public List<T> buscarTodos() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entidade));
        return getEntityManager().createQuery(cq).getResultList();
    }
    
}
