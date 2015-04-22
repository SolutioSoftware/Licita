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
    
    @Override
    public DaoLocalIF getDaoPregoeiro(){
        return new DaoPregoeiro();
    }
    
    @Override
    public DaoLocalIF getDaoInstituicaoLicitadora(){
        return new DaoInstituicaoLicitadora();
    }
    
    @Override
    public DaoLocalIF getDaoLogin(){
        return new DaoLogin();
    }
    
    
    
}
