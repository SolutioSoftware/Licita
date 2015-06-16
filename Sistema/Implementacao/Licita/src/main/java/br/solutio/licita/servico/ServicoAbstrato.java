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
        } catch (IllegalStateException | RollbackException | IllegalArgumentException e) {

            GerenciadorTransacao.rollbackTransacao(getDao().getEntityManager());
            Logger.getLogger(ServicoAbstrato.class.getName()).log(Level.SEVERE, "Rollback na Camada Serviço: {0}", e.getMessage());

            if (e instanceof IllegalArgumentException) {
                throw new IllegalArgumentException("O objeto não pode ser nulo.");
            } else if (e instanceof IllegalArgumentException) {
                throw new IllegalStateException("Transação não pôde ser iniciada");
            } else if (e instanceof RollbackException) {
                throw new RollbackException("Rollback");
            }

        }

    }

    @Override
    public void editar(T entidade) {
        try {
            GerenciadorTransacao.abrirTransacao(getDao().getEntityManager());
            getDao().editar(entidade);
            GerenciadorTransacao.executarTransacao(getDao().getEntityManager());
        } catch (IllegalStateException | RollbackException | IllegalArgumentException e) {

            GerenciadorTransacao.rollbackTransacao(getDao().getEntityManager());
            Logger.getLogger(ServicoAbstrato.class.getName()).log(Level.SEVERE, "Exception na Camada Serviço: {0}", e.getMessage());
            
            if (e instanceof IllegalArgumentException) {
                throw new IllegalArgumentException("O objeto não pode ser nulo.");
            } else if (e instanceof IllegalArgumentException) {
                throw new IllegalStateException("Transação não pôde ser iniciada");
            } else if (e instanceof RollbackException) {
                throw new RollbackException("Rollback");
            }
            
        }
    }

    @Override
    public void deletar(T entidade) {
        try {
            GerenciadorTransacao.abrirTransacao(getDao().getEntityManager());
            getDao().deletar(entidade);
            GerenciadorTransacao.executarTransacao(getDao().getEntityManager());
        } catch (IllegalStateException | RollbackException | IllegalArgumentException e) {

            GerenciadorTransacao.rollbackTransacao(getDao().getEntityManager());
            Logger.getLogger(ServicoAbstrato.class.getName()).log(Level.SEVERE, "Exception na Camada Serviço: {0}", e.getMessage());

            if (e instanceof IllegalArgumentException) {
                throw new IllegalArgumentException("O objeto não pode ser nulo.");
            } else if (e instanceof IllegalArgumentException) {
                throw new IllegalStateException("Transação não pôde ser iniciada");
            } else if (e instanceof RollbackException) {
                throw new RollbackException("Rollback");
            }
            
        }

    }

    @Override
    public T buscarPorId(Long id) {
        return (T) getDao().buscarPorId(id);
    }

    @Override
    public abstract List<T> buscarTodos();

}
