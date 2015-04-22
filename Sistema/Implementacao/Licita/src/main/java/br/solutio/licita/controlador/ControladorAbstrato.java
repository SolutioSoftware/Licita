/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.controlador;

import br.solutio.licita.modelo.Identificavel;
import br.solutio.licita.persistencia.dao.DaoAbstratoIF;
import java.util.List;

/**
 *
 * @author WitaloCarlos
 * @param <T>
 */

public abstract class ControladorAbstrato<T extends Identificavel> implements ControladorAbstratoIF{

    public abstract DaoAbstratoIF getDao();
    
    @Override
    public int contagem() {
        return getDao().contagem();
    }

    @Override
    public boolean criar(Identificavel entidade) {
        return getDao().criar(entidade);
    }

    @Override
    public boolean editar(Identificavel entidade) {
        return getDao().editar(entidade);
    }

    @Override
    public boolean deletar(Identificavel entidade) {
        return getDao().deletar(entidade);
    }

    @Override
    public Identificavel buscarPorId(Long id) {
        return getDao().buscarPorId(id);
    }

    @Override
    public List<Identificavel> buscarTodos() {
        return getDao().buscarTodos();
    }
    
    
    
}
