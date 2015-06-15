/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.controlador;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author WitaloCarlos
 * @param <T>
 */
public interface ControladorAbstratoIF<T> extends Serializable{
    
 
    
    /**
     * Cria um registro de uma entidade na base de dados.
     * @param entidade
     * @return String que sera a pagian chamada
     */
    public String criar(T entidade);
    
    /**
     * Modifica um registro de uma entidade na base de dados.
     * @param entidade
     * @return String que sera a pagian chamada
     */
    public String editar(T entidade);
    
    /**
     * Remove um registro de uma entidade na base de dados.
     * @param entidade
     * @return String que sera a pagian chamada
     */
    public String deletar(T entidade);
    

    /**
     * Busca um registro de uma entidade na base de dados através do id.
     * @param id 
     * @return entidade do tipo Persistivel
     */
    public T buscarPorId(Long id);
    
    
     /**
     * Busca todos os registros de uma entidade na base de dados.
     * @return entidade do tipo Persistivel
     */
    public List<T> buscarTodos();
    
    public T getEntidade();
    
    public void setEntidade(T entidade);
    
    
    
    
    
    
    
    
    
}
