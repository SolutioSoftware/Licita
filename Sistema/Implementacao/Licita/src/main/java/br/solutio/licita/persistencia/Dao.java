/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author WitaloCarlos
 * @param <T>
 */
public class Dao<T> implements DaoIF<T> {

    private Class<T> entidade;
    protected static final Logger logger = Logger.getGlobal();
    private EntityManager entityManager;

    public Dao(Class<T> entidade) {
        this.entidade = entidade;
    }

    public Dao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Dao() {
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }
    
    @Override
    public void setEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
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
    public void criar(T entidade) {
        logger.log(Level.INFO, "Criar");
        getEntityManager().persist(entidade);
        
    }

    @Override
    public void editar(T entidade) {
        logger.log(Level.INFO, "Editar");
        getEntityManager().merge(entidade);

    }

    @Override
    public void deletar(T entidade) {
        logger.log(Level.INFO, "Deletar");
        entidade = getEntityManager().merge(entidade);
        getEntityManager().remove(entidade);
    }

    @Override
    public T buscarPorId(Long id) {
        T entity = getEntityManager().find(this.entidade, id);
        return entity;
    }

    @Override
    public List<T> buscarTodos() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entidade));
        return getEntityManager().createQuery(cq).getResultList();
    }

    @Override
    public List<T> consultar(String namedQuery, String[] parametros, Object[] valores) {

        Query query = getEntityManager().createNamedQuery(namedQuery, entidade);

        List<T> list = new ArrayList<>();
        if (parametros != null && valores != null) {
            if (parametros.length == valores.length) {
                for (int i = 0; i < parametros.length; i++) {

                    query.setParameter(parametros[i], valores[i]);

                }
                list = query.getResultList();
                return list;
            } else {
                return list;
            }
        } else if (parametros == null && valores == null) {
            list = query.getResultList();
            return list;
        } else {
            return list;
        }

    }

}
