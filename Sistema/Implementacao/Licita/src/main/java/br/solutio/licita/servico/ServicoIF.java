/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.solutio.licita.servico;

import java.util.List;

/**
 *
 * @author Matheus Oliveira
 */
public interface ServicoIF<T>{

    /**
     * Retorna a quantidade de registros da entidade na base de dados.
     * @return contagem
     */
    public int contagem();
    
    /**
     * Cria um registro de uma entidade na base de dados.
     * @param entidade
     */
    public void criar(T entidade);
    
    /**
     * Modifica um registro de uma entidade na base de dados.
     * @param entidade
     */
    public void editar(T entidade);
    
    /**
     * Remove um registro de uma entidade na base de dados.
     * @param entidade
     */
    public void deletar(T entidade);
    

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
    
    /**
     * Faz consultas através das namedQuery declaradas nas entidades.
     * @param namedQuery o nome da namedQuery que deseja consultar
     * @param parametros Parametros da consulta na ordem que aparecem na namedQuery. Separe os argumentos com virgula.
     * @return lista de resultados da named query
     */
    public List<T> consultar(String namedQuery, Object... parametros);
    
}
