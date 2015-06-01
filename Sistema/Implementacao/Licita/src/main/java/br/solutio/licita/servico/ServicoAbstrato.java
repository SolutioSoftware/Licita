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

    public abstract DaoIF getDao();

    @Override
    public int contagem() {
        return getDao().contagem();

    }

    @Override
    public void criar(T entidade) {
        try {
            GerenciadorTransacao.abrirTransacao(getDao().getEntityManager());
            getDao().criar(entidade);
            GerenciadorTransacao.executarTransacao(getDao().getEntityManager());
        } catch (Exception e) {
            GerenciadorTransacao.rollbackTransacao(getDao().getEntityManager());
            logger.log(Level.SEVERE, null, e);
            try {
                GerenciadorTransacao.rollbackTransacao(getDao().getEntityManager());
            } catch (RollbackException dbe) {
                logger.log(Level.SEVERE, null, dbe.getMessage());
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
            logger.log(Level.SEVERE, null, dbe.getMessage());
            try {
                GerenciadorTransacao.rollbackTransacao(getDao().getEntityManager());
            } catch (RollbackException e) {
                logger.log(Level.SEVERE, null, e.getMessage());
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
    public List<T> buscarTodos() {
        return getDao().buscarTodos();
    }

}
