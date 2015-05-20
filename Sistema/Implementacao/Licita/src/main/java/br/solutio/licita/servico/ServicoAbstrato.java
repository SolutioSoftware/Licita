/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.solutio.licita.servico;

import br.solutio.licita.persistencia.dao.DaoIF;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Matheus Oliveira
 * @param <T>
 */
public abstract class ServicoAbstrato<T> implements ServicoIF<T>{
    protected static final Logger logger = Logger.getGlobal();
    public abstract DaoIF getDao();

    @Override
    public int contagem() {
        return getDao().contagem();
    }
    
    
    @Override
    public void criar(T entidade) {
        try {
            getDao().criar(entidade);
        } catch (Exception e) {
            logger.info(e.getLocalizedMessage());
        }
        
    }

    
    @Override
    public void editar(T entidade) {
        getDao().editar(entidade);
    }
    
    
    @Override
    public void deletar(T entidade) {
        getDao().deletar(entidade);
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
