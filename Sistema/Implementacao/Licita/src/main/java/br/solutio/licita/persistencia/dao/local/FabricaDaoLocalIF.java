/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.persistencia.dao.local;

/**
 *
 * @author WitaloCarlos
 */
public interface FabricaDaoLocalIF {

    DaoLocalIF getDaoInstituicaoLicitadora();

    DaoLocalIF getDaoLogin();

    DaoLocalIF getDaoPregoeiro();
    
}
