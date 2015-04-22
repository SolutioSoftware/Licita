/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.controlador;

import br.solutio.licita.modelo.Identificavel;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author WitaloCarlos
 */
public interface ControladorAbstratoIF<T extends Identificavel> extends Serializable{
    
     /**
     * Retorna a quantidade de registros da entidade na base de dados.
     * @return contagem
     */
    public int contagem();
    
    /**
     * Cria um registro de uma entidade na base de dados.
     * @param entidade
     * @return true caso a persistencia ocorra com sucesso; false caso contrário.
     */
    public boolean criar(Identificavel entidade);
    
    /**
     * Modifica um registro de uma entidade na base de dados.
     * @param entidade
     * @return true caso a persistencia ocorra com sucesso; false caso contrário.
     */
    public boolean editar(Identificavel entidade);
    
    /**
     * Remove um registro de uma entidade na base de dados.
     * @param entidade
     * @return true caso a persistencia ocorra com sucesso; false caso contrário.
     */
    public boolean deletar(Identificavel entidade);
    

    /**
     * Busca um registro de uma entidade na base de dados através do id.
     * @param id 
     * @return entidade do tipo Identificavel
     */
    public Identificavel buscarPorId(Long id);
    
    
     /**
     * Busca todos os registros de uma entidade na base de dados.
     * @return entidade do tipo Identificavel
     */
    public List<Identificavel> buscarTodos();
    
    public T getEntidade();
    
    public void setEntidade(T entidade);
    
    
    
    
    
    
    
    
    
}
