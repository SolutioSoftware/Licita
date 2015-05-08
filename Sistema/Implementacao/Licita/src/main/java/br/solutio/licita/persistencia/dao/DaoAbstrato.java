/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.persistencia.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author WitaloCarlos
 * @param <T>
 */
public abstract class DaoAbstrato<T> implements DaoIF<T> {

    private Class<T> entidade;
    protected static final Logger logger = Logger.getGlobal();

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
    public void criar(T entidade) {
        logger.log(Level.INFO, "Criar");
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(entidade);
        em.flush();
        tx.commit();
        em.close();
    }

    @Override
    public void editar(T entidade) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(entidade);
        em.flush();
        tx.commit();
        em.close();

    }

    @Override
    public void deletar(T entidade) {
        getEntityManager().remove(entidade);
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

    @Override
    public List<T> consultar(String namedQuery, String[] parametros, Object[] valores) {

        Query query = getEntityManager().createNamedQuery(namedQuery, entidade);

        if (parametros != null && valores != null) {
            if (parametros.length == valores.length) {
                for (int i = 0; i < parametros.length; i++) {

                    query.setParameter(parametros[i], valores[i]);

                }

                return query.getResultList();
            } else {
                return null;
            }
        } else if (parametros == null && valores == null) {
            return query.getResultList();
        } else {
            return null;
        }

    }

}
