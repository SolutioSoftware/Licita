/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.solutio.licita.servico;

import br.solutio.licita.persistencia.dao.DaoIF;
import java.util.List;

/**
 *
 * @author Matheus Oliveira
 * @param <T>
 */
public abstract class ServicoAbstrato<T> implements ServicoIF<T>{
    
    public abstract DaoIF getDao();

    @Override
    public int contagem() {
        return getDao().contagem();
    }

    @Override
    public boolean criar(T entidade) {
        return getDao().criar(entidade);
    }

    @Override
    public boolean editar(T entidade) {
        return getDao().editar(entidade);
    }

    @Override
    public boolean deletar(T entidade) {
        return getDao().deletar(entidade);
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
