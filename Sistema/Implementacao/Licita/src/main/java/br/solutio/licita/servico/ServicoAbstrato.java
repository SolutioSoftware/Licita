/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.servico;

import br.solutio.licita.persistencia.DaoIF;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import javax.persistence.TransactionRequiredException;
import org.eclipse.persistence.exceptions.DatabaseException;
import org.eclipse.persistence.exceptions.TransactionException;

/**
 *
 * @author Matheus Oliveira
 * @param <T>
 */
public abstract class ServicoAbstrato<T> implements ServicoIF<T> {

    protected static final Logger logger = Logger.getLogger(ServicoAbstrato.class.getName());
    
    private EntityManager entityManager;

    public abstract DaoIF<T> getDao();

    public ServicoAbstrato(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    
    public abstract void setDao(DaoIF<T> dao);

    
    
    protected void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    
    protected EntityManager getEntityManager() {
     
        return entityManager;
    }

    @Override
    public void criar(T entidade) {
        try {
            GerenciadorTransacao.abrirTransacao(getDao().getEntityManager());
            getDao().criar(entidade);
            GerenciadorTransacao.executarTransacao(getDao().getEntityManager());
        } catch (Exception e) {
            GerenciadorTransacao.rollbackTransacao(getDao().getEntityManager());
            Logger.getLogger(ServicoAbstrato.class.getName()).log(Level.SEVERE, null, e);
            try {
                GerenciadorTransacao.rollbackTransacao(getDao().getEntityManager());
            } catch (RollbackException dbe) {
                Logger.getLogger(ServicoAbstrato.class.getName()).log(Level.SEVERE, null, dbe);
            }
        }

    }

    @Override
    public void editar(T entidade) {
        try {
            GerenciadorTransacao.abrirTransacao(getDao().getEntityManager());
            getDao().editar(entidade);
            GerenciadorTransacao.executarTransacao(getDao().getEntityManager());
        } catch (DatabaseException | TransactionException | TransactionRequiredException dbe) {
            Logger.getLogger(ServicoAbstrato.class.getName()).log(Level.SEVERE, null, dbe);
            try {
                GerenciadorTransacao.rollbackTransacao(getDao().getEntityManager());
            } catch (RollbackException e) {
                Logger.getLogger(ServicoAbstrato.class.getName()).log(Level.SEVERE, null, e);
            }

        }
    }

    @Override
    public void deletar(T entidade) {
        GerenciadorTransacao.abrirTransacao(getDao().getEntityManager());
        getDao().deletar(entidade);
        GerenciadorTransacao.executarTransacao(getDao().getEntityManager());
    }

    @Override
    public T buscarPorId(Long id) {
        return (T) getDao().buscarPorId(id);
    }

    @Override
    public abstract List<T> buscarTodos();

}
