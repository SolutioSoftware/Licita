/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.persistencia.dao;

import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author WitaloCarlos
 * @param <T>
 */
public abstract class DaoAbstrato<T> implements DaoIF<T> {

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
    public void criar(T entidade) {
        getEntityManager().persist(entidade);
    }

    @Override
    public void editar(T entidade) {
        getEntityManager().merge(entidade);

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
    public List<T> consultar(String namedQuery, Object... parametros) {

        Query query = getEntityManager().createNamedQuery(namedQuery, entidade.getClass());
        for (int i = 0; i > parametros.length; i++) {
            query.setParameter(i, parametros[i]);
        }

        return query.getResultList();
    }

}
