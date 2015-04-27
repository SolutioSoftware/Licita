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
     * Retorna a quantidade de registros da entidade na base de dados.
     * @return contagem
     */
    public int contagem();
    
    /**
     * Cria um registro de uma entidade na base de dados.
     * @param entidade
     * @return true caso a persistencia ocorra com sucesso; false caso contrário.
     */
    public boolean criar(T entidade);
    
    /**
     * Modifica um registro de uma entidade na base de dados.
     * @param entidade
     * @return true caso a persistencia ocorra com sucesso; false caso contrário.
     */
    public boolean editar(T entidade);
    
    /**
     * Remove um registro de uma entidade na base de dados.
     * @param entidade
     * @return true caso a persistencia ocorra com sucesso; false caso contrário.
     */
    public boolean deletar(T entidade);
    

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
