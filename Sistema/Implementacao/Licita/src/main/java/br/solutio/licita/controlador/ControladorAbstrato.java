/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.controlador;

import br.solutio.licita.servico.ServicoIF;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author WitaloCarlos
 * @param <T>
 */

public abstract class ControladorAbstrato<T> implements ControladorAbstratoIF<T>{

    
    static final Logger logger = Logger.getGlobal();
            
    public abstract ServicoIF getServico();
   

    @Override
    public abstract String criar(T entidade);
    

    @Override
    public abstract String editar(T entidade);

    @Override
    public abstract String deletar(T entidade);

    @Override
    public T buscarPorId(Long id) {
        return (T) getServico().buscarPorId(id);
    }

    @Override
    public List<T> buscarTodos() {
        return getServico().buscarTodos();
    }
    
    
    
}
