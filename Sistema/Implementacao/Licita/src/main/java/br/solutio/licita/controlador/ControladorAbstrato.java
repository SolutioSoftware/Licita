/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.controlador;

import br.solutio.licita.servico.ServicoIF;
import java.util.List;

/**
 *
 * @author WitaloCarlos
 */

public abstract class ControladorAbstrato<T> implements ControladorAbstratoIF<T>{

    public abstract ServicoIF getServico();
    
    @Override
    public int contagem() {
        return getServico().contagem();
    }

    @Override
    public void criar(T entidade) {
        getServico().criar(entidade);
    }

    @Override
    public void editar(T entidade) {
        getServico().editar(entidade);
    }

    @Override
    public void deletar(T entidade) {
         getServico().deletar(entidade);
    }

    @Override
    public T buscarPorId(Long id) {
        return (T) getServico().buscarPorId(id);
    }

    @Override
    public List<T> buscarTodos() {
        return getServico().buscarTodos();
    }
    
    
    
}
