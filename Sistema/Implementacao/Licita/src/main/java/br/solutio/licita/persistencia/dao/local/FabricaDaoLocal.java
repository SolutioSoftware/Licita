/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.persistencia.dao.local;

import br.solutio.licita.persistencia.dao.FabricaDAO;

/**
 *
 * @author WitaloCarlos
 */
public class FabricaDaoLocal extends FabricaDAO implements FabricaDaoLocalIF {

    public FabricaDaoLocal() {
        
    }
    
    /**
     *
     * @return
     */
    @Override
    public DaoPregoeiro getDaoPregoeiro(){
        return new DaoPregoeiro();
    }
    
    /**
     *
     * @return
     */
    @Override
    public DaoInstituicaoLicitadora getDaoInstituicaoLicitadora(){
        return new DaoInstituicaoLicitadora();
    }
    
    /**
     *
     * @return
     */
    @Override
    public DaoLogin getDaoLogin(){
        return new DaoLogin();
    }
    
    
    
}
