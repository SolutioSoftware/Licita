/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.controlador;

import br.solutio.licita.modelo.Identificavel;
import br.solutio.licita.servico.ServicoIF;
import java.util.List;

/**
 *
 * @author WitaloCarlos
 */

public abstract class ControladorAbstrato implements ControladorAbstratoIF{

    public abstract ServicoIF getServico();
    
    @Override
    public int contagem() {
        return getServico().contagem();
    }

    @Override
    public boolean criar(Identificavel entidade) {
        return getServico().criar(entidade);
    }

    @Override
    public boolean editar(Identificavel entidade) {
        return getServico().editar(entidade);
    }

    @Override
    public boolean deletar(Identificavel entidade) {
        return getServico().deletar(entidade);
    }

    @Override
    public Identificavel buscarPorId(Long id) {
        return getServico().buscarPorId(id);
    }

    @Override
    public List<Identificavel> buscarTodos() {
        return getServico().buscarTodos();
    }
    
    
    
}
