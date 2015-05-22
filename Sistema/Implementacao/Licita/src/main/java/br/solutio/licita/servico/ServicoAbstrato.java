/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.solutio.licita.servico;

import br.solutio.licita.persistencia.DaoIF;
import java.util.List;
import java.util.logging.Logger;
import org.eclipse.persistence.exceptions.DatabaseException;

/**
 *
 * @author Matheus Oliveira
 * @param <T>
 */
public abstract class ServicoAbstrato<T> implements ServicoIF<T> {
    
    protected static final Logger logger = Logger.getGlobal();

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
            System.out.println("Salvo com sucessoooo");
            GerenciadorTransacao.encerrarTransacao(getDao().getEntityManager());
        } catch (Exception e) {
            GerenciadorTransacao.rollbackTransacao(getDao().getEntityManager());
            logger.info(e.getLocalizedMessage());
        }
        
    }
    
    @Override
    public void editar(T entidade) {
        try {
            GerenciadorTransacao.abrirTransacao(getDao().getEntityManager());
            getDao().editar(entidade);
            GerenciadorTransacao.encerrarTransacao(getDao().getEntityManager());
        } catch (DatabaseException dbe) {
            GerenciadorTransacao.rollbackTransacao(getDao().getEntityManager());
        }
    }
    
    @Override
    public void deletar(T entidade) {
        GerenciadorTransacao.abrirTransacao(getDao().getEntityManager());
        getDao().deletar(entidade);
        GerenciadorTransacao.encerrarTransacao(getDao().getEntityManager());
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
